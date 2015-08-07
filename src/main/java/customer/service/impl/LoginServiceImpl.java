package customer.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import customer.domain.AdminUser;
import customer.service.LoginService;
import customer.utils.InitUtil;

@Service
public class LoginServiceImpl implements LoginService {

	@Override
	public boolean login(AdminUser user) {
		for (AdminUser userA : InitUtil.getAdminList()) {
			if (StringUtils.equals(user.getId(), userA.getId())
					&& StringUtils.equals(user.getPassword(),
							userA.getPassword())) {
				
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean logout() {
		// TODO Auto-generated method stub
		return false;
	}

}
