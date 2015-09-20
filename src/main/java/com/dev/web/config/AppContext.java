package com.dev.web.config;

import java.sql.Driver;
import java.util.Properties;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.ValidationMode;
import javax.sql.DataSource;
import javax.sql.XADataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.atomikos.icatch.config.UserTransactionService;
import com.atomikos.icatch.config.UserTransactionServiceImp;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.atomikos.jdbc.nonxa.DriverManagerDataSource;
import com.dev.web.dao.UserDAO;
import com.dev.web.service.UserDataService;
import com.dev.web.service.impl.UserDataServiceImpl;

@Configuration
@EnableTransactionManagement
@ComponentScan({"com.dev.web"})
public class AppContext {

	@Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
	
	
	 
	@Bean
     public DataSource getDataSource() {
             //DriverManagerDataSource dataSource = new DriverManagerDataSource();
              
		 AtomikosDataSourceBean ds = new AtomikosDataSourceBean(); 
		 ds.setUniqueResourceName("oracle"); 
		 ds.setXaDataSourceClassName("oracle.jdbc.xa.client.OracleXADataSource"); 
		 Properties p = new Properties(); 
		 p.setProperty ( "user" , "devcore" ); 
		 p.setProperty ( "password" , "devcore" ); 
		 p.setProperty ( "URL" , "jdbc:oracle:thin:@localhost:1521:XE" ); 
		 ds.setXaProperties(p); 
		 ds.setPoolSize ( 5 ); 
              
             return ds;
     }
	private DataSource getJNDIdataSource() {
        XADataSource dataSource = null;
        try {
            
            InitialContext ctx = new InitialContext();
            dataSource = (XADataSource) ctx.lookup("java:comp/env/jdbc/devcore");
        } catch (NamingException e) {
           
            new RuntimeException(e);
        }
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setUniqueResourceName("oracle");
        ds.setXaDataSource(dataSource);
        return ds;
    }

    

    @Bean
    public UserTransactionService userTransactionService() {
        UserTransactionServiceImp userTransactionServiceImp = new UserTransactionServiceImp();
        Properties properties = new Properties();
        properties.put("com.atomikos.icatch.serial_jta_transactions", "false");
        properties.put("com.atomikos.icatch.enable_logging", "false");
        properties.put("com.atomikos.icatch.log_base_dir", "/tx"); // default, need to be configurable to SAN in prod
        userTransactionServiceImp.init(properties);
        return userTransactionServiceImp;
    }

    @Bean
    @DependsOn("userTransactionService")
    public PlatformTransactionManager txManager() throws Throwable {
        AtomikosJtaPlatform jtaPlatform = this.atomikosJtaPlatform();
        JtaTransactionManager transactionManager = new JtaTransactionManager();
        transactionManager.setTransactionManager(jtaPlatform.getAtomikosTransactionManager());
        transactionManager.setUserTransaction(jtaPlatform.getAtomikosUserTransaction());
        return transactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
        localContainerEntityManagerFactoryBean.setPackagesToScan("com.dev.web.bean");

        JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter);
        localContainerEntityManagerFactoryBean.setValidationMode(ValidationMode.NONE);
        localContainerEntityManagerFactoryBean.setJpaProperties(additionalProperties());
        return localContainerEntityManagerFactoryBean;
    }

    @Bean
    public DataSource dataSource() {
        return getDataSource();
    }
    
    @Bean
    @DependsOn({"userTransactionService", "txManager"})
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        return new Properties() {

            private static final long serialVersionUID = 4240657154170582110L;

            {
                //setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
                setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
                setProperty("hibernate.transaction.jta.platform", "com.dev.web.config.AtomikosJtaPlatform");
                setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.CMTTransactionFactory");
                setProperty("hibernate.current_session_context_class", "jta");
                setProperty("hibernate.show_sql", "false");
                setProperty("hibernate.format_sql", "false");
            }
        };
    }

    @Bean
    public AtomikosJtaPlatform atomikosJtaPlatform() {
        return new AtomikosJtaPlatform();
    }

    @Bean
    public TransactionTemplate transactionTemplate() throws Throwable {
        return new TransactionTemplate(this.txManager());
    }
	
    @Resource
    private UserDAO userDao;
    
    @Bean
    public UserDataService userDataService() {
        UserDataService svc = new UserDataServiceImpl(userDao);
        return svc;
    }
}
