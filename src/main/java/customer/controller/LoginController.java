package customer.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import customer.domain.AdminUser;
import customer.domain.State;
import customer.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody
	State login(@RequestBody AdminUser user, HttpServletRequest request) {
		State state;
		// already get token
		if (StringUtils.isNotBlank((String) request.getSession().getAttribute(
				"token"))) {

			state = new State("200", "already login", user.getEmail());
			return state;
		}
		// check login
		if (loginService.login(user)) {
			request.getSession().setAttribute("token",user.getId());
			state = new State("200", "success login", user.getEmail());

		} else {
			state = new State("404", "failed login", user.getEmail());
		}
		return state;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public @ResponseBody
	State logout(HttpServletRequest request) {
		State state;
		// exist token
		if (StringUtils.isNotBlank((String) request.getSession().getAttribute(
				"token"))) {

			request.getSession().removeAttribute("token");
			state = new State("200", "success logout", null);

		} else {
			state = new State("401", "invild logout", null);
		}
		return state;
	}

	@RequestMapping(value = "/withoutLogin")
	public @ResponseBody
	State withoutLogin(HttpServletRequest request) {
		State state = new State("404",
				"Please Login before access customer service", null);

		return state;
	}
}
