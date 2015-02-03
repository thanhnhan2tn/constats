package test_convert;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXB_Chu_Chot {
	static File file = new File("src/input.xml");
	// Khong quan trong ten cua tap tin xml la hoa hay thuong
	static File file2 = new File("src/question.xml");

	public static void main(String[] args) {

		Input empFromFile = jaxbXMLToObject();
		System.out.println(empFromFile.getChuoi());

		Question que = jaxbXMLToObject_2();
		//System.out.println(que.getQuestionname());
	}

	// -------------------XML to Object - 1 doi
	// tuong-----------------------------------
	private static Input jaxbXMLToObject() {
		try {
			// Khoi tao Context
			JAXBContext context = JAXBContext.newInstance(Input.class);
			Unmarshaller un = context.createUnmarshaller();
			// File xml phu thuoc vao doi tuong + duong duong path
			Input emp = (Input) un.unmarshal(file);
			return emp;

			// Write to file
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	// -------------------XML to Object - n doi
	// tuong------------------------------------
	private static Question jaxbXMLToObject_2() {
		try {
			// Khoi tao Context
			JAXBContext context = JAXBContext.newInstance(Question.class);
			// Tao Unmarshaller tu Context
			Unmarshaller un = context.createUnmarshaller();
			// File xml phu thuoc vao doi tuong + duong duong path
			Question que = (Question) un.unmarshal(file2);
			System.out.println(que.getId() + "" + que.getQuestionname());
			System.out.println("Answer:");
			List<Answer> list = que.getAnswers();
			for (Answer ans : list)
				System.out.println(ans.getId() + " " + ans.getAnswername()
						+ " " + ans.getPostedby());
			return que;

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

}