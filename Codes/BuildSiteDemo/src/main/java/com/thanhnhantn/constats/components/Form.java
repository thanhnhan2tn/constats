package com.thanhnhantn.constats.components;

import java.util.ArrayList;
import java.util.List;

public class Form {
	private String id;
	private String name;
	private String action;
	private String method;
	private String fClass;
	private String others;
	List<Label> labels = new ArrayList<Label>();
	List<Input> inputs = new ArrayList<Input>();
	public Form() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getfClass() {
		return fClass;
	}

	public void setfClass(String fClass) {
		this.fClass = fClass;
	}

	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	public Form(String id, String name, String action, String method,
			String fClass, String others) {
		super();
		this.id = id;
		this.name = name;
		this.action = action;
		this.method = method;
		this.fClass = fClass;
		this.others = others;
	}

	@Override
	public String toString() {
		return "Form [getId()=" + getId() + ", getName()=" + getName()
				+ ", getAction()=" + getAction() + ", getMethod()="
				+ getMethod() + ", getfClass()=" + getfClass()
				+ ", getOthers()=" + getOthers() + "]";
	}

}
