package com.fsoft.fpt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.fsoft.fpt.model.Volume;;

public class VolumeExtractor implements ResultSetExtractor {

	@Override
	public Object extractData(ResultSet rs) throws SQLException,
			DataAccessException {
		List<Volume> volumes = new ArrayList<Volume>();
		while(rs.next()) {
			Volume volume = new Volume();
			volume.setVolumeId(rs.getInt("volumeId"));
			volume.setTriggerCredit(rs.getString("triggerCredit"));
			volume.setPaymentTo(rs.getString("paymentTo"));
			volumes.add(volume);
		}
		return volumes;
	}

}
