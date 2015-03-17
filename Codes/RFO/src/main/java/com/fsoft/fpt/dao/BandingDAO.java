package com.fsoft.fpt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fsoft.fpt.model.Banding;

public class BandingDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	/**
	 * 
	 */
	public BandingDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Banding create(Banding banding) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "insert into banding values(null, ?, ?, ?)";
		jdbcTemplateObject.update(sql, new Object[] { banding.getVolumeId(),
				banding.getMin(), banding.getMax() });
		int bandingId = jdbcTemplateObject
				.queryForInt("select max(bandingid) from banding");
		banding.setBandingId(bandingId);
		return banding;
	}

	/**
	 * @author Luong Duc Duy
	 * @param bandingId
	 * @return
	 */
	public Banding update(Banding banding) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "update banding set min = ?, max = ? where bandingid = ?";
		jdbcTemplateObject.update(
				sql,
				new Object[] { banding.getMin(), banding.getMax(),
						banding.getVolumeId() });
		return banding;
	}

	/**
	 * @author Luong Duc Duy
	 * @param bandingId
	 * @return delete by Banding
	 */
	public void delete(Banding banding) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "delete from banding where badingid = ?";
		jdbcTemplateObject.update(sql, new Object[] { banding.getBandingId() });
	}

	/**
	 * @author Luong Duc Duy
	 * @param bandingId
	 * @return delete by VolumeId
	 */
	public void delete(Integer volumeId) {
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "delete from banding where volumeId = ?";
		jdbcTemplateObject.update(sql, new Object[] { volumeId });
	}

	public Banding get(int bandingId) {
		List<Banding> bandings = new ArrayList<Banding>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from banding where bandingid = " + bandingId;
		bandings = jdbcTemplateObject.query(sql, new BandingExtractor());
		if (bandings.isEmpty() == true) {
			return new Banding();
		} else {
			return bandings.get(0);
		}
	}

	public List<Integer> getBandingMilStone(int volumeId) {
		List<Integer> result = new ArrayList<Integer>();
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM `banding` WHERE `volumeId` = ?";
		List<Banding> bandings = jdbcTemplateObject.query(sql,
				new Object[] { volumeId }, new BandingExtractor());
		result.add(-1);
		for (int i = 0; i < bandings.size() - 1; i++) {
			result.add(bandings.get(i).getMax());
		}
		return result;
	}

}
