package com.thanhnhantn.generate.components;

public class Style {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Style(String value) {
		super();
		this.value = value;
	}

	public Style() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "<style>" + value + "</style>";
	}

}
