package com.thanhnhantn.generate.components;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "title", "styles", "metas", "links", "scrips", "others" })
public class Head {
	private String title;
	private List<Style> styles = new ArrayList<Style>();
	private List<Meta> metas = new ArrayList<Meta>();
	private List<LinkRel> links = new ArrayList<LinkRel>();
	private List<Script> scrips = new ArrayList<Script>();
	private String others;

	public Head(String title, List<Style> styles, List<Meta> metas,
			List<LinkRel> links, List<Script> scrips, String others) {
		super();
		this.title = title;
		this.styles = styles;
		this.metas = metas;
		this.links = links;
		this.scrips = scrips;
		this.others = others;
	}

	@XmlElement
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@XmlElement(name = "style")
	public List<Style> getStyles() {
		return styles;
	}

	public void setStyles(List<Style> styles) {
		this.styles = styles;
	}

	@XmlElement(name = "meta")
	public List<Meta> getMetas() {
		return metas;
	}

	public void setMetas(List<Meta> metas) {
		this.metas = metas;
	}

	@XmlElement(name = "link")
	public List<LinkRel> getLinks() {
		return links;
	}

	public void setLinks(List<LinkRel> links) {
		this.links = links;
	}

	@XmlElement(name = "script")
	public List<Script> getScrips() {
		return scrips;
	}

	public void setScrips(List<Script> scrips) {
		this.scrips = scrips;
	}
	@XmlElement
	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public Head() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// Khoi tao bien rong,
		// neu cac gia tri duoc khai bao, thi chuyen thanh chuoi voi code html
		// tuong ung
		String str = "";
		if (getTitle() != null) {
			str += "<title>" + getTitle() + "</title>\n";
		}
		if (getStyles() != null) {
			for (Style style : getStyles()) {
				str += style.toString();
			}
		}
		if (getLinks() != null) {
			for (LinkRel link : getLinks()) {
				str += link.toString();
			}
		}
		if (getScrips() != null) {
			for (Script script : getScrips()) {
				str += script.toString();
			}
		}
		if (getOthers() != null) {
			str += getOthers();
		}
		return str;
	}
}
