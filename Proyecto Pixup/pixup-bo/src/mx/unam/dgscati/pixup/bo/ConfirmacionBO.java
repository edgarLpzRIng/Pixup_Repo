package mx.unam.dgscati.pixup.bo;

import mx.unam.dgscati.pixup.exception.PixUpBOException;
import mx.unam.dgscati.pixup.model.Usuario;

public interface ConfirmacionBO {

	Usuario enviarConfirmacion(Usuario usuario) throws PixUpBOException;
	Usuario registrarConfirmacion(Usuario usuario) throws PixUpBOException;
	String asignarContraseniaTemporal(Usuario usuario) throws PixUpBOException;
	Usuario actualizarContrasenia(Usuario usuario) throws PixUpBOException;
	
}
