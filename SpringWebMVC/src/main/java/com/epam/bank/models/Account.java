package com.epam.bank.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Contains Basic Information About Account.
 * 
 * @author Nishant_Bansal
 */
@Entity
@Table(name = "account_spring_bank")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int accountNumber;
	@Column
	private int accountBalance;
	@Column
	private boolean isActiveAccount;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}

	public void setActiveAccount(boolean isActiveAccount) {
		this.isActiveAccount = isActiveAccount;
	}

	public boolean isActiveAccount() {
		return isActiveAccount;
	}

	@Override
	public String toString() {
		return "Account Details-> " + accountNumber + " : " + accountBalance;
	}

}
