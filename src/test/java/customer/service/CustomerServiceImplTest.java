package customer.service;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import customer.dao.CustomerDao;
import customer.domain.Customer;
import customer.exception.CustomerExistedException;
import customer.service.impl.CustomerServiceImpl;
import customer.utils.InitUtil;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceImplTest {
	@Mock
	private CustomerDao customerDao;
	@InjectMocks
	private CustomerService customerService = new CustomerServiceImpl();

	@Before
	public void setUp() throws Exception {
		Customer cus = new Customer();
		Mockito.when(customerDao.getAllCustomer()).thenReturn(
				InitUtil.getInitList());
		Mockito.when(customerDao.getCustomer("1")).thenReturn(
				InitUtil.getInitList().get(0));
	}

	@Test
	public void testGetAllCustomer() {
		Assert.assertEquals(customerService.getAllCustomer(),
				InitUtil.getInitList());

	}

	@Test
	public void testGetCustomer() {
		Assert.assertEquals(customerService.getCustomer("1"), InitUtil
				.getInitList().get(0));

	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetCustomerEx() throws Exception {
		Mockito.when(customerDao.getCustomer("2")).thenThrow(
				new IllegalArgumentException());
		customerService.getCustomer("2");
	}

	@Test
	public void testCreateCustomer() throws Exception {

		customerService
				.createCustomer(new Customer("9", "test", "test", "test"));

	}

	@Test
	public void testDeleteCustomer() {
		customerService.deleteCustomer("1");
	}


	@Test
	public void testUpdateCustomer() {
		customerService.updateCustomer("9", new Customer("9", "test", "test",
				"test"));
	}

}
