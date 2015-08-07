package customer.service.impl;

import java.util.List;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import customer.dao.CustomerDao;
import customer.dao.impl.CustomerDaoImpl;
import customer.domain.Customer;
import customer.exception.CustomerExistedException;
import customer.service.CustomerService;

/**
 * Service of Customer , business logic in here
 * 
 * @author ERIC
 * 
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	@Override
	@Transactional(readOnly = true)
	public List<Customer> getAllCustomer() {

		return customerDao.getAllCustomer();
	}

	@Override
	@Transactional(readOnly = true)
	public Customer getCustomer(String customerId) {

		try {
			return customerDao.getCustomer(customerId);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Can not find this customer. The customer id " + customerId
							+ " does not exist");
		}
	}

	@Override
	@Transactional
	public void createCustomer(Customer customer)
			throws Exception {

		customerDao.createCustomer(customer);

	}

	@Override
	@Transactional
	public void deleteCustomer(String customerId) {
		try {
			customerDao.deleteCustomer(customerId);
		} catch (Exception e) {
			throw new IllegalArgumentException(
					"Can not delete this customer. Exception info:"
							+ e.getMessage());
		}
	}

	@Override
	@Transactional
	public void updateCustomer(String cusId, Customer customer) {
		try {
			customerDao.updateCustomer(cusId, customer);
		} catch (Exception e) {
			System.out.println(ExceptionUtils.getStackTrace(e));
			throw new IllegalArgumentException(e.getMessage());
		}

	}

}
