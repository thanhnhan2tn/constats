package vn.edu.cit;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(){
		return "home";
	}
	@RequestMapping(value="/admincp", method=RequestMethod.GET)
	public String admin(ModelMap m){
		m.put("title", "AdminCP");
		return "admincp/home";
	}
}
