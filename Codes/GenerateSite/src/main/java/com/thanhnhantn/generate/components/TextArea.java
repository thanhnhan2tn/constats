package com.thanhnhantn.generate.components;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "name", "length", "cols", "rows", "value",
		"tclass", "style" })
public class TextArea {
	private String id;
	private String name;
	private String length;
	private String cols;
	private String rows;
	private String value;
	private String tclass;
	private String style;

	public TextArea() {
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
	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	@XmlElement
	public String getCols() {
		return cols;
	}

	public void setCols(String cols) {
		this.cols = cols;
	}

	@XmlElement
	public String getRows() {
		return rows;
	}

	public void setRows(String rows) {
		this.rows = rows;
	}

	@XmlElement
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@XmlElement
	public String getTclass() {
		return tclass;
	}

	public void setTclass(String tclass) {
		this.tclass = tclass;
	}

	@XmlElement
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public TextArea(String id, String name, String length, String cols,
			String rows, String value, String tclass, String style) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
		this.cols = cols;
		this.rows = rows;
		this.value = value;
		this.tclass = tclass;
		this.style = style;
	}

	@Override
	public String toString() {
		String str = "<textarea ";
		str += (getName() == null) ? "" : "name=\"" + getName() + "\"";
		str += (getTclass() == null) ? "" : "class=\"" + getTclass() + "\"";
		str += (getCols() == null) ? "" : "cols=\"" + getCols() + "\"";
		str += (getRows() == null) ? "" : "rows=\"" + getRows() + "\"";
		str += ">" + getValue() + "</textarea>";
		return str;
	}
}
