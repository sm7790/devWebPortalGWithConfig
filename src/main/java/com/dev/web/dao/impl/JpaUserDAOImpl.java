package com.dev.web.dao.impl;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;

import org.springframework.stereotype.Component;

import com.dev.web.bean.User;
import com.dev.web.dao.UserDAO;
import com.dev.web.exception.DAOException;

@Component
public class JpaUserDAOImpl extends JpaDAO<User>implements UserDAO {
	
	public JpaUserDAOImpl(){
		super(User.class);
	}
	
	@Override
    public User create(User entityBean) {
        User user = null;
        try {
            user = super.create(entityBean);
        } catch (PersistenceException e) {
            if (e.getCause() != null && e.getCause().getClass().equals(ConstraintViolationException.class)) {
                
                } else {
                    // unknown generic problem
                    throw new DAOException("unexpected PersistenceException", e);
                }

            
        }
        return user;
    }
}

