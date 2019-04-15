package com.learning.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Nishant
 *
 */
@Controller
public class LoginController {
	
	/**
	 * Show my login page.
	 *
	 * @return the string
	 */
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		return "plain-login";
	}
}
