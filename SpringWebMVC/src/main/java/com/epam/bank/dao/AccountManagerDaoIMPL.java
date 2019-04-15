package com.epam.bank.dao;

import com.epam.bank.exceptions.AccountNumberDoesnotExistException;
import com.epam.bank.models.Account;
import com.epam.bank.models.User;
import com.epam.bank.utils.HibernateUtils;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

/**
 * The Class AccountManagerDaoIMPL.
 *
 * @author Nishant_Bansal
 */
@Repository
public class AccountManagerDaoIMPL implements AccountManagerDAO {

	private Logger logger;

	private Session session;

	private Transaction tr;

	/**
	 * Instantiates a new account manager dao IMPL.
	 */
	public AccountManagerDaoIMPL() {
		logger = Logger.getLogger(AccountManagerDaoIMPL.class.getName());
	}

	/*
	 * @see
	 * com.epam.bank.dao.AccountManagerDAO#openAccount(com.epam.bank.models.User)
	 */
	public int openAccount(User user) {
		logger.info(">>>>In method Open Account...!!");
		session = HibernateUtils.getSession();
		tr = session.getTransaction();
		Account account = new Account();
		account.setAccountBalance(0);
		account.setActiveAccount(true);
		user.setAccount(account);
		if (session != null) {
			try {
				tr = session.beginTransaction();
				session.save(user);
				tr.commit();
			} catch (Exception e) {
				tr.rollback();
				System.out.println("User not Created");
			}
		}
		session.close();
		logger.info("Returning from the method open account");
		return account.getAccountNumber();
	}

	/*
	 * @see com.epam.bank.dao.AccountManagerDAO#closeAccount(int)
	 */
	public boolean closeAccount(int accountNumber) throws AccountNumberDoesnotExistException {
		session = HibernateUtils.getSession();
		tr = session.getTransaction();
		logger.info(">>>In method Close account");
		boolean isClosed = true;
		if (session != null) {
			tr = session.beginTransaction();
			Account userAccount = (Account) session.get(Account.class, accountNumber);
			if (userAccount == null) {
				throw new AccountNumberDoesnotExistException("No account number found");
			}
			userAccount.setActiveAccount(false);
			session.update(userAccount);
			tr.commit();
		}
		session.close();
		logger.info(">>>Returning from method Close Account");
		return isClosed;
	}

	/*
	 * @see com.epam.bank.dao.AccountManagerDAO#getAccountDetails(int)
	 */
	public Account getAccountDetails(int accountNumber) throws AccountNumberDoesnotExistException {
		logger.info("In method get account details");
		session = HibernateUtils.getSession();
		tr = session.getTransaction();
		Account account = null;
		if (session != null) {
			try {
				tr = session.beginTransaction();
				account = (Account) session.get(Account.class, accountNumber);
				tr.commit();
			} catch (Exception e) {
				tr.rollback();
				System.out.println("Fetching Account Details Error");
			}
		}
		if (account == null) {
			throw new AccountNumberDoesnotExistException("No account number found");
		}
		session.close();
		logger.info("returning from the get account details");
		return account;
	}

}
