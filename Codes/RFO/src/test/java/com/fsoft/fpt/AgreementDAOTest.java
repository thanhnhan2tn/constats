package com.fsoft.fpt;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.fsoft.fpt.dao.AgreementDAO;
import com.fsoft.fpt.model.Agreement;
import com.fsoft.fpt.model.Banding;
import com.fsoft.fpt.model.Volume;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "servlet-context.xml" })
@TransactionConfiguration(defaultRollback = true)
public class AgreementDAOTest {

	@Autowired
	AgreementDAO agreementDAO = new AgreementDAO();
	private Agreement agreement = new Agreement();

	/**
	 * @author Huynh Thanh Nha TODO Test create new agreement
	 */
	@Test
	@Transactional
	public void testCreate() {
		int size = agreementDAO.list().size();

		// Create agreement
		agreement.setAgreementNumber(4);
		agreement.setVariantNumber(4);
		agreement.setName("Focus Aug01");
		agreement.setDescription("Focus on Aug 01");
		agreement.setStartDate("2014-07-31");
		agreement.setEndDate("2014-08-05");
		agreement.setStatusId(5);

		@SuppressWarnings("deprecation")
		Date lstStatusUpdate = new Date(2014, 8, 02);
		agreement.setLastStatusUpdateDate(lstStatusUpdate);
		agreement.setAuthorisedBy("Thanh Nha");

		@SuppressWarnings("deprecation")
		Date authorDate = new Date(2014, 8, 01);
		agreement.setAuthorisedDate(authorDate);

		@SuppressWarnings("deprecation")
		Date createDate = new Date(2014, 8, 01);
		agreement.setCreateDate(createDate);

		agreement.setCreateBy("Duc Duy");

		@SuppressWarnings("deprecation")
		Date lstUpdate = new Date(2014, 07, 28);
		agreement.setLastUpdatedDate(lstUpdate);

		agreement.setLastUpdatedBy("Thanh Nhan");
		agreement.setPaymentTo("Gia Trang");
		agreement.setHandlingCharge(20);
		agreement.setFundingMethodId(1);
		agreement.setCreditNoteText("Test comment");
		agreement.setSignRequired(1);
		agreement.setSignReceived(1);

		@SuppressWarnings("deprecation")
		Date signReceiveDate = new Date(2014, 01, 01);
		agreement.setSignReceivedDate(signReceiveDate);

		agreement.setDealerVisibility("Dealer");
		agreement.setCombinability("Combinability");
		agreement.setNumberOfRegistrations(2);
		agreement.setVolumeId(1);
		agreement.setRfoNumberId(1);
		agreement.setDiscountUnit("%");
		agreement.setJustification("Test justification");

		// Add volume
		Volume volume = new Volume();
		volume.setTriggerCredit("Trigger Credit");
		volume.setPaymentTo("Gia Trang");
		agreement.setVolume(volume);

		List<Banding> bandings = new ArrayList<Banding>();
		agreementDAO.create(agreement, bandings);
		assertTrue(size < agreementDAO.list().size());
	}

	/**
	 * @author Huynh Thanh Nha TODO Test get an agreemnt by Id
	 */

	@Test
	@Transactional
	public void testGet() {
		agreement.setAgreementNumber(1);
		assertEquals(agreement.getAgreementNumber(),
				agreementDAO.get(agreement.getAgreementNumber())
						.getAgreementNumber());
	}

	/**
	 * @author Huynh Thanh Nha TODO Test list all agreement
	 */

	@Test
	@Transactional
	public void testList() {
		agreement.setName("Fsoft Aug05");
		assertEquals(agreement.getName(), agreementDAO.list().get(1).getName());
	}
}
