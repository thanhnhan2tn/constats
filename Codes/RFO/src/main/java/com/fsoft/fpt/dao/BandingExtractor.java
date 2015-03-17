package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.Banding;


public class BandingExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Banding> bandings = new ArrayList<Banding>();
		while(rs.next()) {
			Banding banding = new Banding();
			banding.setBandingId(rs.getInt("bandingId"));
			banding.setMax(rs.getInt("max"));
			banding.setMin(rs.getInt("min"));
			banding.setVolumeId(rs.getInt("volumeid"));
			bandings.add(banding);
		}
		return bandings;
	}

}
