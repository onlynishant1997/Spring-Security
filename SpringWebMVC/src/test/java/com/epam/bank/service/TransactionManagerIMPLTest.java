package com.epam.bank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyInt;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.epam.bank.dao.AccountManagerDaoIMPL;
import com.epam.bank.dao.TransactionDaoIMPL;
import com.epam.bank.enums.Gender;
import com.epam.bank.exceptions.AccountNotActiveException;
import com.epam.bank.exceptions.AccountNumberDoesnotExistException;
import com.epam.bank.exceptions.InvalidAmountException;
import com.epam.bank.models.Account;
import com.epam.bank.models.User;
import com.epam.bank.services.AccountManagerIMPL;
import com.epam.bank.services.TransactionMangerIMPL;

/**
 * The Class TransactionManagerIMPLTest.
 *
 * @author Nishant
 */
@RunWith(JUnitPlatform.class)

public class TransactionManagerIMPLTest {

	@Mock
	private TransactionDaoIMPL transactionDaoImpl;

	@InjectMocks
	private TransactionMangerIMPL transactionManagerImpl;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test Deposit Money")
	public void depositMoney() throws InvalidAmountException, AccountNotActiveException {

	}
}
