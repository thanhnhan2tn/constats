package com.thanhnhantn.generate.components;

public class Script {
	private String type;
	private String value;
	private String src;
	private String others;

	public Script(String type, String value, String src, String others) {
		super();
		this.type = type;
		this.value = value;
		this.src = src;
		this.others = others;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public Script() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		String str = "";
		if (getSrc() != null) {
			str+="<script src=\""+getSrc()+"\"";
			str += (getType() != null) ? " type=\"" + getType() + "\"" : "";
			str += (getOthers() != null) ? getOthers() : "";
			str+="></script>";
		} else {
			return "<script "
					+ ((getType() != null) ? " type=\"" + getType() + "\"" : "")+">"+getValue()+"<script>";
		}
		return str;
	}
}
