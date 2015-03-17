package xml_To_Object;

public class Label {
	String name;
	String text;

	public Label() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Label(String name, String text) {
		super();
		this.name = name;
		this.text = text;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
