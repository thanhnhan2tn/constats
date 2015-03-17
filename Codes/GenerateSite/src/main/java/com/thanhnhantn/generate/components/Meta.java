package com.thanhnhantn.generate.components;

public class Meta {
	private String name;
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Meta(String name, String content) {
		super();
		this.name = name;
		this.content = content;
	}

	public Meta() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "<meta name='" + name + "' content='" + content + "' />";
	}

}
