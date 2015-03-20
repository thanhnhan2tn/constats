package vn.edu.cit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping(value = "/admincp", method = RequestMethod.GET)
	public String admin(ModelMap m) {
		m.put("title", "AdminCP");
		return "admincp/home";
	}

	@RequestMapping(value = "/admincp/{action}", method = RequestMethod.GET)
	public String manager(ModelMap m, @PathVariable("action") String action) {
		m.put("title", "AdminCP");
		return "admincp?action=usermanager";
	}
}
