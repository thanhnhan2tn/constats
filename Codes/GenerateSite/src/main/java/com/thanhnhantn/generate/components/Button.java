package com.thanhnhantn.generate.components;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "name", "type", "action", "value", "style" })
public class Button {
	private String id;
	private String name;
	private String type;
	private String action;
	private String value;
	private String style;

	public Button() {
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
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@XmlElement
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@XmlElement
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@Override
	public String toString() {
		String str = "<button ";
		str += (getId() == null) ? "" : "id=\"" + getId() + "\"";
		str += (getName() == null) ? "" : "name=\"" + getName() + "\"";
		str += (getType() == null) ? "" : "type=\"" + getType() + "\"";
		str += (getAction() == null) ? "" : "action=\"" + getAction() + "\"";
		str += (getStyle() == null) ? "" : "style=\"" + getStyle() + "\"";
		str += ">" + ((getValue() == null) ? "" : getValue()) + "</button>";
		return str;
	}
}
