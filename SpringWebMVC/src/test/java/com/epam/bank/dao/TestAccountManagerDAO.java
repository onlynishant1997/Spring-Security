package com.epam.bank.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import com.epam.bank.enums.Gender;
import com.epam.bank.models.Account;
import com.epam.bank.models.User;

/**
 * The Class TestAccountManagerDAO.
 *
 * @author Nishant
 */
public class TestAccountManagerDAO {
	private MockAccountManagerDaoImpl testAccountManagerDaoImpl;

	/**
	 * Test open account.
	 */
	@DisplayName("Test Open Account")
	@Test
	public void testOpenAccount() {
		testAccountManagerDaoImpl = new MockAccountManagerDaoImpl();
		User user = new User();
		user.setName("Nishant");
		user.setGender(Gender.MALE);
		assertEquals(testAccountManagerDaoImpl.openAccount(user), 1);
	}

	/**
	 * Test close account.
	 */
	@DisplayName("Test Account Number")
	@Test
	public void testCloseAccount() {
		testAccountManagerDaoImpl = new MockAccountManagerDaoImpl();
		int accountNumber = 123456;
		assertEquals(testAccountManagerDaoImpl.closeAccount(accountNumber), true);
	}

	/*
	 * Get Account Details
	 */
	@Test
	@DisplayName("Testing account details")
	public void testGetAccountDetails() {
		testAccountManagerDaoImpl = new MockAccountManagerDaoImpl();
		User user = new User();
		user.setName("Nishant");
		user.setGender(Gender.MALE);
		assertEquals(testAccountManagerDaoImpl.openAccount(user), 1);
		Account account = new Account();
		account.setAccountBalance(0);
		account.setAccountNumber(1);
		assertEquals(account.getAccountNumber(), testAccountManagerDaoImpl.getAccountDetails(1).getAccountNumber());
	}

}
