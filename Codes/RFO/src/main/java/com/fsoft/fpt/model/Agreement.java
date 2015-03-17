package com.fsoft.fpt.model;

import java.util.Date;

public class Agreement {
	private int agreementId;
	private int agreementNumber;
	private int variantNumber;
	private String name;
	private String description;
	private String startDate;
	private String endDate;
	private int statusId;
	private Date lastStatusUpdateDate;
	private String authorisedBy;
	private Date authorisedDate;
	private Date createDate;
	private String createBy;
	private Date lastUpdatedDate;
	private String lastUpdatedBy;
	private String paymentTo;
	private float handlingCharge;
	private int fundingMethodId;
	private String creditNoteText;
	private int signRequired;
	private int signReceived;
	private Date signReceivedDate;
	private String dealerVisibility;
	private String combinability;
	private int numberOfRegistrations;
	private int volumeId;
	private int rfoNumberId;
	private String discountUnit;
	private String justification;

	private RFONumber rfoNumber;
	private FundingMethod fundingMethod;
	private AgreementStatus agreementStatus;
	private Volume volume;

	/**
	 * 
	 */
	public Agreement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

	public int getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
	}

	public FundingMethod getFundingMethod() {
		return fundingMethod;
	}

	public void setFundingMethod(FundingMethod fundingMethod) {
		this.fundingMethod = fundingMethod;
	}

	public RFONumber getRfoNumber() {
		return rfoNumber;
	}

	public void setRfoNumber(RFONumber rfoNumber) {
		this.rfoNumber = rfoNumber;
	}

	public int getAgreementNumber() {
		return agreementNumber;
	}

	public void setAgreementNumber(int agreementNumber) {
		this.agreementNumber = agreementNumber;
	}

	public int getVariantNumber() {
		return variantNumber;
	}

	public void setVariantNumber(int variantNumber) {
		this.variantNumber = variantNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Date getLastStatusUpdateDate() {
		return lastStatusUpdateDate;
	}

	public void setLastStatusUpdateDate(Date lastStatusUpdateDate) {
		this.lastStatusUpdateDate = lastStatusUpdateDate;
	}

	public String getAuthorisedBy() {
		return authorisedBy;
	}

	public void setAuthorisedBy(String authorisedBy) {
		this.authorisedBy = authorisedBy;
	}

	public Date getAuthorisedDate() {
		return authorisedDate;
	}

	public void setAuthorisedDate(Date authorisedDate) {
		this.authorisedDate = authorisedDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getPaymentTo() {
		return paymentTo;
	}

	public void setPaymentTo(String paymentTo) {
		this.paymentTo = paymentTo;
	}

	public float getHandlingCharge() {
		return handlingCharge;
	}

	public void setHandlingCharge(float handlingCharge) {
		this.handlingCharge = handlingCharge;
	}

	public int getFundingMethodId() {
		return fundingMethodId;
	}

	public void setFundingMethodId(int fundingMethodId) {
		this.fundingMethodId = fundingMethodId;
	}

	public String getCreditNoteText() {
		return creditNoteText;
	}

	public void setCreditNoteText(String creditNoteText) {
		this.creditNoteText = creditNoteText;
	}

	public int getSignRequired() {
		return signRequired;
	}

	public void setSignRequired(int signRequired) {
		this.signRequired = signRequired;
	}

	public int getSignReceived() {
		return signReceived;
	}

	public void setSignReceived(int signReceived) {
		this.signReceived = signReceived;
	}

	public Date getSignReceivedDate() {
		return signReceivedDate;
	}

	public void setSignReceivedDate(Date signReceivedDate) {
		this.signReceivedDate = signReceivedDate;
	}

	public String getDealerVisibility() {
		return dealerVisibility;
	}

	public void setDealerVisibility(String dealerVisibility) {
		this.dealerVisibility = dealerVisibility;
	}

	public String getCombinability() {
		return combinability;
	}

	public void setCombinability(String combinability) {
		this.combinability = combinability;
	}

	public int getNumberOfRegistrations() {
		return numberOfRegistrations;
	}

	public void setNumberOfRegistrations(int numberOfRegistrations) {
		this.numberOfRegistrations = numberOfRegistrations;
	}

	public int getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(int volumeId) {
		this.volumeId = volumeId;
	}

	public int getRfoNumberId() {
		return rfoNumberId;
	}

	public void setRfoNumberId(int rfoNumberId) {
		this.rfoNumberId = rfoNumberId;
	}

	public String getDiscountUnit() {
		return discountUnit;
	}

	public void setDiscountUnit(String discountUnit) {
		this.discountUnit = discountUnit;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public AgreementStatus getAgreementStatus() {
		return agreementStatus;
	}

	public void setAgreementStatus(AgreementStatus agreementStatus) {
		this.agreementStatus = agreementStatus;
	}

}
