package customer.utils;

import java.util.ArrayList;
import java.util.List;

import customer.domain.AdminUser;
import customer.domain.Customer;

public class InitUtil {

	private static List<Customer> initList;

	private static List<AdminUser> adminList;

	static {
		initList = new ArrayList<>();
		initList.add(new Customer("1", "Customer1", "Customer1@google.com",
				"Customer1"));
		initList.add(new Customer("2", "Customer2", "Customer2@google.com",
				"Customer2"));
		initList.add(new Customer("3", "Customer3", "Customer3@google.com",
				"Customer3"));
		initList.add(new Customer("4", "Customer4", "Customer4@google.com",
				"Customer4"));
		initList.add(new Customer("5", "Customer5", "Customer5@google.com",
				"Customer5"));
		adminList = new ArrayList<>();
		AdminUser user = new AdminUser("99", "admin", "admin@google.com",
				"admin", true);
		user.setToken("token");
		adminList.add(user);

	}

	public static List<Customer> getInitList() {
		return initList;
	}

	public static void setInitList(List<Customer> initList) {
		InitUtil.initList = initList;
	}

	public static List<AdminUser> getAdminList() {
		return adminList;
	}

	public static void setAdminList(List<AdminUser> adminList) {
		InitUtil.adminList = adminList;
	}

}
