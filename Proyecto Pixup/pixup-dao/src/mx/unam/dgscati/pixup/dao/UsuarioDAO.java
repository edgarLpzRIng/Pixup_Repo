package mx.unam.dgscati.pixup.dao;

import java.util.List;

import mx.unam.dgscati.pixup.model.Domicilio;
import mx.unam.dgscati.pixup.model.TipoUsuario;
import mx.unam.dgscati.pixup.model.Usuario;

public interface UsuarioDAO {
	
	Usuario guardarUsuario(Usuario usuario, List<Domicilio> domicilios, List<TipoUsuario> tiposUsuario);
	Usuario buscarUsuario(Usuario usuario);

}
