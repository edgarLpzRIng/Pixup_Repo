package mx.unam.dgscati.pixup.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import mx.unam.dgscati.pixup.model.Colonia;

public class ColoniaDAOImplTest {

	@Test
	public void test() {
		ColoniaDAOImpl cDAO = new ColoniaDAOImpl();
		List<Colonia> colonias = cDAO.obtieneColoniasPorCP("06400");
		for(Colonia colonia : colonias){
			System.out.println("Colonia: "+colonia);
		}
		assertNotNull(colonias);
		assertTrue(!colonias.isEmpty());
	}

}
