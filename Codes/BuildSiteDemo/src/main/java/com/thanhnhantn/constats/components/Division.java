package com.thanhnhantn.constats.components;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "divClass", "name", "style", "others", "value",
		"divs" })
public class Division {
	private String id;
	private String divClass;
	private String name;
	private String style;
	private String others;
	private String value;
	List<Division> divs = new ArrayList<Division>();

	@XmlElement(name = "div")
	public List<Division> getDivs() {
		return divs;
	}

	public void setDivs(List<Division> divs) {
		this.divs = divs;
	}

	public Division() {
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
	public String getDivClass() {
		return divClass;
	}

	public void setDivClass(String divClass) {
		this.divClass = divClass;
	}

	@XmlElement
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@XmlElement
	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	@XmlElement
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Division(String id, String divClass, String name, String style) {
		super();
		this.id = id;
		this.divClass = divClass;
		this.name = name;
		this.style = style;
	}

	public Division getNote(List<Division> divs) {
		return getNote(divs);
	}

	@Override
	public String toString() {
		String str = "<div ";
		str += (getId() == null) ? "" : "id = '" + getId() + "'";
		str += (getDivClass() == null) ? "" : " class = '" + getDivClass()
				+ "'";
		str += (getStyle() == null) ? "" : " style='" + getStyle() + "'";
		str += ">\n";
		str += (getValue() == null) ? "" : getValue();
		if (!this.getDivs().isEmpty()) {
			for (Division div : this.getDivs()) {
				str += div.toString();
			}
		}
		str += "</div>\n";
		return str;
	}
}
