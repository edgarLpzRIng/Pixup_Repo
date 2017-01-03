package mx.unam.dgscati.pixup.dao;

import java.util.List;

import mx.unam.dgscati.pixup.dao.exception.PixupDAOException;
import mx.unam.dgscati.pixup.model.DisqueraVO;

public interface DisqueraDAO {
	
	DisqueraVO guardarDisquera(DisqueraVO disquera) throws PixupDAOException;
	DisqueraVO actualizaDisquera(DisqueraVO disquera) throws PixupDAOException;
	String bajaDisquera(Integer idDisquera) throws PixupDAOException;
	List<DisqueraVO> listarDisqueras() throws PixupDAOException;

}
