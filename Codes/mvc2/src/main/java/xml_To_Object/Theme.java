package xml_To_Object;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "theme")
@XmlType(propOrder = { "name", "version", "patch", "author", "header",
		"content" })
public class Theme {
	// Luu y thiet lap cac bien cho dung o buoc tao Field nay de khi tao getter
	// and setter se ko gap truc trac
	String name;
	String version;
	String patch;
	String author;
	List<Header> header;
	List<Content> content;

	public Theme() {
		super();
	}

	// Bat buot phai co ham doi so va ham phai tao cac "this" thi moi lay du
	// lieu
	// vao dc
	public Theme(String name, String version, String patch, String author,
			List<Header> header, List<Content> content) {
		super();

		this.name = name;
		this.version = version;
		this.patch = patch;
		this.author = author;
		this.header = header;
	}

	@XmlElement
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement
	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	@XmlElement
	public String getPatch() {
		return this.patch;
	}

	public void setPatch(String patch) {
		this.patch = patch;
	}

	@XmlElement
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	// Thiet lap ham get and set cac doi tuong listview phai dung voi ten trong
	// file xml
	@XmlElement
	public List<Header> getHeader() {
		return this.header;
	}

	public void setHeader(List<Header> header) {
		this.header = header;
	}

	@XmlElement
	public List<Content> getContent() {
		return this.content;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}

}
