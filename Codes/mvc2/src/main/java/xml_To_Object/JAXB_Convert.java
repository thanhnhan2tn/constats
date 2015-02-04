package xml_To_Object;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXB_Convert {
	// static File file = new File("src/input.xml");
	// Khong quan trong ten cua tap tin xml la hoa hay thuong
	// static File file2 = new File("src/main/java/Theme.xml");

	public static void main(String[] args) {
		JAXB_Convert jaCon = new JAXB_Convert();
		Theme theme = jaCon.jaxbXMLToObject_2();
		// System.out.print(theme.getAuthor());
	}

	// -------------------XML to Object - n doi
	// tuong------------------------------------
	// Tra ve Theme nao thi do la RootElement trong XML
	public  Theme jaxbXMLToObject_2() {
		try {
			// Khoi tao Context
			JAXBContext context = JAXBContext.newInstance(Theme.class);
			// Tao Unmarshaller tu Context
			Unmarshaller un = context.createUnmarshaller();
			// File xml phu thuoc vao doi tuong + duong duong path
			Theme theme = (Theme) un.unmarshal(new File(
					"src/main/java/Theme.xml"));
			System.out.println("<theme>" + "\n" + "<name>" + theme.getName()
					+ "</name>" + "\n" + "<version>" + theme.getVersion()
					+ " </version>" + "\n" + "<patch>" + theme.getPatch()
					+ "</patch>" + "\n" + "<author> " + theme.getAuthor()
					+ "</author>");
			// System.out.println("Get Header: ");
			// List<Header> list = theme.getHeader();
			// Vong lap lay List <header> tu theme
			for (Header header : theme.getHeader()) {
				// System.out.println(header.getLogo());
				System.out.println("<header>");

				for (Logo logo : header.getLogo()) {
					System.out
							.println("<logo>" + "\n" + "<image>"
									+ logo.getImage() + "</image>" + "\n"
									+ "<text>" + logo.getText() + "</text>"
									+ "\n" + "<url>" + logo.getUrl() + "</url>"
									+ "\n" + "<isText>" + logo.getIsText()
									+ "</isText>" + "\n" + "</logo>");

				}

				System.out.println("</header>" + "\n");

			}

			// Vong lap lay List<Content> tu theme
			for (Content content : theme.getContent()) {
				System.out.println("<content>" + "\n");
				TopContent t_content = content.getTop_content();

				// Vong lap lay List<Form> tu top-content

				for (Form f : t_content.getForm()) {
					System.out.println("<top_content>" + "\n");
					System.out.println("<form " + "action='" + f.getAction()
							+ "'" + "method = '" + f.getMethod() + "'>");

					// Vong lap lay List<lable> tu Form

					for (Label label : f.getLabel()) {
						System.out.println("<lable>");
						System.out.println(label.getText() + ": ");
						System.out.println("</lable>");

					}

					// Vong lap lay List<Input> tu Form

					for (Input input : f.getInput()) {
						System.out.println("<input ");

						System.out.println("type = ' " + input.getInputType()
								+ "' " + "name = '" + input.getInputName()
								+ "' " + "length = '" + input.getInputLength()
								+ "' " + "value = '" + input.getInputValue()
								+ "'");

					}

					System.out.println("</form>" + "\n");

					System.out.println("</top_content>" + "\n");

				}
				System.out.println("</content>" + "\n");

			}
			System.out.println("</theme>" + "\n");

			return theme;

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}
}