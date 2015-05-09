package vn.edu.cit.dao;

import java.util.List;

import vn.edu.cit.model.Log;

public interface LogDAO {

	public void createLog(Log log);

	public Log getLog(String date);
	
	public List<Log> getAllLogs();
}
