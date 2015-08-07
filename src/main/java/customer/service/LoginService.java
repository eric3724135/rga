package customer.service;

import customer.domain.AdminUser;

public interface LoginService {

	public boolean login(AdminUser user);

	public boolean logout();

}
