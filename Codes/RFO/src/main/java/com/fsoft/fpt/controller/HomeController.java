package com.fsoft.fpt.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fsoft.fpt.dao.AccountDAO;
import com.fsoft.fpt.dao.AgreementDAO;
import com.fsoft.fpt.dao.AgreementDealerDAO;
import com.fsoft.fpt.dao.AgreementStatusDAO;
import com.fsoft.fpt.dao.BandingDAO;
import com.fsoft.fpt.dao.CustomerTypeDAO;
import com.fsoft.fpt.dao.FundingMethodDAO;
import com.fsoft.fpt.dao.RFONumberDAO;
import com.fsoft.fpt.dao.RFOUserDAO;
import com.fsoft.fpt.model.Agreement;
import com.fsoft.fpt.model.AgreementDealer;
import com.fsoft.fpt.model.AgreementStatus;
import com.fsoft.fpt.model.Banding;
import com.fsoft.fpt.model.CustomerType;
import com.fsoft.fpt.model.FundingMethod;
import com.fsoft.fpt.model.RFONumber;
import com.fsoft.fpt.model.RFOUser;
import com.fsoft.fpt.model.Volume;
import com.fsoft.fpt.form.DealersForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	RFONumberDAO rfoNumberDAO;
	@Autowired
	CustomerTypeDAO customerTypeDAO;
	@Autowired
	AgreementDAO agreementDAO;
	@Autowired
	FundingMethodDAO fundingMethodDAO;
	@Autowired
	RFOUserDAO rfoUserDAO;
	@Autowired
	AgreementStatusDAO agreementStatusDAO;
	@Autowired
	AgreementDealerDAO agreementDealerDAO;
	@Autowired
	BandingDAO bandingDAO;
	@Autowired
	AccountDAO accountDAO;

	/**
	 * @author Luong Duc Duy
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String index(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "login";
		} else {
			return "redirect:/home";
		}

	}

	/**
	 * @author Luong Duc Duy
	 * @param request
	 * @return
	 */
	@RequestMapping(value = { "/loginCheck" }, method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean result = accountDAO.check(username, password);
		if (result == true) {
			session.setAttribute("username", username);
			return "redirect:/home";
		} else {
			return "redirect:/";
		}
	}

	/**
	 * @author Luong Duc Duy Simply selects the home view to render by returning
	 *         its name.
	 */
	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public ModelAndView home(HttpServletRequest request) {
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
		return new ModelAndView("home", "map", map);
	}

	/**
	 * @author Luong Duc Duy Handling new Adding agreement request
	 */
	@RequestMapping(value = "/addAgreement")
	public String addAgreementHandling(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "redirect:/";
		}
		session.setAttribute("agreement", new Agreement());
		session.setAttribute("dealerIdList", new ArrayList<String>());
		List<Integer> bandingList = new ArrayList<Integer>();
		bandingList.add(-1);
		bandingList.add(300);
		session.setAttribute("bandingList", bandingList);
		session.setAttribute("state", "add");
		return "redirect:/addAgreementCustomer";
	}

	/**
	 * @author Luong Duc Duy Handling edit adding agreemnt request with
	 *         agreement id
	 */
	@RequestMapping("/updateAgreement")
	public String editAgreementHandling(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "redirect:/";
		}
		String agreementIdTemp = request.getParameter("agreementId");
		int agreementId = Integer.parseInt(agreementIdTemp);
		Agreement agreement = agreementDAO.get(agreementId);
		session.setAttribute("agreement", agreement);
		List<AgreementDealer> agreementDealers = agreementDealerDAO
				.list(agreementId);
		List<Integer> dealerIdList = new ArrayList<Integer>();

		// Get dealerIdList
		for (int i = 0; i < agreementDealers.size(); i++) {
			dealerIdList.add(agreementDealers.get(i).getRfoUserId());
		}
		session.setAttribute("dealerIdList", dealerIdList);

		// Get banding list
		List<Integer> bandingList = new ArrayList<Integer>();
		bandingList = bandingDAO.getBandingMilStone(agreement.getVolumeId());

		session.setAttribute("bandingList", bandingList);

		session.setAttribute("state", "update");
		return "redirect:/updateAgreementCustomer";
	}

	/**
	 * @author Luong Duc Duy
	 * @return View edit agreement customer
	 */
	@RequestMapping(value = { "/addAgreementCustomer",
			"/updateAgreementCustomer" })
	public ModelAndView addAgreement(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		List<RFONumber> customers = new ArrayList<RFONumber>();
		List<CustomerType> customerTypes = new ArrayList<CustomerType>();
		Map<String, Object> map = new HashMap<String, Object>();

		customers = rfoNumberDAO.list();
		customerTypes = customerTypeDAO.list();

		map.put("customers", customers);
		map.put("customerTypes", customerTypes);

		return new ModelAndView("addAgreementCustomer", "map", map);
	}

	/**
	 * @author Luong Duc Duy TODO Handling select customer
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addAgreementCustomerHandling", method = RequestMethod.POST)
	public String addAgreementBasicHandling(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String state = (String) session.getAttribute("state");
		Agreement agreement = (Agreement) session.getAttribute("agreement");
		int rfoNumberId = Integer.parseInt(request.getParameter("rfoNumberId"));

		RFONumber rfoNumber = rfoNumberDAO.get(rfoNumberId);

		agreement.setRfoNumberId(rfoNumberId);
		agreement.setRfoNumber(rfoNumber);
		agreement.setAgreementNumber(agreementDAO.getMaxAgreementNumber() + 1);
		agreement.setVariantNumber(agreementDAO.getMaxVariantNumber() + 1);
		session.setAttribute("agreement", agreement);
		return "redirect:/" + state + "AgreementBasic";
	}

	/**
	 * @author Luong Duc Duy
	 * @param View
	 *            agreement update basic information
	 * @return
	 */
	@RequestMapping(value = { "/addAgreementBasic", "/updateAgreementBasic" })
	public ModelAndView addAgreementBasic(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		List<FundingMethod> fundingMethods = fundingMethodDAO.list();
		return new ModelAndView("addAgreementBasic", "fundingMethods",
				fundingMethods);
	}

	/**
	 * @author Luong Duc Duy
	 * @param agreementBasic
	 * @param Handling
	 *            agreement update basic information
	 * @return
	 */
	@RequestMapping(value = "/addAgreementBasicHandling", method = RequestMethod.POST)
	public String addAgreementBasicHandling(
			@ModelAttribute Agreement agreementBasic, HttpServletRequest request) {
		String result = "";
		HttpSession session = request.getSession();

		String state = (String) session.getAttribute("state");
		Agreement agreement = (Agreement) session.getAttribute("agreement");
		agreement.setName(agreementBasic.getName());
		agreement.setDescription(agreementBasic.getDescription());
		agreement.setSignRequired(agreementBasic.getSignRequired());
		agreement.setFundingMethodId(agreementBasic.getFundingMethodId());
		agreement.setFundingMethod(fundingMethodDAO.get(agreementBasic
				.getFundingMethodId()));
		agreement.setPaymentTo(agreement.getPaymentTo());
		agreement.setHandlingCharge(agreementBasic.getHandlingCharge());
		agreement.setDealerVisibility(agreementBasic.getDealerVisibility());
		agreement.setDiscountUnit(agreementBasic.getDiscountUnit());
		agreement.setCombinability(agreementBasic.getCombinability());
		agreement.setStartDate(agreementBasic.getStartDate());
		agreement.setEndDate(agreementBasic.getEndDate());
		session.setAttribute("agreement", agreement);

		String buttonType = (String) request.getParameter("submit");
		if (buttonType.equals("next")) {
			result = "redirect:/" + state + "AgreementDealer";
		} else if (buttonType.equals("back")) {
			result = "redirect:/" + state + "AgreementCustomer";
		} else {
		}
		return result;
	}

	/**
	 * @author Luong Duc Duy TODO View Agreement Delaer
	 * @return
	 */

	@RequestMapping(value = { "/addAgreementDealer", "/updateAgreementDealer" })
	public ModelAndView addAgreementDealer(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		List<RFOUser> dealers = rfoUserDAO.list();
		return new ModelAndView("addAgreementDealer", "dealers", dealers);
	}

	/**
	 * @author Luong Duc Duy
	 * @param dealersForm
	 * @param request
	 * @return Handling choosing agreement Dealer
	 */
	@RequestMapping(value = "/addAgreementDealerHandling", method = RequestMethod.POST)
	public String addAgreementDealerHandling(
			@ModelAttribute DealersForm dealersForm, HttpServletRequest request) {
		String result = "";
		HttpSession session = request.getSession();
		String state = (String) session.getAttribute("state");
		List<Integer> dealerIdList = dealersForm.getDealerList();
		session.setAttribute("dealerIdList", dealerIdList);

		String buttonType = (String) request.getParameter("submit");
		if (buttonType.equals("next")) {
			result = "redirect:/" + state + "AgreementVolume";
		} else if (buttonType.equals("back")) {
			result = "redirect:/" + state + "AgreementBasic";
		} else {

		}
		return result;
	}

	/**
	 * @author Luong Duc Duy
	 * @param request
	 * @return View AgreementVolume
	 */
	@RequestMapping(value = { "/addAgreementVolume", "/updateAgreementVolume" })
	public ModelAndView addAgreementVolume(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		List<Integer> bandingList = (List<Integer>) session
				.getAttribute("bandingList");
		List<Banding> bandings = new ArrayList<Banding>();
		for (int i = 0; i < bandingList.size(); i++) {
			Banding banding = new Banding();
			banding.setMin(bandingList.get(i) + 1);
			if (i == bandingList.size() - 1) {
				banding.setMax(bandingList.get(i) + 1);
			} else {
				banding.setMax(bandingList.get(i + 1));
			}
			bandings.add(banding);
		}
		return new ModelAndView("addAgreementVolume", "bandings", bandings);
	}

	/**
	 * @author Luong Duc Duy
	 * @param request
	 * @return Handling AgreementVolume
	 */
	@RequestMapping(value = "/addAgreementVolumeHandling", method = RequestMethod.POST)
	public String addAgreementVolumeHandling(@ModelAttribute Volume volume,
			HttpServletRequest request) {
		String result = "";
		HttpSession session = request.getSession();
		String state = (String) session.getAttribute("state");
		Agreement agreement = (Agreement) session.getAttribute("agreement");
		volume.setVolumeId(agreement.getVolumeId());
		if (volume.getTriggerCredit() != null && volume.getPaymentTo() != null) {
			agreement.setVolume(volume);
		}
		session.setAttribute("agreement", agreement);
		String buttonType = request.getParameter("submit");
		if (buttonType.equals("next")) {
			result = "redirect:/" + state + "AgreementMiscText";
		} else if (buttonType.equals("back")) {
			result = "redirect:/" + state + "AgreementDealer";
		} else {
		}
		return result;
	}

	/**
	 * @author Luong Duc Duy
	 * @return View AgreementMiscText
	 */
	@RequestMapping(value = { "/addAgreementMiscText",
			"/updateAgreementMiscText" })
	public String addAgreementMiscText(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "redirect:/";
		}
		return "addAgreementMiscText";
	}

	/**
	 * @author Luong Duc Duy
	 * @param request
	 * @return Handling agreement misc text
	 */
	@RequestMapping(value = "/addAgreementMiscTextHandling", method = RequestMethod.POST)
	public String addAgreementMiscTextHandling(@ModelAttribute Volume volume,
			HttpServletRequest request) {
		String result = "";
		HttpSession session = request.getSession();
		String state = (String) session.getAttribute("state");
		String creditNote = (String) request.getParameter("creditNote");
		String justification = (String) request.getParameter("justification");
		Agreement agreement = (Agreement) session.getAttribute("agreement");
		agreement.setCreditNoteText(creditNote);
		agreement.setJustification(justification);
		session.setAttribute("agreement", agreement);
		String buttonType = request.getParameter("submit");
		if (buttonType.equals("next")) {
			result = "redirect:/" + state + "AgreementConfirmation";
		} else if (buttonType.equals("back")) {
			result = "redirect:/" + state + "AgreementVolume";
		} else {
		}
		return result;
	}

	/**
	 * @author Luong Duc Duy
	 * @return view agreement sumary
	 */
	@RequestMapping(value = { "/addAgreementConfirmation",
			"/updateAgreementConfirmation" })
	public String addAgreementConfirmation(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "redirect:/";
		}
		return "addAgreementConfirmation";
	}

	/**
	 * @author Luong Duc Duy
	 * @return Handling add agreement confirmation
	 */
	@RequestMapping(value = "/submitAgreement", method = RequestMethod.POST)
	public ModelAndView submitAgreement(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String buttonType = request.getParameter("submit");
		Agreement agreement = (Agreement) session.getAttribute("agreement");
		if (agreement == null) {
			return new ModelAndView("addAgreementResult", "addAgreementResult",
					"<h2 style='color:#d43f3a'>Sorry! You have not create a new agreement.</h2>");
		}

		if (buttonType.equals("back") == true) {
			return new ModelAndView("redirect:/addAgreementMiscText");
		} else if (buttonType.equals("next") == true) {
			agreement.setStatusId(2);
			agreement.setAgreementStatus(agreementStatusDAO.get(2));
		} else if (buttonType.equals("draft") == true) {
			agreement.setStatusId(1);
			agreement.setAgreementStatus(agreementStatusDAO.get(1));
		}
		List<Integer> bandingList = (List<Integer>) session
				.getAttribute("bandingList");
		List<Integer> dealerIdList = (List<Integer>) session
				.getAttribute("dealerIdList");
		List<Banding> bandings = new ArrayList<Banding>();

		// TODO Create new agreement with banding
		for (int i = 0; i < bandingList.size(); i++) {
			Banding banding = new Banding();
			banding.setMin(bandingList.get(i) + 1);
			if (i == bandingList.size() - 1) {
				banding.setMax(bandingList.get(i) + 1);
			} else {
				banding.setMax(bandingList.get(i + 1));
			}
			bandings.add(banding);
		}
		agreement = agreementDAO.create(agreement, bandings);

		// TODO Get new agreementID
		int agreementId = agreementDAO.getMaxAgreementId();

		// TODO Connect new agreement with DealerList
		if (dealerIdList == null) {
			dealerIdList = new ArrayList<Integer>();
		}
		for (int i = 0; i < dealerIdList.size(); i++) {
			AgreementDealer agreementDealer = new AgreementDealer();
			agreementDealer.setAgreementId(agreementId);
			int dealerId = Integer.parseInt(dealerIdList.get(i) + "");
			agreementDealer.setRfoUserId(dealerId);
			agreementDealerDAO.create(agreementDealer);
		}
		session.removeAttribute("agreement");
		session.removeAttribute("bandingList");
		session.removeAttribute("dealerIdList");
		session.removeAttribute("state");
		return new ModelAndView("addAgreementResult", "addAgreementResult",
				"<h2 style='color:#4cae4c'>Your agreement has been submitted!</h2>");
	}

	/**
	 * @author Luong Duc Duy
	 * @return Handling update agreement confirmation
	 */
	@RequestMapping(value = "/updateAgreement", method = RequestMethod.POST)
	public ModelAndView updateAgreement(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String buttonType = request.getParameter("submit");
		Agreement agreement = (Agreement) session.getAttribute("agreement");
		if (agreement == null) {
			return new ModelAndView(
					"addAgreementResult",
					"addAgreementResult",
					"<h2 style='color:#d43f3a'>Sorry! You have not choose a agreement to edit.</h2>");
		}

		if (buttonType.equals("back") == true) {
			return new ModelAndView("redirect:/addAgreementMiscText");
		} else if (buttonType.equals("next") == true) {
			agreement.setStatusId(2);
			agreement.setAgreementStatus(agreementStatusDAO.get(2));
		} else if (buttonType.equals("draft") == true) {
			agreement.setStatusId(1);
			agreement.setAgreementStatus(agreementStatusDAO.get(1));
		}
		List<Integer> bandingList = (List<Integer>) session
				.getAttribute("bandingList");
		for (int i = 0; i < bandingList.size(); i++) {
			System.out.println("Bading = " + bandingList.get(i));
		}
		List<Integer> dealerIdList = (List<Integer>) session
				.getAttribute("dealerIdList");
		List<Banding> bandings = new ArrayList<Banding>();

		// TODO Create new agreement with banding
		for (int i = 0; i < bandingList.size(); i++) {
			Banding banding = new Banding();
			banding.setMin(bandingList.get(i) + 1);
			if (i == bandingList.size() - 1) {
				banding.setMax(bandingList.get(i) + 1);
			} else {
				banding.setMax(bandingList.get(i + 1));
			}
			bandings.add(banding);
			System.out.println(banding.getMin() + " + " + banding.getMax());
		}
		agreement = agreementDAO.update(agreement, bandings);

		// TODO Get agreementID
		int agreementId = agreement.getAgreementId();

		// TODO Connect new agreement with DealerList
		if (dealerIdList == null) {
			dealerIdList = new ArrayList<Integer>();
		}
		agreementDealerDAO.delete(agreementId);

		for (int i = 0; i < dealerIdList.size(); i++) {
			AgreementDealer agreementDealer = new AgreementDealer();
			agreementDealer.setAgreementId(agreementId);
			int dealerId = Integer.parseInt(dealerIdList.get(i) + "");
			agreementDealer.setRfoUserId(dealerId);
			agreementDealerDAO.create(agreementDealer);
		}
		session.removeAttribute("agreement");
		session.removeAttribute("bandingList");
		session.removeAttribute("dealerIdList");
		session.removeAttribute("state");
		return new ModelAndView("addAgreementResult", "addAgreementResult",
				"<h2 style='color:#4cae4c'>Your agreement has been updated!</h2>");
	}

	/**
	 * @author Luong Duc Duy Dieu huong trong 7 buoc tao add new agreement
	 */
	@RequestMapping(value = "/addAgreementNavigation")
	public String addAgreementNavigation(HttpServletRequest request) {
		String result = "";
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "redirect:/";
		}
		String state = (String) session.getAttribute("state");
		String buttonType = request.getParameter("submit");
		if (buttonType.equals("1")) {
			result = "redirect:/" + state + "AgreementCustomer";
		} else if (buttonType.equals("2")) {
			result = "redirect:/" + state + "AgreementBasic";
		} else if (buttonType.equals("3")) {
			result = "redirect:/" + state + "AgreementDealer";
		} else if (buttonType.equals("4")) {
			result = "redirect:/" + state + "AgreementVolume";
		} else if (buttonType.equals("5")) {
			result = "redirect:/" + state + "AgreementMiscText";
		} else if (buttonType.equals("6")) {
			result = "redirect:/" + state + "AgreementConfirmation";
		}
		return result;
	}

	/**
	 * @author Luong Duc Duy TODO Search agreement by condition
	 */
	@RequestMapping(value = "/searchAgreement")
	public ModelAndView searchAgreement(ModelAndView model,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		List<Agreement> agreements = agreementDAO.list();
		List<AgreementStatus> agreementStatuses = agreementStatusDAO.list();
		List<CustomerType> customerTypes = customerTypeDAO.list();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("agreements", agreements);
		map.put("agreementStatuses", agreementStatuses);
		map.put("customerTypes", customerTypes);
		return new ModelAndView("searchAgreement", "map", map);
	}

	/**
	 * @author: Huynh Thanh Nha This method to update status when submit
	 *          agreement
	 */
	@RequestMapping(value = "/updateAgreementStatus", method = RequestMethod.GET)
	public String updateAgreementStatus(
			@RequestParam("agreementId") int agreementId,
			@RequestParam("statusId") int statusId, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "redirect:/";
		}
		agreementDAO.updateStatus(agreementId, statusId);
		return "redirect:/viewAgreement?agreementId=" + agreementId;
	}

	/**
	 * @author Luong Duc Duy
	 */
	@RequestMapping(value = "/viewAgreementHandling")
	public String viewAgreementHandling(
			@RequestParam(value = "agreementId", required = false) Integer agreementId,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return "redirect:/";
		}
		String buttonType = request.getParameter("submit");

		if (buttonType.equals("copy") == true) {
			return "redirect:/copyAgreement?agreementId=" + agreementId;
		} else {
			return "redirect:/viewAgreement?agreementId=" + agreementId;
		}
	}

	/**
	 * @author Luong Duc Duy
	 * 
	 */
	@RequestMapping(value = "/viewAgreement")
	public ModelAndView viewAgreement(
			@RequestParam(value = "agreementId", required = false) Integer agreementId,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		Agreement agreement = agreementDAO.get(agreementId);
		return new ModelAndView("viewAgreement", "agreement", agreement);
	}

	/**
	 * @author Luong Duc Duy TODO Handling update agreement with 3 options:
	 *         edit, extend, submit, reject, terminate, approved
	 */
	@RequestMapping(value = "/updateAgreementInformation")
	public ModelAndView updateAgreement(
			@RequestParam(value = "agreementId", required = false) Integer agreementId,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		System.out.println("Call updateAgreementInformation");
		String buttonType = request.getParameter("submit");
		Agreement agreement = agreementDAO.get(agreementId);

		if (buttonType.equals("terminate") == true) {
			return new ModelAndView(
					"redirect:/updateAgreementStatus?agreementId="
							+ agreementId + "&statusId=6");
		} else if (buttonType.equals("extend") == true) {
			return new ModelAndView("redirect:/extendAgreement?agreementId="
					+ agreementId);

			/**
			 * @author Huynh Thanh Nha Add button "submit", "reject" and
			 *         "approve"
			 */
		} else if (buttonType.equals("submit") == true) {
			return new ModelAndView(
					"redirect:/updateAgreementStatus?agreementId="
							+ agreementId + "&statusId=2");
		} else if (buttonType.equals("reject") == true) {
			return new ModelAndView("redirect:/rejectView?agreementId="
					+ agreementId);
		} else if (buttonType.equals("approve") == true) {
			return new ModelAndView(
					"redirect:/updateAgreementStatus?agreementId="
							+ agreementId + "&statusId=4");
		} else if (buttonType.equals("edit") == true) {
			return new ModelAndView("redirect:/updateAgreement?agreementId="
					+ agreementId);
		}
		return new ModelAndView("viewAgreement", "agreement", agreement);
	}

	/**
	 * @author Huynh Thanh Nha Update reject status
	 */
	@RequestMapping(value = "/updateRejectAgreement", method = RequestMethod.POST)
	public ModelAndView updateRejectAgreement(
			@RequestParam(value = "agreementId", required = false) Integer agreementId,
			HttpServletRequest request) {
		String buttonType = request.getParameter("submit");
		Agreement agreement = agreementDAO.get(agreementId);
		if (buttonType.equals("reject") == true) {
			return new ModelAndView(
					"redirect:/updateAgreementStatus?agreementId="
							+ agreementId + "&statusId=5");
		}
		return new ModelAndView("viewAgreement", "agreement", agreement);
	}

	/**
	 * @author Huynh Thanh Nha Redirect to rejectView.jsp and get agreement
	 */
	@RequestMapping(value = "/rejectView")
	public ModelAndView rejectView(
			@RequestParam(value = "agreementId", required = false) Integer agreementId,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		Agreement agreement = agreementDAO.get(agreementId);
		return new ModelAndView("rejectView", "agreement", agreement);
	}

	/**
	 * extendAgreement,
	 * 
	 * @author ThanhNhan, redirect to extendAgreement.jsp and get agreementId
	 */
	@RequestMapping(value = "/extendAgreement")
	public ModelAndView extendAgreement(
			@RequestParam(value = "agreementId", required = false) Integer agreementId,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		Agreement agreement = agreementDAO.get(agreementId);
		return new ModelAndView("extendAgreement", "agreement", agreement);
	}

	/**
	 * isDateValidate, validate date input format
	 * 
	 * @author ThanhNhan
	 */
	public boolean isThisDateValid(String dateToValidate) {
		// if input empty, return false
		if (dateToValidate == null) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(false);
		try {
			// if not valid, it will throw ParseException
			Date date = sdf.parse(dateToValidate);
			System.out.println(date + " is valid!");
		} catch (ParseException e) {
			System.out.println("date invalid!");
			return false;
		}
		return true;
	}

	/**
	 * extendAgreement,
	 * 
	 * @author ThanhNhan, redirect to extendAgreement.jsp and get agreementId
	 */
	@RequestMapping(value = "/extendAgreementAction", method = RequestMethod.POST)
	public String extendAgreementAction(HttpServletRequest request) {
		String startdate = request.getParameter("startDate");
		String enddate = request.getParameter("endDate");
		int agreementId = Integer.parseInt(request.getParameter("agreementId"));

		String buttonType = request.getParameter("submit");
		if (buttonType.equals("submit") == true) {
			if (this.isThisDateValid(startdate)
					&& this.isThisDateValid(enddate)) {
				int variantNumber = agreementDAO.getMaxVariantNumber() + 1;
				agreementDAO.extend(agreementId, startdate, enddate,
						variantNumber);
			}
		}
		return "redirect:/viewAgreement?agreementId=" + agreementId;
	}

	/**
	 * copyAgreement,
	 * 
	 * @author ThanhNhan, redirect to copyAgreement.jsp
	 */

	@RequestMapping(value = "/copyAgreement")
	public ModelAndView copyAgreement(HttpServletRequest request) {
		// Get session from request
		HttpSession session = request.getSession();
		// Check session
		String username = (String) session.getAttribute("username");
		if (username == null) {
			return new ModelAndView("redirect:/");
		}
		// Get agreementId from request
		int agreementId = Integer.parseInt(request.getParameter("agreementId"));
		// Get agreement from database with agreementId
		Agreement agreement = agreementDAO.get(agreementId);
		// Generate new Variant Number
		int newVariantNumber = agreementDAO.getMaxVariantNumber() + 1;

		// add agreement to session
		session.setAttribute("agreement", agreement);
		session.setAttribute("state", "add");
		// redirect to copyAgreement.jsp page
		return new ModelAndView("copyAgreement", "newVariantNumber",
				newVariantNumber);
	}

	/**
	 * CopyAgreementAction,
	 * 
	 * @author ThanhNhan
	 * @param request
	 *            New Agreement with choose
	 */
	@RequestMapping(value = "/copyAgreementAction", method = RequestMethod.POST)
	public String copyAgreementAction(HttpServletRequest request) {
		// get Session
		HttpSession session = request.getSession();
		// get AgreementId
		int agreementId = Integer.parseInt(request.getParameter("agreementId"));
		// get Agreement from database with agreementId
		Agreement agreement = agreementDAO.get(agreementId);

		// Get agreement Dealer
		List<AgreementDealer> agreementDealers = agreementDealerDAO
				.list(agreementId);
		List<Integer> dealerIdList = new ArrayList<Integer>();

		// Get dealerIdList
		for (int i = 0; i < agreementDealers.size(); i++) {
			dealerIdList.add(agreementDealers.get(i).getRfoUserId());
		}
		session.setAttribute("dealerIdList", dealerIdList);

		// Get banding list
		List<Integer> bandingList = new ArrayList<Integer>();
		bandingList = bandingDAO.getBandingMilStone(agreement.getVolumeId());

		session.setAttribute("bandingList", bandingList);

		// Get buttonType from request
		String buttonType = request.getParameter("submit");
		if (buttonType.equals("newcustomer") == true) {
			// Case for New Customer
			int newAgreementNumber = agreementDAO.getMaxAgreementNumber() + 1;
			agreement.setAgreementNumber(newAgreementNumber);
			session.setAttribute("agreement", agreement);

			// redirect to UC1 "Basic Screen",addAgreementCustomer
			return "redirect:/addAgreementCustomer";
		} else if (buttonType.equals("newvariant") == true) {
			// Case for New Variant
			int newVariantNumber = Integer.parseInt(request
					.getParameter("newVariantNumber"));
			agreement.setVariantNumber(newVariantNumber);
		} else if (buttonType.equals("samecustomer") == true) {
			// Case for Same customer
			int newAgreementNumber = agreementDAO.getMaxAgreementNumber() + 1;
			agreement.setAgreementNumber(newAgreementNumber);
		}
		// Add new agreement to session
		session.setAttribute("agreement", agreement);
		// redirect to UC1 "Basic Screen", addAgreementBasic
		return "redirect:/addAgreementBasic";
	}
}
