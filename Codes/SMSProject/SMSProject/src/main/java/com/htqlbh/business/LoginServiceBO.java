/*
 * Class name: LoginServiceBO
 * 
 * Version information: 1.0
 *
 * Date: 1-August-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE           AUTHOR                   DESCRIPTION
 *  --------------------------------------------------------
 * 1-August-2014  Tran Trong Nghia          Service for Login
 */
package com.htqlbh.business;

import com.htqlbh.dao.UserDAO;
import com.htqlbh.model.User;

/**
 * The Class LoginServiceBO.
 * 
 * @author Tran Trong Nghia
 */
public class LoginServiceBO {

    /** The user dao. */
    private UserDAO userDAO;

    /**
     * The Constructor.
     */
    public LoginServiceBO() {
	userDAO = new UserDAO();
    }

    /**
     * Validate user - kiem tra user va password
     * 
     * @return true, if validate user
     */
    public boolean validateUser(String userName, String password) {
	User tmp_User = userDAO.findByUserName(userName);
	if ((userName == null) || (password == null)) {
	    return false;
	} else if ((tmp_User != null)
		&& (password.equals(tmp_User.getPassword()))) {
	    return true;
	} else {
	    return false;
	}

    }
}
