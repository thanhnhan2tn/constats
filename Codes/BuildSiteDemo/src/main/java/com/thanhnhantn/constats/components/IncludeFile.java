package com.thanhnhantn.constats.components;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "fileName", "source", "destination" })
public class IncludeFile {
	private String fileName;
	private String source;
	private String destination;

	public IncludeFile() {
		// TODO Auto-generated constructor stub
	}

	@XmlElement
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@XmlElement
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@XmlElement
	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public IncludeFile(String fileName, String source, String destination) {
		super();
		this.fileName = fileName;
		this.source = source;
		this.destination = destination;
	}

}
