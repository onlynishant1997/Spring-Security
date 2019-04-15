package com.epam.bank.controllers;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.epam.bank.services.AccountManagerIMPL;
import com.epam.bank.servlets.AccountDetails;

@RunWith(MockitoJUnitRunner.class)
public class TestAccountDetails {
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private AccountManagerIMPL accountManagerIMPL;
	
	@InjectMocks
	private AccountDetails accountDetails;
}
