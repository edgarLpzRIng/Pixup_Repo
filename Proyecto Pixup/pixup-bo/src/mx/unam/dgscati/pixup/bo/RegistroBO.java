package mx.unam.dgscati.pixup.bo;

import mx.unam.dgscati.pixup.exception.PixUpBOException;
import mx.unam.dgscati.pixup.wrapper.UsuarioWrapper;

public interface RegistroBO {
	UsuarioWrapper registrar(UsuarioWrapper usuario) throws PixUpBOException;
	
}
