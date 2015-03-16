package xml_To_Object;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Button")
@XmlType(propOrder = { "type", "value" })
public class Button {

	private int id;

	private String type;

	private String value;

	public Button() {

	}

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@XmlElement
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	public String getChuoi() {
		String tongchuoi ="<input type = '" + this.getType() + "'" +" "+ "value = '" + this.getValue()+"'" + ">";
		return tongchuoi;
			}

}