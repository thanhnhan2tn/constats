package xml_To_Object;

public class Input {

	String inputType;
	String inputName;
	int inputLength;
	String inputValue;
	public Input() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Input(String inputType, String inputName, int inputLength,
			String inputValue) {
		super();
		this.inputType = inputType;
		this.inputName = inputName;
		this.inputLength = inputLength;
		this.inputValue = inputValue;
	}
	public String getInputType() {
		return this.inputType;
	}
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}
	public String getInputName() {
		return this.inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}
	public int getInputLength() {
		return this.inputLength;
	}
	public void setInputLength(int inputLength) {
		this.inputLength = inputLength;
	}
	public String getInputValue() {
		return this.inputValue;
	}
	public void setInputValue(String inputValue) {
		this.inputValue = inputValue;
	}

}

