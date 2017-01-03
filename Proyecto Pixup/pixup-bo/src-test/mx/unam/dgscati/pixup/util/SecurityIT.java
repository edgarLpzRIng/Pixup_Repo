package mx.unam.dgscati.pixup.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class SecurityIT {

	@Test
	public void cifrarPasswordSuccess() {
		
		//Arrange
		String textoClaro = "diplomadojava";
		
		//Act
		String hash = Security.cifrarPassword(textoClaro);
		
		//Assert
		assertNotNull(hash);
		assertTrue(!hash.isEmpty());
		
	}

}
