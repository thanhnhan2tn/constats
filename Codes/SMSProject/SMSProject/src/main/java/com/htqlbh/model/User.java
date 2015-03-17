/*
 * Class name:
 * 
 * Version information:
 *
 * Date: 10-July-2014
 * 
 * Copyright notice: none
 * 
 * Modification Logs:
 *     DATE         AUTHOR             DESCRIPTION
 *  --------------------------------------------------------
 *  10-July-2014    XXXXXX          Create java class file
 */
package com.htqlbh.model;

/**
 * The Class User.
 */
public class User implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 320485228438013407L;

	/** The user id. */
    private int userId;
    
    /** The group user. */
    private GroupUser groupUser;
    
    /** The user name. */
    private String userName;
    
    /** The password. */
    private String password;

    /**
     * The Constructor.
     */
    public User() {
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public int getUserId() {
	return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
	this.userId = userId;
    }

    /**
     * Gets the group user.
     *
     * @return the group user
     */
    public GroupUser getGroupUser() {
	return groupUser;
    }

    /**
     * Sets the group user.
     *
     * @param groupUser the group user
     */
    public void setGroupUser(GroupUser groupUser) {
	this.groupUser = groupUser;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public String getUserName() {
	return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName the user name
     */
    public void setUserName(String userName) {
	this.userName = userName;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
	return password;
    }

    /**
     * Sets the password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
	this.password = password;
    }

}
