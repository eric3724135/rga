package customer.exception;

public class CustomerExistedException extends Exception {

	private static final long serialVersionUID = 1L;
	private String paramName = null;

	public CustomerExistedException(String id) {
		paramName = id;
	}

	@Override
	public String getMessage() {
		return "Customer is existed : " + paramName;
	}

}
