package mx.unam.dgscati.pixup.dao.exception;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PixupDAOException extends Exception{
	
	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
	
	/**
	 * serializacion de la clase para transmision del contenido
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor de la clase PixupDAOException sin parametros.
	 */
	public PixupDAOException() {
		super();
	}

	/**
	 * Constructor de la clase PixupDAOException que recibe el error ocasionado.
	 * @param message Mensaje del error ocasionado.
	 */
	public PixupDAOException(String message) {
		super(message);		
		System.out.println("--> Ocurrió una PixupDAOException en el proyecto PixupDAO: " + dateFormat.format(new Date()) + " " + message);
	}

	/**
	 * Constructor de la clase PixupDAOException que recibe la causa del error enviado.
	 * @param cause Throwable con el error ocasionado
	 */
	public PixupDAOException(Throwable cause) {
		super(cause);
		System.out.println("--> Ocurrió una PixupDAOException en el proyecto PixupDAO: " + dateFormat.format(new Date()) + " " + cause.getMessage());
	}

	/**
	 * Constructor de la clase PixupDAOException que recibe el mensaje y el error ocasionado.
	 * @param message Mensaje del error
	 * @param cause Causa del error
	 */
	public PixupDAOException(String message, Throwable cause) {
		super(message, cause);
		System.out.println("--> Ocurrió una PixupDAOException en el proyecto PixupDAO: " + dateFormat.format(new Date()) + " " + message);
	}

	/**
	 * Constructor de la clase PixupDAOException
	 * @param message Mensaje del error
	 * @param cause Causa del error
	 * @param enableSuppression Booleano que indica si se activa la supresión de errores.
	 * @param writableStackTrace Booleano que indica si se escribirá el trazado de la pila hasta que ocurrió el error.
	 */
	public PixupDAOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		System.out.println("--> Ocurrió una PixupDAOException en el proyecto PixupDAO: " + dateFormat.format(new Date()) + " " + message);
	}

}