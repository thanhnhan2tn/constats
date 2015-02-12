package com.fsoft.fpt.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.fsoft.fpt.model.Company;
import com.fsoft.fpt.model.CustomerType;
import com.fsoft.fpt.model.RFONumber;

public class RFONumberDAO {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	@Autowired
	private CompanyDAO companyDAO;
	@Autowired
	private CustomerTypeDAO customerTypeDAO;

	/**
	 * 
	 */
	public RFONumberDAO() {
	}

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public RFONumber get(int rfoNumberId) {
		List<RFONumber> customers;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM RFONumber where rfoNumberId = " + rfoNumberId;
		customers = jdbcTemplateObject.query(sql, new RFONumberExtractor());
		for (int i = 0; i < customers.size(); i++) {
			Company company = companyDAO.get(customers.get(i).getCompanyId());
			CustomerType customerType = customerTypeDAO.get(customers.get(i)
					.getCustomerTypeId());
			customers.get(i).setCompany(company);
			customers.get(i).setCustomerType(customerType);
		}
		if (customers.isEmpty() == true) {
			return new RFONumber();
		} else {
			return customers.get(0);
		}
	}

	public List<RFONumber> list() {
		List<RFONumber> customers;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "SELECT * FROM RFONumber";
		customers = jdbcTemplateObject.query(sql, new RFONumberExtractor());
		for (int i = 0; i < customers.size(); i++) {
			Company company = companyDAO.get(customers.get(i).getCompanyId());
			CustomerType customerType = customerTypeDAO.get(customers.get(i)
					.getCustomerTypeId());
			customers.get(i).setCompany(company);
			customers.get(i).setCustomerType(customerType);
		}
		return customers;
	}

	public List<RFONumber> search(String rfoNumber, String customerType,
			String name, String postCode, String businessArea, String region) {
		List<RFONumber> customers;
		jdbcTemplateObject = new JdbcTemplate(dataSource);
		String sql = "select * from rfonumber as a  inner join customertype as b on a.customertypeid = b.customertypeid inner join company as c on a.companyid = c.companyid inner join address as d on c.addressid = d.addressid";
		boolean flag = false;
		if (rfoNumber.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			}
			sql += " rfonumber like '%" + rfoNumber + "%'";
		}
		if (customerType.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " customertype like '%" + customerType + "%'";
		}
		if (name.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " name like '%" + name + "%'";
		}
		if (postCode.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " postcode like '%" + postCode + "%'";
		}
		if (businessArea.equals("") ==false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " businessarea lie '%" + businessArea + "%'";
		}
		/*if (region.equals("") == false) {
			if (flag == false) {
				sql += " where";
				flag = true;
			} else {
				sql += " and";
			}
			sql += " where region like '%" + region + "%'";
		}*/
		System.out.println("Search customer : \n" + sql);
		customers = jdbcTemplateObject.query(sql, new RFONumberExtractor());
		for (int i = 0; i < customers.size(); i++) {
			Company company = companyDAO.get(customers.get(i).getCompanyId());
			CustomerType customerType1 = customerTypeDAO.get(customers.get(i)
					.getCustomerTypeId());
			customers.get(i).setCompany(company);
			customers.get(i).setCustomerType(customerType1);
		}
		return customers;
	}
}
