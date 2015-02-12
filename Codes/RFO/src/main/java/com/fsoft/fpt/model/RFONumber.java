package com.fsoft.fpt.model;

import java.util.Date;

public class RFONumber {
	private int RFONumberId;
	private String RFONumber;
	private String RFOName;
	private int customerTypeId;
	private CustomerType customerType;
	private int companyId;
	private Company company;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String postCode;

	public int getRFONumberId() {
		return RFONumberId;
	}

	public void setRFONumberId(int rFONumberId) {
		RFONumberId = rFONumberId;
	}

	public String getRFONumber() {
		return RFONumber;
	}

	public void setRFONumber(String rFONumber) {
		RFONumber = rFONumber;
	}

	public String getRFOName() {
		return RFOName;
	}

	public void setRFOName(String rFOName) {
		RFOName = rFOName;
	}

	public int getCustomerTypeId() {
		return customerTypeId;
	}

	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
