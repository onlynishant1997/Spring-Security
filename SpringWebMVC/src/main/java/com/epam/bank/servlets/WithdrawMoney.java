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
import com.epam.bank.exceptions.InSufficientAmountException;
import com.epam.bank.exceptions.InvalidAmountException;
import com.epam.bank.models.Account;
import com.epam.bank.services.AccountManager;
import com.epam.bank.services.TransactionManager;

/**
 * Withdraw money controller.
 * 
 * @author Nishant_Bansal
 */
@Controller
public class WithdrawMoney {

	@Autowired
	private TransactionManager transactionManager;
	@Autowired
	private AccountManager accountManager;

	private Logger logger = Logger.getLogger(WithdrawMoney.class.getName());

	/**
	 * Gets the withdraw money UI form.
	 *
	 * @return the withdraw money UI form
	 */
	@GetMapping("/WithdrawMoney")
	public String getWithdrawMoneyUIForm() {
		logger.info("In withdraw money controller that return ui form");
		return "withdrawmoneyform";
	}

	/**
	 * Withdraw money.
	 *
	 * @param model            the model
	 * @param accNo            the acc no
	 * @param withdrawalAmount the withdrawal amount
	 * @return the string
	 */
	@PostMapping("/WithdrawMoney")
	public String withdrawMoney(Model model, @RequestParam("number") int accNo,
			@RequestParam("amount") int withdrawalAmount) {
		logger.info("In withdraw money controller that withdraws money");
		Account account = null;
		String pageName = null;

		try {
			if (accountManager != null) {
				account = accountManager.getAccountDetails(accNo);
				try {
					if (transactionManager != null)
						transactionManager.withdrawMoney(account, withdrawalAmount);
					model.addAttribute("withdrawed_money", withdrawalAmount);
					model.addAttribute("balance", account.getAccountBalance());
					pageName = "moneywithdrawal";
				} catch (InvalidAmountException e) {
					pageName = "invalidamount";
					e.printStackTrace();
				} catch (InSufficientAmountException e) {
					pageName = "insufficientbalance";
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
		logger.info("At end of withdraw money controller that return ui form");
		return pageName;
	}

}
