package xml_To_Object;

public class Logo {
String image;
String text;
String url;
Boolean isText;


public Logo() {
	super();
	// TODO Auto-generated constructor stub
}


public Logo(String image, String text, String url, Boolean isText) {
	super();
	this.image = image;
	this.text = text;
	this.url = url;
	this.isText = true;
}


public String getImage() {
	return this.image;
}
public void setImage(String image) {
	this.image = image;
}
public String getText() {
	return this.text;
}
public void setText(String text) {
	this.text = text;
}
public String getUrl() {
	return this.url;
}
public void setUrl(String url) {
	this.url = url;
}
public Boolean getIsText() {
	return this.isText;
}
public void setIsText(Boolean isText) {
	this.isText = isText;
}
	

}



