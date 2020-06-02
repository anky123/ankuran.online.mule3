package online.ankuran.api.exception;

/**
 * @Author : Ankur BHUYAN
 * @Website : https://ankuran.online/
 * 
 */
public class CustomValidationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1280966430516972261L;

	private final String error;
	
    public CustomValidationException(String error) {
        super(error);
        this.error = error;
    }
    public CustomValidationException(String message, Throwable cause, String error) {
        super(message, cause);
        this.error = error;
    }
    public CustomValidationException(String message, String error) {
        super(message);
        this.error = error;
    }
    public CustomValidationException(Throwable cause, String error) {
        super(cause);
        this.error = error;
    }
    public String  geterror() {
        return this.error;
    }
}
