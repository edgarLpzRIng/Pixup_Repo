package mx.unam.dgscati.pixup.bo;

import java.util.List;

import mx.unam.dgscati.pixup.model.Domicilio;
import mx.unam.dgscati.pixup.model.Usuario;

public interface UsuarioBO {
	
	Usuario autenticarUsuario(Usuario usuario);
	Usuario registrarUsuario(Usuario usuario, List<Domicilio> domicilios);

}
