package mx.unam.dgscati.pixup.bo.impl;

import java.util.ArrayList;
import java.util.List;

import mx.unam.dgscati.pixup.bo.UsuarioBO;
import mx.unam.dgscati.pixup.dao.UsuarioDAO;
import mx.unam.dgscati.pixup.dao.impl.UsuarioDAOImpl;
import mx.unam.dgscati.pixup.model.Domicilio;
import mx.unam.dgscati.pixup.model.TipoUsuario;
import mx.unam.dgscati.pixup.model.Usuario;
import mx.unam.dgscati.pixup.util.Security;

public class UsuarioBOImpl implements UsuarioBO {

	private UsuarioDAO usuarioDAO = null;
	
	public UsuarioBOImpl() {
		this.usuarioDAO =  new UsuarioDAOImpl();
	}
	
	@Override
	public Usuario autenticarUsuario(Usuario usuario) {
		usuario.setContrasenia(Security.cifrarPassword(usuario.getContrasenia()));
		return usuarioDAO.buscarUsuario(usuario);
	}

	@Override
	public Usuario registrarUsuario(Usuario usuario, List<Domicilio> domicilios) {
		usuarioDAO = new UsuarioDAOImpl();
		List<TipoUsuario> tiposUsuario = new ArrayList<>(1);
		TipoUsuario tipoUsuario = new TipoUsuario(2);
		tiposUsuario.add(tipoUsuario);
		return usuarioDAO.guardarUsuario(usuario, domicilios, tiposUsuario);
	}

}
