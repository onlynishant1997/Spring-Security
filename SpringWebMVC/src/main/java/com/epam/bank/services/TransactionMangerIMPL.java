package com.epam.bank.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.bank.dao.TransactionDAO;
import com.epam.bank.exceptions.AccountNotActiveException;
import com.epam.bank.exceptions.InSufficientAmountException;
import com.epam.bank.exceptions.InvalidAmountException;
import com.epam.bank.models.Account;

/**
 * The Class TransactionIMangerMPL.
 *
 * @author Nishant_Bansal
 */
@Service
public class TransactionMangerIMPL implements TransactionManager {

	@Autowired
	private TransactionDAO transactionDAO;

	private Logger logger;

	public TransactionMangerIMPL() {
		logger = Logger.getLogger(TransactionMangerIMPL.class.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.epam.bank.services.TransactionManager#depositMoney(com.epam.bank.models.
	 * Account, int)
	 */
	public void depositMoney(Account account, int transactionAmount)
			throws InvalidAmountException, AccountNotActiveException {
		logger.info("In deposit money service");
		if (transactionDAO != null)
			transactionDAO.depositMoney(account, transactionAmount);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.epam.bank.services.TransactionManager#withdrawMoney(com.epam.bank.models.
	 * Account, int)
	 */
	public void withdrawMoney(Account account, int transactionAmount)
			throws InvalidAmountException, InSufficientAmountException, AccountNotActiveException {
		logger.info("in withdraw money service");
		if (transactionDAO != null)
			transactionDAO.withdrawMoney(account, transactionAmount);
	}

}
