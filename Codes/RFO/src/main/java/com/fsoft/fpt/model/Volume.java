package com.fsoft.fpt.model;

import java.util.List;

public class Volume {
	private int volumeId;
	private String triggerCredit;
	private String paymentTo;
	private List<Banding> banding;

	/**
	 * 
	 */
	public Volume() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(int volumeId) {
		this.volumeId = volumeId;
	}

	public String getTriggerCredit() {
		return triggerCredit;
	}

	public void setTriggerCredit(String triggerCredit) {
		this.triggerCredit = triggerCredit;
	}

	public String getPaymentTo() {
		return paymentTo;
	}

	public void setPaymentTo(String paymentTo) {
		this.paymentTo = paymentTo;
	}

	public List<Banding> getBanding() {
		return banding;
	}

	public void setBanding(List<Banding> banding) {
		this.banding = banding;
	}

}
