package com.fsoft.fpt.model;

public class FundingMethod {
	private int fundingMethodId;
	private String fundingMethodName;
	private String fundingType;
	private int contractTemplateLocation;
	private int SignedContractDefult;
	private String status;

	/**
	 * 
	 */
	public FundingMethod() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFundingMethodId() {
		return fundingMethodId;
	}

	public void setFundingMethodId(int fundingMethodId) {
		this.fundingMethodId = fundingMethodId;
	}

	public String getFundingMethodName() {
		return fundingMethodName;
	}

	public void setFundingMethodName(String fundingMethodName) {
		this.fundingMethodName = fundingMethodName;
	}

	public String getFundingType() {
		return fundingType;
	}

	public void setFundingType(String fundingType) {
		this.fundingType = fundingType;
	}

	public int getContractTemplateLocation() {
		return contractTemplateLocation;
	}

	public void setContractTemplateLocation(int contractTemplateLocation) {
		this.contractTemplateLocation = contractTemplateLocation;
	}

	public int getSignedContractDefult() {
		return SignedContractDefult;
	}

	public void setSignedContractDefult(int signedContractDefult) {
		SignedContractDefult = signedContractDefult;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
