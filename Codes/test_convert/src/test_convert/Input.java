package test_convert;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//Id cua the ko khai bao trong cac Anotation
//Ten cua root phan biet hoa thuong giua file class java va file xml
//Loi Uri thuong do RootElement 
@XmlRootElement(name = "input")
@XmlType(propOrder = { "type", "value","name" })
public class Input {

	private int id;

	private String type;

	private String value;
	private String name;

	public Input() {

	}

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		String tongchuoi = "<input type = '" + this.getType() + "'" + " "
				+ "value = '" + this.getValue() + "'" + " name='" + this.getName()+ "'" +  ">";
		return tongchuoi;
	}

}