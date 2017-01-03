package mx.unam.dgscati.pixup.bo;

import java.util.List;

import mx.unam.dgscati.pixup.model.Colonia;

public interface ColoniaBO {
	
	List<Colonia> obtenerColoniaPorCP(String cp);

}
