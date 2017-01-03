package mx.unam.dgscati.pixup.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PixUpSeguridadException extends RuntimeException {

	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");

	/**
	 * serializacion de la clase para transmision del contenido
	 */
	private static final long serialVersionUID = 1L;
	
	public PixUpSeguridadException() {
		super();
	}

	public PixUpSeguridadException(String message) {
		super(message);		
		System.out.printf("--> %s Ha ocurrido una SeguridadException en el proyecto PixUp: %s%n", dateFormat.format(new Date()),message);
	}

	public PixUpSeguridadException(Throwable cause) {
		super(cause);
		System.out.printf("--> %s Ha ocurrido una SeguridadException en el proyecto PixUp: %s%n", dateFormat.format(new Date()), cause.getMessage());
	}

	public PixUpSeguridadException(String message, Throwable cause) {
		super(message, cause);
		System.out.printf("--> %s Ha ocurrido una SeguridadException en el proyecto PixUp: %s%n", dateFormat.format(new Date()),message);

	}

	public PixUpSeguridadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		System.out.printf("--> %s Ha ocurrido una SeguridadException en el proyecto PixUp: %s%n", dateFormat.format(new Date()),message);
	}

}
