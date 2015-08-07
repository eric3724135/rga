package customer.dao;

import java.util.List;

import customer.domain.Customer;

/**
 * Customer Dao ,u can implement with hibernate or mybatis
 * 
 * @author ERIC
 * 
 */
public interface CustomerDao {

	/**
	 * get all customer
	 * 
	 * @return List<Customer>
	 */
	List<Customer> getAllCustomer();

	/**
	 * get customer using PK like id or Email
	 * 
	 * @param Customer
	 *            customer
	 * @return Customer
	 */
	Customer getCustomer(String customerId) throws Exception;

	/**
	 * Create Customer
	 * 
	 * @param customer
	 *            Customer
	 */
	void createCustomer(Customer customer) throws Exception;

	/**
	 * delete Customer
	 * 
	 * @param customerId
	 *            customerId
	 */
	void deleteCustomer(String customerId) throws Exception;

	/**
	 * update Customer
	 * 
	 * @param customer
	 *            Customer
	 */
	void updateCustomer(String cusId, Customer customer) throws Exception;

}
