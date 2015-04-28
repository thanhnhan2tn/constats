package edu.ctu.thanhnhan;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView hometPage(ModelAndView model) {
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping(value = "/login-success", method = RequestMethod.GET)
	public String loginSuccess(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("notify", "toastr['success']('Đăng nhập thành công');");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login-error", method = RequestMethod.GET)
	public String loginError(RedirectAttributes redirectAttributes, HttpServletRequest req) {
		String message = ((Exception) req.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION")).getMessage();
		redirectAttributes.addFlashAttribute("notify", "toastr['error']('" + (message == null ? "Đăng nhập thất bại" : message) + "');");
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout-success", method = RequestMethod.GET)
	public String logout(RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("notify", "toastr['success']('Đăng xuất thành công');");
		return "redirect:/";
	}
	
}
