package vn.edu.cit.dao;

import vn.edu.cit.model.ServerStatus;

public interface ServerStatusDAO {
	public void createServerStatus(ServerStatus	status);

	public ServerStatus getServerStatus(String ip);

	public void updateServerStatus(ServerStatus status);
}
