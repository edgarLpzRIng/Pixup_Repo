package mx.unam.dgscati.pixup.bo;

import java.util.Set;

import mx.unam.dgscati.pixup.model.DisqueraVO;

public interface DisqueraBO {
	
	DisqueraVO actualizarDisquera(DisqueraVO disquera);
	DisqueraVO registrarDisquera(DisqueraVO disquera);
	void borrarDisquera(DisqueraVO disquera);
	Set<DisqueraVO> obtenerDisqueras();

}
