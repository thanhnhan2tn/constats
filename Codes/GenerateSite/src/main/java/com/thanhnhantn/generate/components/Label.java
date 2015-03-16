package com.thanhnhantn.generate.components;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "name", "value" })
public class Label {
	private String id;
	private String name;
	private String value;

	public Label() {
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
		return "<label "
				+ ((getName() == null) ? "" : " for= \"" + getName() + "\"")
				+ ">" + getValue() + "</label>";
	}

}
