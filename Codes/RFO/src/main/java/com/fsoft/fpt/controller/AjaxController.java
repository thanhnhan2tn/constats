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
public class AjaxController {
	@Autowired
	private RFONumberDAO rfoNumberDAO;
	@Autowired
	private AgreementDAO agreementDAO;
	@Autowired
	private AgreementDealerDAO agreementDealerDAO;
	/**
	 * @author Luong Duc Duy
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchCustomer", method = RequestMethod.POST)
	public @ResponseBody String searchCustomer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String result = "";
		String rfoNumber = request.getParameter("rfoNumber");
		String customerType = request.getParameter("customerType");
		String name = request.getParameter("name");
		String postCode = request.getParameter("postCode");
		String businessArea = request.getParameter("businessArea");
		String region = request.getParameter("region");
		List<RFONumber> customers = rfoNumberDAO.search(rfoNumber,
				customerType, name, postCode, businessArea, region);
		if (customers.size() == 0) {
			return "<tr><td colspan='8'>No result</td></tr>";
		}
		for (int i = 0; i < customers.size(); i++) {
			RFONumber customer = customers.get(i);
			result += "<tr>";
			result += "<td>" + customer.getRFONumber() + "</td>";
			result += "<td>" + customer.getRFOName() + "</td>";

			result += "<td>" + customer.getCustomerType().getCustomerType()
					+ "</td>";
			result += "<td>" + customer.getPostCode() + "</td>";

			result += "<td>" + customer.getCompany().getBusinessArea()
					+ "</td>";
			result += "<td>" + "</td>";
			result += "<td>"
					+ "<label> &nbsp; <input type='radio' name='rfoNumberId' id='rfonumberid' value='"
					+ customer.getRFONumberId() + "'>&nbsp;</label>" + "</td>";
			result += "</tr>";
		}
		System.out.print(result);
		return result;
	}

	@Autowired
	private RFOUserDAO rfoUserDAO;
	/**
	 * @author Luong Duc Duy
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/searchDealer", method = RequestMethod.POST)
	public @ResponseBody String searchDealer(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		List<String> dealerIdList = (List<String>) session
				.getAttribute("dealerIdList");
		for (int i = 0; i < dealerIdList.size(); i++) {
			System.out.println("x " + dealerIdList.get(i));
		}
		String result = "";
		String dealerCode = request.getParameter("dealerCode");
		String dealerName = request.getParameter("dealerName");
		List<RFOUser> dealers = rfoUserDAO.search(dealerCode, dealerName);
		if (dealers.size() == 0) {
			return "<tr><td colspan='8'>No result</td></tr>";
		}
		for (int i = 0; i < dealers.size(); i++) {
			RFOUser dealer = dealers.get(i);
			result += "<tr>";
			result += "<td>" + dealer.getDealerCode() + "</td>";
			result += "<td>" + dealer.getFirstName() + " "
					+ dealer.getLastName() + "</td>";

			result += "<td>" + dealer.getContactAdress().getTown() + "</td>";
			result += "<td>" + dealer.getContactAdress().getCounty() + "</td>";
			System.out.println((dealerIdList.contains(dealer.getRfoUserId()
					+ "") == true ? "checked" : ""));
			result += "<td>"
					+ "<label> &nbsp; <input class='checkIdList' type='checkbox' "
					+ (dealerIdList.contains(dealer.getRfoUserId() + "") == true ? "checked"
							: "") + " name='dealerList' id='' value=' "
					+ dealer.getRfoUserId() + "'>&nbsp;</label>" + "</td>";
			result += "</tr>";
		}
		System.out.print(result);
		return result;
	}
	/**
	 * @author Luong Duc Duy
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deleteBanding", method = RequestMethod.POST)
	public @ResponseBody String deleteBanding(HttpServletRequest request) {
		String result = "";
		HttpSession session = request.getSession();
		List<Integer> bandingList = (List<Integer>) session
				.getAttribute("bandingList");
		if (bandingList.size() != 1) {
			bandingList.remove(bandingList.size() - 1);
		}
		session.setAttribute("bandingList", bandingList);
		for (int i = 0; i < bandingList.size(); i++) {
			result += "<tr>";
			int now = bandingList.get(i) + 1;
			result += "<td>" + now;
			if (i == bandingList.size() - 1) {
				result += " +";
			} else {
				result += " - " + bandingList.get(i + 1);
			}
			result += "</td><td>";
			if (i == bandingList.size() - 1 && bandingList.size() != 1) {
				result += "<button type='button' class='btn btn-danger btn-xs' onclick='deleteBanding()'>Delete</button>";
			}
			result += "</td>";
			result += "</tr>";
		}
		return result;
	}
	/**
	 * @author Luong Duc Duy
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/addBanding", method = RequestMethod.POST)
	public @ResponseBody String addBanding(HttpServletRequest request) {
		String result = "";
		String isAdd = "0";
		HttpSession session = request.getSession();
		List<Integer> bandingList = (List<Integer>) session
				.getAttribute("bandingList");
		int max = Integer.parseInt(request.getParameter("max"));
		if (max <= bandingList.get(bandingList.size() - 1)) {
			isAdd = "1";
		} else {
			bandingList.add(max);
		}
		session.setAttribute("bandingList", bandingList);
		for (int i = 0; i < bandingList.size(); i++) {
			result += "<tr>";
			int now = bandingList.get(i) + 1;
			result += "<td>" + now;
			if (i == bandingList.size() - 1) {
				result += " +";
			} else {
				result += " - " + bandingList.get(i + 1);
			}
			result += "</td><td>";
			if (i == bandingList.size() - 1 && bandingList.size() != 1) {
				result += "<button type='button' class='btn btn-danger btn-xs' onclick='deleteBanding()'>Delete</button>";
			}
			result += "</td>";
			result += "</tr>";
		}
		result += "#" + isAdd;
		return result;
	}

	

	/**
	 * @author Luong Duc Duy
	 */
	@RequestMapping(value = "/searchAgreement", method = RequestMethod.POST)
	public @ResponseBody String searchAgreement(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String result = "";
		String customerType = request.getParameter("customerType");
		String name = request.getParameter("name");
		String rfoNumber = request.getParameter("rfoNumber");
		String postCode = request.getParameter("postCode");
		String statusId = request.getParameter("statusId");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String agreementNumber = request.getParameter("agreementNumber");
		List<Agreement> agreements = agreementDAO.search(customerType, name,
				rfoNumber, postCode, statusId, startDate, endDate,
				agreementNumber);
		if (agreements.size() == 0) {
			result = "<tr><td colspan='8'>No result</td></tr>";
		} else {
			for (int i = 0; i < agreements.size(); i++) {
				Agreement agreement = agreements.get(i);
				result += "<tr>";
				result += "<td>" + agreement.getRfoNumber().getRFONumber()
						+ "</td>";
				result += "<td>" + agreement.getRfoNumber().getRFOName()
						+ "</td>";
				result += "<td>" + agreement.getRfoNumber().getPostCode()
						+ "</td>";
				result += "<td>" + agreement.getStartDate() + "</td>";
				result += "<td>" + agreement.getEndDate() + "</td>";
				result += "<td>" + agreement.getAgreementNumber() + " / "
						+ agreement.getVariantNumber() + "</td>";
				result += "<td>" + agreement.getAgreementStatus().getStatus()
						+ "</td>";
				result += "<td> <form action='viewAgreement'> <input name='agreementId' value="
						+ agreement.getAgreementId()
						+ " type='hidden'/><button type='submit' class='btn btn-xs btn-default'>Copy</button>&nbsp;<button type='submit' class='btn btn-xs btn-default'>View</button></form></td>";
				result += "</tr>";
			}
		}
		return result;
	}
}
