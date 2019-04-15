package com.epam.bank.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Login Servlet Controller.
 * 
 * @author Nishant_Bansal
 */
@Controller
public class LoginServlet {

	private Logger logger = Logger.getLogger(LoginServlet.class.getName());

	/**
	 * Login.
	 *
	 * @param model    the model
	 * @param username the username
	 * @param password the password
	 * @return the string
	 */
	@PostMapping("/LoginServlet")
	public String login(Model model, HttpServletRequest request, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		logger.info("in login controller");
		String pageName = null;
		HttpSession session = request.getSession();
		if (session != null) {
			if (username.equals("admin") && password.equals("admin")) {
				model.addAttribute("user", username);
				session.setAttribute("user", "admin");
				pageName = "dashboard";
			} else {
				model.addAttribute("ERROR", "Invalid Login");
				pageName = "loginform";
			}
		}
		logger.info("at end of login controller");
		return pageName;
	}

}
