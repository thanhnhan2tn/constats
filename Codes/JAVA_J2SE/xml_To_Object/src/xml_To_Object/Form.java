package xml_To_Object;

import java.util.List;

public class Form {
	String action;
	String method;
	List<Input> input;
	List<Label> label;

	public Form() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Form(String action, String method, List<Input> input,
			List<Label> label) {
		super();
		this.action = action;
		this.method = method;
		this.input = input;
		this.label = label;
	}

	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<Input> getInput() {
		return this.input;
	}

	public void setInput(List<Input> input) {
		this.input = input;
	}

	public List<Label> getLabel() {
		return this.label;
	}

	public void setLabel(List<Label> label) {
		this.label = label;
	}
	

}
