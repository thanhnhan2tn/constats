package com.thanhnhantn.constats.components;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "fileName", "divs" })
public class themeFile {

	private String name;
	private String fileName;

	private List<Division> divs = new ArrayList<Division>();

	public themeFile() {
		// TODO Auto-generated constructor stub
	}

	public themeFile(String name, String fileName, List<Division> divs) {
		super();
		this.name = name;
		this.fileName = fileName;
		this.divs = divs;
	}

	@XmlAttribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@XmlElement(name = "div")
	public List<Division> getDivs() {
		return divs;
	}

	public void setDivs(List<Division> divs) {
		this.divs = divs;
	}

	@Override
	public String toString() {
		String str = "";
		for (Division div : divs) {
			str += div.toString();
		}
		return str;
	}
}
