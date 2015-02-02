package com.edu.vn;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
	public static void main(String[] args) {
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"Beans.xml"));
		HelloWorld obj = (HelloWorld) factory.getBean("helloWorld");
		System.out.print(obj.getMessage());
	}
}