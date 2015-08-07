package customer.domain;

public class State {

	private String state;

	private String info;

	private String email;
	
	

	public State() {
		super();
	}

	public State(String state, String info, String email) {
		super();
		this.state = state;
		this.info = info;
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
