package vn.edu.cit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping(value="/admincp", method=RequestMethod.GET)
	public String admin(ModelMap m){
		m.put("title", "AdminCP");
		return "admincp/home";
	}
	
	@RequestMapping(value="/admincp/usermanager", method=RequestMethod.GET)
	public String usermanager(ModelMap m){
		m.put("title", "AdminCP");
		return "admincp?action=usermanager";
	}
}
