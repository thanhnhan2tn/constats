package com.fsoft.fpt.model;

public class RFOUser {
	private int rfoUserId;
	private int contactAdressId;
	private String dealerCode;
	private String title;
	private String firstName;
	private String lastName;
	private String extranetUser;
	private String emailAddress;
	private int userTypeId;
	private String status;

	private ContactAddress contactAdress;
	private UserType userType;

	/**
	 * 
	 */
	public RFOUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRfoUserId() {
		return rfoUserId;
	}

	public void setRfoUserId(int rfoUserId) {
		this.rfoUserId = rfoUserId;
	}

	public int getContactAdressId() {
		return contactAdressId;
	}

	public void setContactAdressId(int contactAdressId) {
		this.contactAdressId = contactAdressId;
	}

	public String getDealerCode() {
		return dealerCode;
	}

	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getExtranetUser() {
		return extranetUser;
	}

	public void setExtranetUser(String extranetUser) {
		this.extranetUser = extranetUser;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public int getUserTypeId() {
		return userTypeId;
	}

	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ContactAddress getContactAdress() {
		return contactAdress;
	}

	public void setContactAdress(ContactAddress contactAdress) {
		this.contactAdress = contactAdress;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}