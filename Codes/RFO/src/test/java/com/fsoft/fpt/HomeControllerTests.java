package com.fsoft.fpt;

import static org.junit.Assert.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;

import com.fsoft.fpt.controller.HomeController;
import com.fsoft.fpt.dao.AccountDAO;
import com.fsoft.fpt.dao.AgreementDAO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("servlet-context.xml")
public class HomeControllerTests {
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	MockHttpSession session;
	private MockMvc mockMvc;
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * @author Luong Duc Duy
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		// this.mockMvc = webAppContextSetup(this.wac).build();
		this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController())
				.build();
	}

	/**
	 * @author Luong Duc Duy
	 * @throws Exception
	 */
	@Test
	public void testLoginNoSession() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk())
				.andExpect(view().name("login"))
				.andExpect(forwardedUrl("login"));
	}

	/**
	 * @author Luong Duc Duy
	 * @throws Exception
	 */
	@Test
	public void testLoginSession() throws Exception {
		session.setAttribute("username", new String("admin"));
		mockMvc.perform(get("/").sessionAttr("username", "admin"))
				.andExpect(status().isMovedTemporarily())
				.andExpect(view().name("redirect:/home"));
	}
}
