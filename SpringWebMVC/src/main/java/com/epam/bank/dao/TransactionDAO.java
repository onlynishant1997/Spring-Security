package com.epam.bank.dao;

import com.epam.bank.exceptions.AccountNotActiveException;
import com.epam.bank.exceptions.InSufficientAmountException;
import com.epam.bank.exceptions.InvalidAmountException;
import com.epam.bank.models.Account;

/**
 * Interface TransactionDao for Transactions
 * 
 * @author Nishant_Bansal
 */
public interface TransactionDAO {

	/**
	 * Deposit money.
	 *
	 * @param account           the account
	 * @param transactionAmount the transaction amount
	 * @return true if successful
	 */
	public void depositMoney(Account account, int transactionAmount)
			throws InvalidAmountException, AccountNotActiveException;

	/**
	 * Withdraw money.
	 *
	 * @param account           the account
	 * @param transactionAmount the transaction amount
	 * @return true, if successful
	 */
	public void withdrawMoney(Account account, int transactionAmount)
			throws InvalidAmountException, InSufficientAmountException, AccountNotActiveException;
}
