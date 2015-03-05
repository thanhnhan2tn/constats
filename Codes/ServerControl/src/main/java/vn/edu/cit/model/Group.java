package vn.edu.cit.model;

import java.util.List;

/**
 * Class Group is e model of Group table in DB
 * 
 * @author Thanh
 *
 */
public class Group {
	private int groupId;
	private String groupName;
	private List<User> users;

	public int getGroupId() {
		return groupId;
	}
	
	
	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
