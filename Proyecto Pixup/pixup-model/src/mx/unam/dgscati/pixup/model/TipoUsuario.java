package mx.unam.dgscati.pixup.model;

import java.util.ArrayList;
import java.util.List;

public class TipoUsuario extends Catalogo {

	private List<Catalogo> lista;
	
	public TipoUsuario(Integer id) {
		identificador = id;
	}

	public TipoUsuario() {
		super();
		lista = new ArrayList<>();
		lista.add(new Catalogo(1, "Usuario Web"));
		lista.add(new Catalogo(2, "Usuario Administrador"));
		lista.add(new Catalogo(3, "Usuario Local"));
	}

	public List<Catalogo> listar(){
		return lista;
	}
	
	public Catalogo buscarPorId(int id){
		// TODO falta realizar la implementación de las excepciones DAO para solucionar cuando no existe el elemento
		return lista.get(id);
	}
	
}
