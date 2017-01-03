package mx.unam.dgscati.pixup.dao;

import java.util.List;

import mx.unam.dgscati.pixup.model.Colonia;

public interface ColoniaDAO {
	
	List<Colonia> obtieneColoniasPorCP(String codigoPostal);

}
