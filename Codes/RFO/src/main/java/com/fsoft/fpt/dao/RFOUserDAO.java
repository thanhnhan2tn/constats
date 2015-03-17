package com.fsoft.fpt.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.fsoft.fpt.model.Company;
import com.fsoft.fpt.model.ContactAddress;
import com.fsoft.fpt.model.CustomerType;
import com.fsoft.fpt.model.RFOUser;
import com.fsoft.fpt.model.UserType;

public class RFOUserDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	@Autowired
	private ContactAddressDAO contactAddressDAO;
	@Autowired
	private UserTypeDAO userTypeDAO;

	/**
	 * 
	 */
	public RFOUserDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public RFOUser get(int RFOUserId) {
		List<RFOUser> dealers;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM RFOUser where RFOUserId = " + RFOUserId;
		dealers = jdbcTemplateObject.query(sql, new RFOUserExtractor());
		for (int i = 0; i < dealers.size(); i++) {
			ContactAddress contactAddress = contactAddressDAO.get(dealers
					.get(i).getContactAdressId());
			UserType userType = userTypeDAO.get(dealers.get(i).getUserTypeId());
			dealers.get(i).setContactAdress(contactAddress);
			dealers.get(i).setUserType(userType);
		}
		if (dealers.isEmpty() == true) {
			return new RFOUser();
		} else {
			return dealers.get(0);
		}
	}

	public List<RFOUser> list() {
		List<RFOUser> dealers;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM RFOUser";
		dealers = jdbcTemplateObject.query(sql, new RFOUserExtractor());
		for (int i = 0; i < dealers.size(); i++) {
			ContactAddress contactAddress = contactAddressDAO.get(dealers
					.get(i).getContactAdressId());
			UserType userType = userTypeDAO.get(dealers.get(i).getUserTypeId());
			dealers.get(i).setContactAdress(contactAddress);
			dealers.get(i).setUserType(userType);
		}
		return dealers;
	}

	public List<RFOUser> search(String code, String name) {
		List<RFOUser> dealers;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from rfouser as a inner join contactaddress as b on a.contactAddressId = b.contactAddressId inner join usertype as c on a.userTypeId = c.userTypeId";
		boolean flag = false;
		if (code.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			}
			sql += " dealerCode like '%" + code + "%'";
		}
		if (name.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " concat(firstname, ' ', lastname) like '%" + name + "%'";
		}

		System.out.println("Search customer : \n" + sql);
		dealers = jdbcTemplateObject.query(sql, new RFOUserExtractor());
		for (int i = 0; i < dealers.size(); i++) {
			ContactAddress contactAddress = contactAddressDAO.get(dealers
					.get(i).getContactAdressId());
			UserType userType = userTypeDAO.get(dealers.get(i).getUserTypeId());
			dealers.get(i).setContactAdress(contactAddress);
			dealers.get(i).setUserType(userType);
		}
		return dealers;
	}
}
