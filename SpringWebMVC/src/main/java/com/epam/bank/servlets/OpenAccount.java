package com.epam.bank.servlets;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.bank.enums.Gender;
import com.epam.bank.models.User;
import com.epam.bank.services.AccountManager;

/**
 * Open Account Controller.
 * 
 * @author Nishant_Bansal
 */
@Controller
public class OpenAccount {

	@Autowired
	private AccountManager accountManager;

	private Logger logger = Logger.getLogger(OpenAccount.class.getName());

	/**
	 * Open account UI form.
	 *
	 * @return the string
	 */
	@GetMapping("/OpenAccount")
	public String openAccountUIForm() {
		logger.info("in open account controller that return ui for opening account");
		return "openaccountform";
	}

	/**
	 * Open account.
	 *
	 * @param model  the model
	 * @param name   the name
	 * @param gender the gender
	 * @return the string
	 */
	@PostMapping("/OpenAccount")
	public String openAccount(Model model, @RequestParam String name, @RequestParam String gender) {
		logger.info("In open account controller that opens a account");
		;
		User user = new User();
		user.setName(name);
		if (gender.equals("male")) {
			user.setGender(Gender.MALE);
		} else
			user.setGender(Gender.FEMALE);
		int accountNumber = -1;
		if (accountManager != null)
			accountNumber = accountManager.openAccount(user);
		model.addAttribute("accountNumber", accountNumber);
		logger.info("At end of open account controller that opens a account");
		;
		return "accountcreated";
	}

}
