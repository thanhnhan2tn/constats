package vn.example.cms.components;

public class Label {
	private String labelName;
	private String labelText;

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}

	public String getLabelText() {
		return labelText;
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}

	public String makeLabel(Label l) {
		return "<label for=\"" + this.getLabelName() + "\">" + this.labelText
				+ "</label>";
	}
}