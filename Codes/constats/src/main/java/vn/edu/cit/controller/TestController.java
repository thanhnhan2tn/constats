package vn.edu.cit.controller;

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
		String username = (String) request.getParameter("username");
		long maxId = repository.count();
		long userId = 0;
		System.out.println(maxId);
		
		System.out.println("Retrieved User=" + username);
		if (maxId != 0) {
			userId = maxId + 1;
		} else {
			userId = 1;
		}
		
		User user = new User(userId,username,"1234","1", "Nhamc","tha@mail.com","1111");
		
		if (!repository.exists(username)) {
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
