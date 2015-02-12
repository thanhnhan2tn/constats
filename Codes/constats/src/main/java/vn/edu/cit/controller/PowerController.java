package vn.edu.cit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.cit.servercontrol.Power;

@Controller
public class PowerController {

	@RequestMapping(value = "/Shutdown", method = RequestMethod.GET)
	public String shutDown() {
		Power pw = new Power();
//		if (pw.Shutdown()) {
//			System.out.print("Shutdowned!");
//		} else {
//			System.out.print("coloi");
//		}
		return "home";
	}

	@RequestMapping(value = "/Restart", method = RequestMethod.GET)
	public String reStart() {
//		Power pw = new Power();
//
//		if (pw.Restart()) {
//			System.out.print("Shut");
//		} else {
//			System.out.print("coloi");
//		}
		return "home";
	}

}
