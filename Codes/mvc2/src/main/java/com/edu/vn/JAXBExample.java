package com.edu.vn;


import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {

	private static final String FILE_NAME = "C:/Users/Notexittran/Desktop/LV Github/constats/Codes/mvc2/src/main/resources/Button.xml";

	public static void main(String[] args) {
		

		Button empFromFile = jaxbXMLToObject();
		System.out.println(empFromFile.getChuoi());
		try {
			//xmlToConFig(empFromFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	// -------------------XML to Object----------------------------------------
	public static Button jaxbXMLToObject() {
		try {
			// Khoi tao Context
			JAXBContext context = JAXBContext.newInstance(Button.class);
			Unmarshaller un = context.createUnmarshaller();
			// File xml phu thuoc vao doi tuong + duong duong path
			Button emp = (Button) un.unmarshal(new File(FILE_NAME));
			return emp;

			// Write to file
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	// --------------------------------------------------------------------

	

}