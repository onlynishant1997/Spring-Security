package com.epam.bank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.epam.bank.dao.AccountManagerDaoIMPL;
import com.epam.bank.enums.Gender;
import com.epam.bank.exceptions.AccountNumberDoesnotExistException;
import com.epam.bank.models.Account;
import com.epam.bank.models.User;
import com.epam.bank.services.AccountManagerIMPL;

/**
 * The Class AccountManagerIMPLTest.
 *
 * @author Nishant
 */
@RunWith(JUnitPlatform.class)
public class AccountManagerIMPLTest {

	/** The account manager dao IMPL. */
	@Mock
	private AccountManagerDaoIMPL accountManagerDaoIMPL;

	/** The account manager IMPL. */
	@InjectMocks
	private AccountManagerIMPL accountManagerIMPL;

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Open account.
	 */
	@Test
	@DisplayName("Test open account function")
	public void testOpenAccount() {
		User user = new User();
		user.setName("Nishant");
		user.setGender(Gender.MALE);
		Account account = new Account();
		account.setAccountBalance(1);
		user.setAccount(account);
		when(accountManagerDaoIMPL.openAccount(any(User.class))).thenReturn(user.getAccount().getAccountNumber());
		int accNo = accountManagerIMPL.openAccount(null);
		assertEquals(account.getAccountNumber(), accNo);
	}

	/**
	 * Close account.
	 *
	 * @throws AccountNumberDoesnotExistException the account number doesnot exist
	 *                                            exception
	 */
	@Test
	@DisplayName("Test close account function")
	public void testCloseAccount() throws AccountNumberDoesnotExistException {
		User user = new User();
		user.setName("Nishant");
		user.setGender(Gender.MALE);
		Account account = new Account();
		account.setAccountBalance(1);
		account.setAccountNumber(1);
		user.setAccount(account);
		account.setActiveAccount(false);
		try {
			when(accountManagerDaoIMPL.closeAccount(any(Integer.class))).thenReturn(false);
		} catch (AccountNumberDoesnotExistException e) {
			e.printStackTrace();
		}
		boolean closeAccountStatus = accountManagerIMPL.closeAccount(1);
		assertEquals(false, closeAccountStatus);
	}

	/**
	 * Gets the account details.
	 *
	 * @return the account details
	 * @throws AccountNumberDoesnotExistException the account number doesnot exist
	 *                                            exception
	 */
	@Test
	@DisplayName("Test get account details function")
	public void testGetAccountDetails() throws AccountNumberDoesnotExistException {
		User user = new User();
		user.setName("Nishant");
		user.setGender(Gender.MALE);
		Account account = new Account();
		account.setAccountBalance(1);
		user.setAccount(account);
		when(accountManagerDaoIMPL.getAccountDetails(any(Integer.class))).thenReturn(account);
		Account testAccountDetails = accountManagerIMPL.getAccountDetails(1);
		assertEquals(account, testAccountDetails);

	}

}
