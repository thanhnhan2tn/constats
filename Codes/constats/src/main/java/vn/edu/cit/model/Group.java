package vn.edu.cit.model;

/**
 * Class Group is e model of Group table in DB
 * 
 * @author Thanh
 *
 */
public class Group {
	private int groupId;
	private String groupName;

	public int getGroupId() {
		return groupId;
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
