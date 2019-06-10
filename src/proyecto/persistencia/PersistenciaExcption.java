package proyecto.persistencia;

public class PersistenciaExcption extends Exception {


	private static final long serialVersionUID = 1L;

	public PersistenciaExcption() {
	
	}

	public PersistenciaExcption(String message) {
		super(message);
		
	}

	public PersistenciaExcption(Throwable cause) {
		super(cause);
	
	}

	public PersistenciaExcption(String message, Throwable cause) {
		super(message, cause);
		
	}

	public PersistenciaExcption(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

}
