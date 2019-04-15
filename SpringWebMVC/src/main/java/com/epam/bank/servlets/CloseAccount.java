package com.epam.bank.servlets;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.bank.exceptions.AccountNumberDoesnotExistException;
import com.epam.bank.services.AccountManager;

/**
 * Close Account Controller
 * 
 * @author Nishant_Bansal
 *
 */
@Controller
public class CloseAccount {

	@Autowired
	private AccountManager accountManager;

	private Logger logger = Logger.getLogger(CloseAccount.class.getName());

	/**
	 * Close account UI form.
	 *
	 * @return the string
	 */
	@GetMapping("/CloseAccount")
	public String closeAccountUIForm() {
		logger.info("close account controller returning close account UI form");
		return "closeaccountform";
	}

	/**
	 * Close account.
	 *
	 * @param model the model
	 * @param accNo the acc no
	 * @return the string
	 */
	@PostMapping("/CloseAccount")
	public String closeAccount(Model model, @RequestParam("number") int accNo) {
		logger.info("in close account controller that closes the account");
		model.addAttribute("account_number", accNo);
		String pageName = null;
		try {
			if (accountManager != null) {
				try {
					accountManager.closeAccount(accNo);
					pageName = "accountclosed";
				} catch (AccountNumberDoesnotExistException e) {
					pageName = "wrongaccountnumber";
				}
			}
		} catch (Exception e) {
			pageName = "invalidinput";
			e.printStackTrace();
		}
		logger.info("account closes!!! In method close account controller");
		return pageName;
	}

}
