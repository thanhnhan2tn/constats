package vn.edu.cit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceController {

	@RequestMapping(value = "/shutdown/{s}", method = RequestMethod.GET)
	public String shutdown(HttpServletRequest request, HttpSession session,
			@PathVariable(value = "s") String ip) {
		return "redirect:/";
	}

	@RequestMapping(value = "/restart/{s}", method = RequestMethod.GET)
	public String restart(HttpServletRequest request, HttpSession session) {
		String ip = request.getParameter("s");
		System.out.println(ip);
		// ModelAndView mv = new ModelAndView();
		return "redirect:/";
	}
}
