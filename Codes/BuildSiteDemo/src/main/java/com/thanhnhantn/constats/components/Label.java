package com.thanhnhantn.constats.components;

public class Label {
	private String id;
	private String name;
	private String value;
	public Label() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Label(String id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Label [id=" + id + ", name=" + name + ", value=" + value + "]";
	}

}
