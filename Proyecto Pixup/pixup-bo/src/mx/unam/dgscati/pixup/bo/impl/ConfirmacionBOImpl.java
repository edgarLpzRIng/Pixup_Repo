package mx.unam.dgscati.pixup.bo.impl;

import java.util.Calendar;

import mx.unam.dgscati.pixup.bo.ConfirmacionBO;
import mx.unam.dgscati.pixup.exception.PixUpBOException;
import mx.unam.dgscati.pixup.exception.PixUpSeguridadException;
import mx.unam.dgscati.pixup.model.Usuario;
import mx.unam.dgscati.pixup.util.Seguridad;

public class ConfirmacionBOImpl implements ConfirmacionBO {

	@Override
	public Usuario enviarConfirmacion(Usuario usuario) throws PixUpBOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario registrarConfirmacion(Usuario usuario) throws PixUpBOException {
		// TODO se hace el registro de la confirmación en la base de datos y se anula el token de confirmación
		System.out.println("Se ha anulado el token para el usuario ".concat(String.valueOf( usuario.getIdentificador())));
		return usuario;
	}

	@Override
	public String asignarContraseniaTemporal(Usuario usuario) throws PixUpBOException {
		// TODO se genera una contraseña tempora y se almacena en la base de datos		
		String aCifrar;
		Long tiempo = Calendar.getInstance().getTimeInMillis();
		tiempo = tiempo*21;
		try {
			aCifrar = Seguridad.toMD5(String.valueOf(tiempo).concat("PixUp"));
		} catch (PixUpSeguridadException e) {
			throw new PixUpBOException("No se ha logrado cifrar la contraseña temporal. ".concat(e.getMessage()), e);
		}
		System.out.println("Se almacena la contraseña temporal para el usuario ".concat(String.valueOf( usuario.getIdentificador())));
		return aCifrar;
	}

	@Override
	public Usuario actualizarContrasenia(Usuario usuario) throws PixUpBOException {
		// TODO se hace la actualización de la contraseña en la base de datos
		System.out.println("Se ha actualizado la contraseña para el usuario ".concat(String.valueOf( usuario.getIdentificador())));
		return usuario;
	}

}
