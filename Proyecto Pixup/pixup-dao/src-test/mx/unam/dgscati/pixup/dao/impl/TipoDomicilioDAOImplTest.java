package mx.unam.dgscati.pixup.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import mx.unam.dgscati.pixup.dao.TipoDomicilioDAO;
import mx.unam.dgscati.pixup.model.Catalogo;

public class TipoDomicilioDAOImplTest {

	@Test
	public void testMain() {
		TipoDomicilioDAO tipoDom = new TipoDomicilioDAOImpl();
		List<Catalogo> ltCatalogos = tipoDom.encuentraTodos();
		for(Catalogo catalogo : ltCatalogos){
			System.out.println("Catalogo: "+catalogo.getDescripcion());
		}
		assertNotNull(ltCatalogos);
		assertTrue(!ltCatalogos.isEmpty());
	}

}
