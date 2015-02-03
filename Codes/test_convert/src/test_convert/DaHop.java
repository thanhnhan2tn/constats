package test_convert;

import java.io.File;

public class DaHop {

	public void Xml_Object(String string, String xml_file) {
		File f = new File("src/" + xml_file);
		if (string.equals("Button") || string.equals("Text")
				|| string.equals("Radio")) {
			Input_Convert.jaxbXMLToObject(f);

		}

	}

	public DaHop() {
	}

	public static void main(String[] args) {
		DaHop dh = new DaHop();
		dh.Xml_Object("Button", "Input.xml");
	}

}
