package com.learning.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * The Class HelloController.
 *
 * @author Nishant
 */
@Controller
public class HelloController {
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
}
