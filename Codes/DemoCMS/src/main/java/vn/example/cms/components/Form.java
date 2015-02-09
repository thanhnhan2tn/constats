package vn.example.cms.components;

import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Form {
	private String action;
	private String method;
	//private List<Input> inputs;
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String makeForm() {
		String str = "";
		str += "<form action=\"" + this.getAction() + "\" method=\""
				+ this.getMethod() + "\" >";
		str += "InForm";
		//Input input = new Input();
		XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource(
				"demoCMS.xml"));

		Input in = (Input) factory.getBean("Input");
		
		//for(Input input : this.inputs){
			str += in.makeInput();	
		//}
		str += "</form>";
		return str;
	}
}