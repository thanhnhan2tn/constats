package vn.edu.cit.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;

public class ServerExtractor implements ResultSetExtractor {
	@Override
	public Object extractData(ResultSet rs) throws SQLException {
		List<Server> servers = new ArrayList<Server>();
		while (rs.next()) {
			Server sv;
		}
		return servers;
	}
}
