package vn.edu.cit;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.cit.model.Server;
import vn.edu.cit.servercontrol.Power;
import vn.edu.cit.servercontrol.nics_controller.Nic;
import vn.edu.cit.servercontrol.nics_controller.Nics;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
				DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/chbi", method = RequestMethod.GET)
	public String shutDown() {

		return "index";
	}

	@RequestMapping(value = "/vn", method = RequestMethod.GET)
	public String reStart() {

		return "xuly";
	}

	@RequestMapping(value = "/changeNIC", method = RequestMethod.GET)
	public String changeNic() throws FileNotFoundException {
		Server sv = new Server(0, "192.168.0.101", 22, "root", "root");
		Power pw = new Power();
		Nics ns = Nic.Nics_convert("E:/XML_File/NIC.xml");
		Nic nic = new Nic();
		String kq = nic.getTextConfig(ns);
		// Luu y neu trong String co "\n" lenh van thuc thi nhung ko jsch qua
		// ben server dc -> chua hieu dieu nay
		pw.changeNic(sv, kq);
		System.out.print(kq);
		return "index";
	}
}
