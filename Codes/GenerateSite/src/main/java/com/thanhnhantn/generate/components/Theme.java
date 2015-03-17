package com.thanhnhantn.generate.components;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "theme")
@XmlType(propOrder = { "id", "themeName", "version", "path", "author", "site",
		"files", "includeFiles" })
public class Theme {
	private String id;
	private String themeName;
	private String version;
	private String path;
	private String author;
	private String site;
	List<themeFile> files = new ArrayList<themeFile>();
	List<IncludeFile> includeFiles = new ArrayList<IncludeFile>();
	
	public Theme() {
		// TODO Auto-generated constructor stub
	}

	public Theme(String id, String themeName, String version, String path,
			String author, String site) {
		super();
		this.id = id;
		this.themeName = themeName;
		this.version = version;
		this.path = path;
		this.author = author;
		this.site = site;
	}
	@XmlElement(name = "includeFile")
	public List<IncludeFile> getIncludeFiles() {
		return includeFiles;
	}

	public void setIncludeFiles(List<IncludeFile> includeFiles) {
		this.includeFiles = includeFiles;
	}

	@XmlAttribute
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@XmlElement
	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	@XmlElement
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@XmlElement
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@XmlElement
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@XmlElement
	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	@XmlElement(name = "file")
	public List<themeFile> getFiles() {
		return files;
	}

	public void setFiles(List<themeFile> files) {
		this.files = files;
	}

	public String toString(themeFile file) {
		return file.toString();
	}
}
