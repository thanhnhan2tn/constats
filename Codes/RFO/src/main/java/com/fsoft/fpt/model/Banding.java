package com.fsoft.fpt.model;

public class Banding {
	private int bandingId;
	private int volumeId;
	private int min;
	private int max;

	private Volume volume;

	/**
	 * 
	 */
	public Banding() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBandingId() {
		return bandingId;
	}

	public void setBandingId(int bandingId) {
		this.bandingId = bandingId;
	}

	public int getVolumeId() {
		return volumeId;
	}

	public void setVolumeId(int volumeId) {
		this.volumeId = volumeId;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public Volume getVolume() {
		return volume;
	}

	public void setVolume(Volume volume) {
		this.volume = volume;
	}

}
