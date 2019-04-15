package com.epam.bank.dao;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.epam.bank.exceptions.AccountNotActiveException;
import com.epam.bank.exceptions.InSufficientAmountException;
import com.epam.bank.exceptions.InvalidAmountException;
import com.epam.bank.models.Account;
import com.epam.bank.utils.HibernateUtils;

/**
 * The Class TransactionDaoIMPL.
 *
 * @author Nishant_Bansal
 */
@Repository
public class TransactionDaoIMPL implements TransactionDAO {

	private Session session;

	private Transaction tr;

	private Logger logger;

	/**
	 * Instantiates a new transaction dao IMPL.
	 */
	public TransactionDaoIMPL() {
		logger = Logger.getLogger(TransactionDaoIMPL.class.getName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.epam.bank.dao.TransactionDAO#depositMoney(com.epam.bank.models.Account,
	 * int)
	 */
	public void depositMoney(Account account, int transactionAmount)
			throws InvalidAmountException, AccountNotActiveException {
		logger.info(">>>In deposit money");
		session = HibernateUtils.getSession();
		tr = session.getTransaction();
		if (!account.isActiveAccount())
			throw new AccountNotActiveException("Account not Active");
		if (transactionAmount < 0)
			throw new InvalidAmountException("Invalid Ammont");
		account.setAccountBalance(account.getAccountBalance() + transactionAmount);
		if (session != null) {
			try {
				tr = session.beginTransaction();
				session.update(account);
				tr.commit();
			} catch (Exception e) {
				tr.rollback();
				System.out.println("Money Not Deposited");
			}
		}
		session.close();
		logger.info("function ends deposit money");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.epam.bank.dao.TransactionDAO#withdrawMoney(com.epam.bank.models.Account,
	 * int)
	 */
	public void withdrawMoney(Account account, int transactionAmount)
			throws InvalidAmountException, InSufficientAmountException, AccountNotActiveException {
		logger.info(">>in Withdraw money");
		session = HibernateUtils.getSession();
		tr = session.getTransaction();
		if (!account.isActiveAccount())
			throw new AccountNotActiveException("Account not Active");
		if (transactionAmount < 0)
			throw new InvalidAmountException("Invalid ammount");
		int currentBalance = account.getAccountBalance();
		if (transactionAmount > currentBalance)
			throw new InSufficientAmountException("Insufficient Ammount");
		account.setAccountBalance(currentBalance - transactionAmount);
		if (session != null) {
			try {
				tr = session.beginTransaction();
				session.update(account);
				tr.commit();
			} catch (Exception e) {
				tr.rollback();
				System.out.println("Money Not WithDrawal");
			}
		}
		session.close();
		logger.info("function ends withdraw money");
	}

}
