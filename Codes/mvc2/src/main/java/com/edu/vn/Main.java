package com.edu.vn;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.Serializable;

public class Main {
  public static void main(String[] argv) throws Exception {
    XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream("E:/Bean.xml")));
    Bean bean = (Bean) decoder.readObject();
    decoder.close();
    System.out.println("ID = " + bean.getId());
  }
}
class Bean implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Long id;
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
}
