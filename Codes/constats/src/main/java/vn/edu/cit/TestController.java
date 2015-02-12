package vn.edu.cit;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.cit.model.User;
import vn.edu.cit.repositories.UserRepository;

@Controller
public class TestController {
	@Autowired
	private UserRepository repository;

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request) {
		String username = (String) request.getParameter("userName");
		User user = new User();
		
		user.setUserName(username);
		System.out.println("Retrieved User=" + username);
		user.setPassWord("â");
		user.setEmail("@@");
		user.setSdt("0909");
		
		if(!repository.exists(username)){
			repository.insert(user);
		}		
		return "redirect:/testMongo";
	}

	@RequestMapping(value = "/testMongo", method = RequestMethod.GET)
	public ModelAndView test(ModelMap model) {

		//
		// // read
		List<User> user1 = repository.findAll();
		// System.out.println("Retrieved User=" + user1);
		//
		// // update
		// user1.setUserName("Minh");
		// user1.setDiaChi("Can Tho");
		// userDAO.update(user1);
		// User temp = userDAO.getByUsername(user1.getUserName());
		// System.out.println("Retrieved Person after update=" + temp);

		// delete
		// int count = userDAO.deleteByUsername(user.getUserName());
		// System.out.println("Number of records deleted=" + count);
		ModelAndView modelAndView = new ModelAndView("test");
		modelAndView.addObject("users", user1);
		return modelAndView;
	}

}
