package com.epam.bank.services;

import com.epam.bank.exceptions.AccountNumberDoesnotExistException;
import com.epam.bank.models.Account;
import com.epam.bank.models.User;

/**
 * Interface For Account Manager.
 * 
 * @author Nishant_Bansal
 */
public interface AccountManager {

	/**
	 * Open account.
	 *
	 * @param customerName the customer name
	 * @return true, if successful
	 */
	public int openAccount(User user);

	/**
	 * Close account.
	 *
	 * @param accountNumber the account number
	 * @return true, if successful
	 */
	public boolean closeAccount(int accountNumber) throws AccountNumberDoesnotExistException;

	/**
	 * Gets the account details.
	 *
	 * @param accountNumber the account number
	 * @return the account details
	 */
	public Account getAccountDetails(int accountNumber) throws AccountNumberDoesnotExistException;
}
