package mx.unam.dgscati.pixup.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import mx.unam.dgscati.pixup.dao.PreguntaSecretaDAO;
import mx.unam.dgscati.pixup.model.Catalogo;

public class PreguntaSecretaDAOImplIT {

	@Test
	public void testEncuentraTodos() {
		PreguntaSecretaDAO ps = new PreguntaSecretaDAOImpl();
		List<Catalogo> catalogos = ps.encuentraTodos();
		for (Catalogo catalogo : catalogos) {
			System.out.println("Catalogo: " + catalogo);
		}
		assertNotNull(catalogos);
		assertTrue(!catalogos.isEmpty());
	}

}
