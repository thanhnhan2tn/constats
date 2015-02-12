package com.fsoft.fpt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fsoft.fpt.dao.AgreementDAO;
import com.fsoft.fpt.dao.AgreementDealerDAO;
import com.fsoft.fpt.dao.RFONumberDAO;
import com.fsoft.fpt.dao.RFOUserDAO;
import com.fsoft.fpt.model.Agreement;
import com.fsoft.fpt.model.AgreementDealer;
import com.fsoft.fpt.model.Banding;
import com.fsoft.fpt.model.CustomerType;
import com.fsoft.fpt.model.RFONumber;
import com.fsoft.fpt.model.RFOUser;

@Controller
public class DailyStatusController {
	@Autowired
	private RFONumberDAO rfoNumberDAO;
	@Autowired
	private AgreementDAO agreementDAO;
	@Autowired
	private AgreementDealerDAO agreementDealerDAO;
	/**
	 * @author Luong Duc Duy
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/dailyStatus")
	public ModelAndView searchCustomer(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		Integer draft = agreementDAO.count(1);
		Integer waiting = agreementDAO.count(2);
		Integer signature = agreementDAO.count(3);
		Integer approved = agreementDAO.count(4);
		Integer rejected = agreementDAO.count(5);
		Integer discontinued = agreementDAO.count(6);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("draft", draft);
		map.put("waiting", waiting);
		map.put("signature", signature);
		map.put("approved", approved);
		map.put("rejected", rejected);
		map.put("discontinued", discontinued);
		List<Agreement> agreements = agreementDAO.list();
		map.put("agreements", agreements);
		return new ModelAndView("agreementsDailyStats", "map", map);
	}

}