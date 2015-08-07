package customer.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import customer.dao.CustomerDao;
import customer.domain.Customer;
import customer.exception.CustomerExistedException;
import customer.exception.CustomerNotFoundException;
import customer.utils.InitUtil;

@Service
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> getAllCustomer() {
		return InitUtil.getInitList();
	}

	@Override
	public Customer getCustomer(String customerId) throws Exception {
		List<Customer> list = InitUtil.getInitList();

		for (Customer cus : list) {
			if (StringUtils.equals(customerId, cus.getId())) {
				return cus;
			}
		}

		return null;
	}

	@Override
	public void createCustomer(Customer customer) throws CustomerExistedException {
		/* u need to check PK or some attribute need unique */
		for (Customer cus : InitUtil.getInitList()) {
			if (StringUtils.equals(customer.getId(), cus.getId())) {
				throw new CustomerExistedException(customer.getId());
			}
		}
		InitUtil.getInitList().add(customer);

	}

	@Override
	public void deleteCustomer(String customerId) {
		List<Customer> list = InitUtil.getInitList();

		for (Customer cus : list) {
			if (StringUtils.equals(customerId, cus.getId())) {
				list.remove(cus);
				break;
			}
		}

	}

	@Override
	public void updateCustomer(String cusId, Customer customer) {
		List<Customer> list = InitUtil.getInitList();

		for (Customer cus : list) {
			if (StringUtils.equals(cusId, cus.getId())) {
				// cus.setId(customer.getId());
				cus.setEmail(StringUtils.isNotBlank(customer.getEmail()) ? customer
						.getEmail() : cus.getEmail());
				cus.setName(StringUtils.isNotBlank(customer.getName()) ? customer
						.getName() : cus.getName());
				cus.setPassword(StringUtils.isNotBlank(customer.getPassword()) ? customer
						.getPassword() : cus.getPassword());

				return;
			}
		}
		throw new IllegalArgumentException();

	}

}
