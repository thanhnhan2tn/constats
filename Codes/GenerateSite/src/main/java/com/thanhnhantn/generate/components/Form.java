package com.thanhnhantn.generate.components;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "name", "action", "method", "fClass", "others",
		"text", "style", "textareas", "labels", "inputs", "buttons" })
public class Form {
	private String id;
	private String name;
	private String action;
	private String method;
	private String fClass;
	private String others;
	private String text;
	private String style;
	List<TextArea> textareas = new ArrayList<TextArea>();
	List<Label> labels = new ArrayList<Label>();
	List<Input> inputs = new ArrayList<Input>();
	List<Button> buttons = new ArrayList<Button>();

	public Form() {
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
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@XmlElement
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@XmlElement
	public String getfClass() {
		return fClass;
	}

	public void setfClass(String fClass) {
		this.fClass = fClass;
	}

	@XmlElement
	public String getOthers() {
		return others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

	@XmlElement
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@XmlElement
	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	@XmlElement(name = "label")
	public List<Label> getLabels() {
		return labels;
	}

	public void setLabels(List<Label> labels) {
		this.labels = labels;
	}

	@XmlElement(name = "input")
	public List<Input> getInputs() {
		return inputs;
	}

	public void setInputs(List<Input> inputs) {
		this.inputs = inputs;
	}

	@XmlElement(name = "textarea")
	public List<TextArea> getTextareas() {
		return textareas;
	}

	public void setTextareas(List<TextArea> textareas) {
		this.textareas = textareas;
	}

	@XmlElement(name = "button")
	public List<Button> getButtons() {
		return buttons;
	}

	public void setButtons(List<Button> buttons) {
		this.buttons = buttons;
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
		// Print the code of Form
		String str = "<form ";
		str += (getId() == null) ? "" : " id=\"" + getId() + "\" ";
		str += (getName() == null) ? "" : " name=\"" + getName() + "\" ";
		str += (getAction() == null) ? "" : " action=\"" + getAction() + "\" ";
		str += (getMethod() == null) ? "" : " method=\"" + getMethod() + "\" ";
		str += (getfClass() == null) ? "" : " class=\"" + getfClass() + "\" ";
		str += (getStyle() == null) ? "" : " style=\"" + getStyle() + "\" ";
		str += (getOthers() == null) ? "" : getOthers();
		str += ">";
		for (Label label : getLabels()) {
			System.out.println(label.getValue());
			str += label.toString();
		}
		for (Input input : getInputs()) {
			System.out.println(input.getValue());
			str += input.toString();
		}
		for (TextArea textarea : getTextareas()) {
			System.out.println(textarea.getValue());
			str += textarea.toString();
		}
		for (Button button : getButtons()) {
			System.out.println(button.getValue());
			str += button.toString();
		}
		str += (getText() == null) ? "" : getText();
		str += "</form>";
		return str;
	}
}
