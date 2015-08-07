package customer.domain;

public class AdminUser extends User {

	private boolean isEffective;

	private String token;

	public AdminUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminUser(String id, String name, String email, String password,
			boolean isEffective) {
		super(id, name, email, password);
		this.isEffective = isEffective;
	}

	public boolean isEffective() {
		return isEffective;
	}

	public void setEffective(boolean isEffective) {
		this.isEffective = isEffective;
	}
	
	

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AdminUser other = (AdminUser) obj;
		if (super.getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!super.getId().equals(other.getId()))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((super.getId() == null) ? 0 : super.getId().hashCode());

		return result;
	}

}
