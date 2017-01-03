package mx.unam.dgscati.pixup.bo.impl;

import java.util.List;

import mx.unam.dgscati.pixup.bo.ColoniaBO;
import mx.unam.dgscati.pixup.dao.ColoniaDAO;
import mx.unam.dgscati.pixup.dao.impl.ColoniaDAOImpl;
import mx.unam.dgscati.pixup.model.Colonia;

public class ColoniaBOImpl implements ColoniaBO {
	
	ColoniaDAO coloniaDAO;
	
	public ColoniaBOImpl() {
		this.coloniaDAO = new ColoniaDAOImpl();
	}

	@Override
	public List<Colonia> obtenerColoniaPorCP(String cp) {
		return coloniaDAO.obtieneColoniasPorCP(cp);
	}

}
