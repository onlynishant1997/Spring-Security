package com.epam.bank.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bank.dao.AccountManagerDAO;
import com.epam.bank.exceptions.AccountNumberDoesnotExistException;
import com.epam.bank.models.Account;
import com.epam.bank.models.User;

/**
 * The Class AccountManagerIMPL.
 *
 * @author Nishant_Bansal
 */
@Service
public class AccountManagerIMPL implements AccountManager {

	@Autowired
	private AccountManagerDAO accountManagerDAo;
	
	private Logger logger;
	
	public AccountManagerIMPL() {
		logger = Logger.getLogger(AccountManagerIMPL.class.getName());
	}

	/*
	 * @see
	 * com.epam.bank.services.AccountManager#openAccount(com.epam.bank.models.User)
	 */
	@Override
	public int openAccount(User user) {
		logger.info(">>>In open account Service");
		return accountManagerDAo.openAccount(user);
	}

	/*
	 * @see com.epam.bank.services.AccountManager#closeAccount(int)
	 */
	@Override
	public boolean closeAccount(int accountNumber) throws AccountNumberDoesnotExistException {
		logger.info(">>>In close account Service");
		return accountManagerDAo.closeAccount(accountNumber);
	}

	/*
	 * @see com.epam.bank.services.AccountManager#getAccountDetails(int)
	 */
	@Override
	public Account getAccountDetails(int accountNumber) throws AccountNumberDoesnotExistException {
		logger.info(">>>In get account details Service");
		return accountManagerDAo.getAccountDetails(accountNumber);
	}

}
