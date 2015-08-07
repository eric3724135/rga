package customer.domain;

public class Customer extends User {

	public Customer() {
		super();
	}

	public Customer(String id, String name, String email, String password) {
		super();
		super.setId(id);
		super.setName(name);
		super.setEmail(email);
		super.setPassword(password);

	}

}
