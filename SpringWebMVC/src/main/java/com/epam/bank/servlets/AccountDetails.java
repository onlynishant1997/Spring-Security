package com.epam.bank.servlets;

import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.bank.exceptions.AccountNumberDoesnotExistException;
import com.epam.bank.models.Account;
import com.epam.bank.services.AccountManager;

/**
 * Account Details Controller
 * 
 * @author Nishant_Bansal
 */
@Controller
public class AccountDetails extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AccountManager accountManager;

	private Logger logger = Logger.getLogger(AccountDetails.class.getName());

	/**
	 * Gets the account details UI form.
	 *
	 * @return the account details UI form
	 */
	@GetMapping("/AccountDetails")
	public String getAccountDetailsUIForm() {
		logger.info("In get account details ui form controller");
		return "accountdetailsform";
	}

	/**
	 * Gets the account details.
	 *
	 * @param model the model
	 * @param accNo the acc no
	 * @return the account details
	 */
	@PostMapping("/AccountDetails")
	public String getAccountDetails(Model model, @RequestParam("number") int accNo) {
		logger.info("In get account details controller");
		String pageName = null;
		try {
			Account account = null;
			if (accountManager != null) {
				try {
					account = accountManager.getAccountDetails(accNo);
					model.addAttribute("account", account);
					pageName = "accountdetails";
				} catch (AccountNumberDoesnotExistException e) {
					pageName = "wrongaccountnumber";
				}
			}
		} catch (Exception e) {
			pageName = "invalidinput";
			e.printStackTrace();
		}
		logger.info("return account details UI");
		return pageName;
	}

}
