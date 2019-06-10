package proyecto.negocio;

public class NegocioExcption extends Exception {


	private static final long serialVersionUID = 1L;

	public NegocioExcption() {
		
	}

	public NegocioExcption(String message) {
		super(message);
		
	}

	public NegocioExcption(Throwable cause) {
		super(cause);
	}

	public NegocioExcption(String message, Throwable cause) {
		super(message, cause);
	}

	public NegocioExcption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
