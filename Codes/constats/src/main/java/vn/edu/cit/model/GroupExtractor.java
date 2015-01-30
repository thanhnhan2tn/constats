package vn.edu.cit.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

@SuppressWarnings("rawtypes")
public class GroupExtractor implements ResultSetExtractor{
	@Override
	public Object extractData(ResultSet rs) throws SQLException{
		Group group = new Group();
		group.setGroupId(rs.getInt("groupId"));
		group.setGroupName(rs.getString("groupName"));
		return group;
	}
}
