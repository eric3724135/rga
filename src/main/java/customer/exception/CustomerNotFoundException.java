package customer.exception;

public class CustomerNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
    private String paramName = null;

    public CustomerNotFoundException(String id) {
        paramName = id;
    }

    @Override
    public String getMessage() {
        return "Customer not existed : " + paramName;
    }

}
