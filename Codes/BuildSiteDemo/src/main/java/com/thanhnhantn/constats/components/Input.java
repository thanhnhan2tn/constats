package com.thanhnhantn.constats.components;

public class Input {
	private String id;
	private String iClass;
	private String type;
	private String name;
	private String value;
	private String others;
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Input() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getiClass() {
		return iClass;
	}

	public void setiClass(String iClass) {
		this.iClass = iClass;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public Input(String id, String iClass, String type, String name,
			String others) {
		super();
		this.id = id;
		this.iClass = iClass;
		this.type = type;
		this.name = name;
		this.others = others;
	}

	@Override
	public String toString() {
		String str="<input ";
		str+="/>";
		return str;
	}

}
