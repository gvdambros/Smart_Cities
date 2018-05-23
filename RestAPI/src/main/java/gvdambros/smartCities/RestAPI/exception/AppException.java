package gvdambros.smartCities.RestAPI.exception;

public class AppException extends Exception {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public AppException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
