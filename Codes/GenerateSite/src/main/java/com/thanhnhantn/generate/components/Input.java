package com.thanhnhantn.generate.components;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "name", "type", "iClass", "value", "others","location" })
public class Input {
	private String id;
	private String name;
	private String iClass;
	private String type;
	private String value;
	private String others;
	private Location location;

	public Input() {
		// TODO Auto-generated constructor stub
	}
	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@XmlElement
	public String getiClass() {
		return iClass;
	}

	public void setiClass(String iClass) {
		this.iClass = iClass;
	}
	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	@XmlElement
	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}
	@XmlElement
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	@XmlElement
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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
		String str = "<input ";
		str += ((getId() == null) ? "" : " id= \"" + getId() + "\"");
		str += ((getiClass() == null) ? "" : " class= \"" + getiClass() + "\"");
		str += ((getName() == null) ? "" : " name= \"" + getName() + "\"");
		str += ((getType() == null) ? "" : " type= \"" + getType() + "\"");
		str += ((getValue() == null) ? "" : " value= \"" + getValue() + "\"");
		str += ((getOthers() == null) ? "" : getOthers());
		str += "/>";
		return str;
	}

}
