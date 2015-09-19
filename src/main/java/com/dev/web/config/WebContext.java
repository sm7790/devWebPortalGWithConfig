package com.dev.web.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module.Feature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;


@EnableWebMvc
@Configuration
@ComponentScan({"com.dev.web.controller"})
public class WebContext extends WebMvcConfigurerAdapter  {

	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
        .addResourceLocations("/resources/");
    }
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
 
    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        return bean;
    }
	
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        

        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        Hibernate4Module module = new Hibernate4Module();
        module.disable(Feature.USE_TRANSIENT_ANNOTATION);
        builder.indentOutput(true).modules(module, new JSR310Module()).serializationInclusion(Include.NON_EMPTY)
                .dateFormat(dateFormat).propertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));

        Jaxb2RootElementHttpMessageConverter jaxConverter = new Jaxb2RootElementHttpMessageConverter();
        converters.add(jaxConverter);
    }
}
