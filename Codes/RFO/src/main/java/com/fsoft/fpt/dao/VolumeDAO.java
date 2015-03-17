package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.Volume;

public class VolumeDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public VolumeDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Volume create(Volume volume) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "insert into volume value (null, ?, ?)";
		jdbcTemplateObject.update(sql, new Object[] {volume.getTriggerCredit(), volume.getPaymentTo()});
		int volumeId = jdbcTemplateObject.queryForInt("select max(volumeid) from volume");
		volume.setVolumeId(volumeId);
		return volume;
	}

	public Volume get(int volumeId) {
		List<Volume> volumes = new ArrayList<Volume>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from volume where volumeId = " + volumeId;
		volumes = jdbcTemplateObject.query(sql, new VolumeExtractor());
		if (volumes.isEmpty() == true) {
			return new Volume();
		} else {
			return volumes.get(0);
		}
	}
	
	/**
	 * @author Luong Duc Duy
	 * TODO Update volume by volumeId
	 */
	public Volume update(Volume volume) {
		List<Volume> volumes = new ArrayList<Volume>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "update volume set TriggerCredit = ?, PaymentTo = ? where volumeId = ?";
		System.out.println("volume id = " + volume.getVolumeId());
		jdbcTemplateObject.update(sql, new Object[]{volume.getTriggerCredit(), volume.getPaymentTo(), volume.getVolumeId()});
		return volume;
	}

	public List<Volume> list() {
		List<Volume> volumes = new ArrayList<Volume>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from volume where";
		volumes = jdbcTemplateObject.query(sql, new VolumeExtractor());
		return volumes;
	}
	
	

}
