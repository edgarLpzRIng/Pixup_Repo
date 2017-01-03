package mx.unam.dgscati.pixup.bo.impl;

import mx.unam.dgscati.pixup.bo.RegistroBO;
import mx.unam.dgscati.pixup.exception.PixUpBOException;
import mx.unam.dgscati.pixup.model.Usuario;
import mx.unam.dgscati.pixup.wrapper.UsuarioWrapper;

public class RegistroBOImpl implements RegistroBO {

	@Override
	public UsuarioWrapper registrar(UsuarioWrapper usuario) throws PixUpBOException {
		//TODO realizar las operaciones de registro de usuario en base de datos:
		Usuario usuarioRegistrado = usuario.toUsuario();
		Double generacionIdentificador = Math.random() * Math.PI;		
		usuarioRegistrado.setIdentificador(generacionIdentificador.intValue());
		System.out.printf("Usuario registrado con identificador: %d%n", usuarioRegistrado.getIdentificador());
		return usuario;
	}

}
