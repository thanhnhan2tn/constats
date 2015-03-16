package com.thanhnhantn.constats.components;

public class Button {
	private String Id;
	private String Name;
	private String Type;
	private String Action;
	private String Value;
	public Button() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getAction() {
		return Action;
	}
	public void setAction(String action) {
		Action = action;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public Button(String id, String name, String type, String action,
			String value) {
		super();
		Id = id;
		Name = name;
		Type = type;
		Action = action;
		Value = value;
	}

}
