package com.epam.bank.servlets;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.bank.exceptions.AccountNotActiveException;
import com.epam.bank.exceptions.AccountNumberDoesnotExistException;
import com.epam.bank.exceptions.InvalidAmountException;
import com.epam.bank.models.Account;
import com.epam.bank.services.AccountManager;
import com.epam.bank.services.TransactionManager;

/**
 * Deposit Money Controller.
 * 
 * @author Nishant_Bansal
 */
@Controller
public class DepositMoney {

	@Autowired
	private TransactionManager transactionManager;
	@Autowired
	private AccountManager accountManager;

	private Logger logger = Logger.getLogger(DepositMoney.class.getName());

	/**
	 * Gets the deposit money UI form.
	 *
	 * @return the deposit money UI form
	 */
	@GetMapping("/DepositMoney")
	public String getDepositMoneyUIForm() {
		logger.info("In deposit money controller that return UI for depositing money");
		return "depositmoneyform";

	}

	/**
	 * Deposit money.
	 *
	 * @param model         the model
	 * @param accNo         the acc no
	 * @param depositAmount the deposit amount
	 * @return the string
	 */
	@PostMapping("/DepositMoney")
	public String depositMoney(Model model, @RequestParam("number") int accNo,
			@RequestParam("amount") int depositAmount) {
		logger.info("In deposit money controller that deposits the money");
		String pageName = null;
		try {
			Account account = null;
			try {
				if (accountManager != null) {
					account = accountManager.getAccountDetails(accNo);
					try {
						if (transactionManager != null) {
							transactionManager.depositMoney(account, depositAmount);
						}
						model.addAttribute("balance", account.getAccountBalance());
						pageName = "moneydeposited";
					} catch (InvalidAmountException e) {
						pageName = "invalidamount";
						e.printStackTrace();
					} catch (AccountNotActiveException e) {
						pageName = "inactiveaccount";
						e.printStackTrace();
					}
				}
			} catch (AccountNumberDoesnotExistException e) {
				pageName = "wrongaccountnumber";
				e.printStackTrace();
			}

		} catch (Exception e) {
			pageName = "invalidinput";
			e.printStackTrace();
		}
		logger.info("At the end of function deposit money controller that deposits the money");
		return pageName;
	}

}
