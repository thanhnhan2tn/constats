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

import java.util.HashSet;
import java.util.Set;

/**
 * The Class GroupUser.
 */
public class GroupUser implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2520927337519620309L;

	/** The group id. */
    private int groupId;
    
    /** The group name. */
    private String groupName;
    
    /** The description. */
    private String description;
    
    /** The users. */
    private Set<User> users = new HashSet<User>(0);

    /**
     * The Constructor.
     */
    public GroupUser() {
    }

    /**
     * Gets the group id.
     *
     * @return the group id
     */
    public int getGroupId() {
	return groupId;
    }

    /**
     * Sets the group id.
     *
     * @param groupId the group id
     */
    public void setGroupId(int groupId) {
	this.groupId = groupId;
    }

    /**
     * Gets the group name.
     *
     * @return the group name
     */
    public String getGroupName() {
	return groupName;
    }

    /**
     * Sets the group name.
     *
     * @param groupName the group name
     */
    public void setGroupName(String groupName) {
	this.groupName = groupName;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * Sets the description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * Gets the users.
     *
     * @return the users
     */
    public Set<User> getUsers() {
	return users;
    }

    /**
     * Sets the users.
     *
     * @param users the users
     */
    public void setUsers(Set<User> users) {
	this.users = users;
    }

}
