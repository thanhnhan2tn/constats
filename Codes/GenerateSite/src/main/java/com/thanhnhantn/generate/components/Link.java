package com.thanhnhantn.generate.components;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "name", "href", "value", "title", "alt", "style" })
public class Link {
	private String id;
	private String name;
	private String href;
	private String value;
	private String title;
	private String alt;
	private String style;

	public Link() {
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
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	@XmlElement
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement
	public String getAlt() {
		return alt;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}

	@XmlElement
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public Link(String id, String name, String value, String title, String alt) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.title = title;
		this.alt = alt;
	}

	@Override
	public String toString() {
		String str = "<a ";
		str += " href = "
				+ ((getHref() == null) ? "\"#\"" : "\"" + getHref() + "\"");
		str += (getId() == null) ? "" : "id=\"" + getId() + "\"";
		str += (getName() == null) ? "" : "name=\"" + getName() + "\"";
		str += (getTitle() == null) ? "" : "title=\"" + getTitle() + "\"";
		str += (getAlt() == null) ? "" : "alt=\"" + getAlt() + "\"";
		str += (getStyle() == null) ? "" : "style=\"" + getStyle() + "\"";
		str += ">" + ((getValue() == null) ? "" : getValue()) + "</a>";
		return str;
	}
}
