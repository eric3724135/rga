package customer.service;

import java.util.List;

import customer.domain.Customer;
import customer.exception.CustomerExistedException;

public interface CustomerService {

	/**
	 * get all customer
	 * 
	 * @return List<Customer>
	 */
	List<Customer> getAllCustomer();

	/**
	 * get customer using PK
	 * 
	 * @param customerId
	 *            PK
	 * @return Customer
	 */
	Customer getCustomer(String customerId);

	/**
	 * Create Customer
	 * 
	 * @param customer
	 *            Customer
	 * @throws CustomerExistedException 
	 * @throws Exception 
	 */
	void createCustomer(Customer customer) throws Exception;

	/**
	 * delete Customer
	 * 
	 * @param customerId
	 *            customerId
	 */
	void deleteCustomer(String customerId);


	/**
	 * 
	 * update Customer
	 * 
	 * @param cusId
	 *            cusId
	 * @param customer
	 *            Customer
	 */
	void updateCustomer(String cusId, Customer customer);

}
