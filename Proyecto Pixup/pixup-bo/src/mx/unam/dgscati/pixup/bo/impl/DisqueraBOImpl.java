package mx.unam.dgscati.pixup.bo.impl;

import java.util.HashSet;
import java.util.Set;

import mx.unam.dgscati.pixup.bo.DisqueraBO;
import mx.unam.dgscati.pixup.dao.DisqueraDAO;
import mx.unam.dgscati.pixup.dao.exception.PixupDAOException;
import mx.unam.dgscati.pixup.dao.impl.DisqueraDAOImpl;
import mx.unam.dgscati.pixup.model.Catalogo;
import mx.unam.dgscati.pixup.model.DisqueraVO;

public class DisqueraBOImpl implements DisqueraBO {
	
	private DisqueraDAO disqueraDAO;

	@Override
	public DisqueraVO actualizarDisquera(DisqueraVO disquera) {
		disqueraDAO = new DisqueraDAOImpl();
		try {
			return disqueraDAO.actualizaDisquera(disquera);
		} catch (PixupDAOException e) {
			e.printStackTrace();
			System.out.println("Error al registrar la disquera: "+e.getMessage());
		}
		return null;
	}

	@Override
	public DisqueraVO registrarDisquera(DisqueraVO disquera) {
		disqueraDAO = new DisqueraDAOImpl();
		try {
			return disqueraDAO.guardarDisquera(disquera);
		} catch (PixupDAOException e) {
			e.printStackTrace();
			System.out.println("Error al actualizar la disquera: "+e.getMessage());
			return null;
		}
	}

	@Override
	public void borrarDisquera(DisqueraVO disquera) {
		disqueraDAO = new DisqueraDAOImpl();
		try {
			disqueraDAO.bajaDisquera(disquera.getIdDisquera());
		} catch (PixupDAOException e) {
			e.printStackTrace();
			System.out.println("Error al eiminar la disquera: "+e.getMessage());
		}
	}

	@Override
	public Set<DisqueraVO> obtenerDisqueras() {
		disqueraDAO = new DisqueraDAOImpl();
		try {
			Set<DisqueraVO> disqueras = new HashSet<>();
			disqueras.addAll(disqueraDAO.listarDisqueras());
			return disqueras;
		} catch (PixupDAOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
