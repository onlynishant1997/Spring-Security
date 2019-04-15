package com.epam.bank.dao;

import java.util.ArrayList;
import java.util.List;

import com.epam.bank.models.Account;
import com.epam.bank.models.User;

/**
 * The Class TestAccountManagerDaoImpl.
 *
 * @author Nishant
 */
public class MockAccountManagerDaoImpl {
	private List<Account> accountList;

	public MockAccountManagerDaoImpl() {
		accountList = new ArrayList<Account>();
	}

	/*
	 * Open Account
	 */

	public int openAccount(User user) {
		Account account = new Account();
		account.setActiveAccount(true);
		account.setAccountNumber(1);
		account.setAccountBalance(0);
		user.setAccount(account);
		accountList.add(account);
		return account.getAccountNumber();
	}

	/*
	 * Close Account
	 */
	public boolean closeAccount(int accountNumber) {
		for (Account account : accountList) {
			if (account.getAccountNumber() == accountNumber) {
				account.setActiveAccount(false);
			}
		}
		return true;
	}

	/*
	 * Get Account Details
	 */
	public Account getAccountDetails(int accNo) {
		Account accountDetails = null;
		for (Account account : accountList) {
			if (account.getAccountNumber() == accNo) {
				accountDetails = account;
			}
		}
		return accountDetails;
	}

}
