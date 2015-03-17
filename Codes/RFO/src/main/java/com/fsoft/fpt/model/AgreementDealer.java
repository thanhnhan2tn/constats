package com.fsoft.fpt.model;

/**
 * AgreementDealer
 * 
 * @author ThanhNhan Map to table AgreementDealer
 */
public class AgreementDealer {
	private int agreementDealerId;
	private int agreementId;
	private int rfoUserId;

	public AgreementDealer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAgreementDealerId() {
		return agreementDealerId;
	}

	public void setAgreementDealerId(int agreementDealerId) {
		this.agreementDealerId = agreementDealerId;
	}

	public int getAgreementId() {
		return agreementId;
	}

	public void setAgreementId(int agreementId) {
		this.agreementId = agreementId;
	}

	public int getRfoUserId() {
		return rfoUserId;
	}

	public void setRfoUserId(int rfoUserId) {
		this.rfoUserId = rfoUserId;
	}

}
