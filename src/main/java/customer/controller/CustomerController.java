package customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import customer.domain.AdminUser;
import customer.domain.Customer;
import customer.domain.State;
import customer.exception.CustomerExistedException;
import customer.service.CustomerService;
import customer.service.LoginService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	/**
	 * logger
	 */
	Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	private CustomerService customerService;

	/**
	 * getList
	 * 
	 * @return List<Customer>
	 */
	@RequestMapping("/list")
	public List<Customer> getCustomerList(HttpServletRequest request,
			HttpServletResponse response) {

		if (!StringUtils.isNotBlank((String) request.getSession().getAttribute(
				"token"))) {
			try {
				response.sendRedirect("/rga-customer/withoutLogin");
				return null;
			} catch (IOException e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}

		List<Customer> list = customerService.getAllCustomer();
		return list;
	}

	/**
	 * get customer by id
	 * 
	 * @param cusId
	 *            id
	 * @return Customer
	 */
	@RequestMapping(value = "/{cusId}", method = RequestMethod.GET)
	public Customer getCustomer(@PathVariable(value = "cusId") String cusId,
			HttpServletRequest request, HttpServletResponse response) {
		if (!StringUtils.isNotBlank((String) request.getSession().getAttribute(
				"token"))) {
			try {
				response.sendRedirect("/rga-customer/withoutLogin");
				return null;
			} catch (IOException e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}
		return customerService.getCustomer(cusId);
	}

	/**
	 * create customer
	 * 
	 * @param customer
	 *            customer
	 * @return customer
	 * @throws CustomerExistedException 
	 */
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody
	Customer create(@RequestBody Customer customer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		if (!StringUtils.isNotBlank((String) request.getSession().getAttribute(
				"token"))) {
			try {
				response.sendRedirect("/rga-customer/withoutLogin");
				return null;
			} catch (IOException e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}
		customerService.createCustomer(customer);
		return customer;
	}

	/**
	 * upadte Customer by id
	 * 
	 * @param cusId
	 *            CustomerId
	 */
	@RequestMapping(value = "/{cusId}", method = RequestMethod.PUT)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void update(@PathVariable(value = "cusId") String cusId,
			@RequestBody Customer customer, HttpServletRequest request,
			HttpServletResponse response) {
		if (!StringUtils.isNotBlank((String) request.getSession().getAttribute(
				"token"))) {
			try {
				response.sendRedirect("/rga-customer/withoutLogin");
				return;
			} catch (IOException e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}
		customerService.updateCustomer(cusId, customer);
	}

	/**
	 * delete Customer by id
	 * 
	 * @param cusId
	 *            CustomerId
	 */
	@RequestMapping(value = "/{cusId}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "cusId") String cusId,
			HttpServletRequest request, HttpServletResponse response) {
		if (!StringUtils.isNotBlank((String) request.getSession().getAttribute(
				"token"))) {
			try {
				response.sendRedirect("/rga-customer/withoutLogin");
				return;
			} catch (IOException e) {
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}

		customerService.deleteCustomer(cusId);
	}

	@ExceptionHandler(CustomerExistedException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Customer Id existed,please check your id")
	public void handleExistedErrors(Exception ex) {
		logger.error(ExceptionUtils.getStackTrace(ex));
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
	public void handleClientErrors(Exception ex) {
		logger.error(ExceptionUtils.getStackTrace(ex));
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
	public void handleServerErrors(Exception ex) {
		logger.error(ExceptionUtils.getStackTrace(ex));
	}

}
