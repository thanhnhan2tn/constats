package test_convert;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "question")
@XmlType(propOrder = {"questionname" ,"answers" })
public class Question {
	private int id;
	private String questionname;
	private List<Answer> answers;

	public Question(int id, String questionname, List<Answer> answers) {
		this.id = id;
		this.questionname = questionname;
		this.answers = answers;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getQuestionname() {
		return questionname;
	}

	public void setQuestionname(String questionname) {
		this.questionname = questionname;
	}

	@XmlElement
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
