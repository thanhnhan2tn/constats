package vn.example.cms.components;

public class Input {
	private String inputName;
	private String inputType;
	private String inputValue;
	private String inputLength;

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	public String getInputValue() {
		return inputValue;
	}

	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

	public String getInputLength() {
		return inputLength;
	}

	public void setInputLength(String inputLength) {
		this.inputLength = inputLength;
	}

	public String makeInput() {
		return "<input type=\"" + this.getInputType() + "\" name=\""
				+ this.getInputName() + "\" value=\"" + this.getInputValue()
				+ "\" length=\"" + this.getInputLength() + "\" />";
	}
}
