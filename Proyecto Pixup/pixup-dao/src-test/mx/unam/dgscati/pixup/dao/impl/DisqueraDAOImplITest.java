package mx.unam.dgscati.pixup.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.Test;

import mx.unam.dgscati.pixup.dao.DisqueraDAO;
import mx.unam.dgscati.pixup.dao.exception.PixupDAOException;
import mx.unam.dgscati.pixup.model.DisqueraVO;

public class DisqueraDAOImplITest {

	@Test
	public void test() {
		
		try {
			DisqueraDAO disqueraDAO = new DisqueraDAOImpl();
			DisqueraVO disquera = new DisqueraVO();
			System.out.println("************** .:: PRUEBA DE ALTAS BAJAS Y CAMBIOS ::. **************");
			System.out.println("Ingresa el nombre de la disquera");
			String nombreDisquera = entradaTeclado();
			System.out.println("Guardando una disquera con nombre "+nombreDisquera);
			disquera.setNombreDisquera(nombreDisquera);
			disqueraDAO.guardarDisquera(disquera);
			System.out.println("Se registró la disquera exitosamente. "+disquera);
			System.out.println("Desea modificar el nombre de la disquera? S=SI, N=NO");
			String respuesta = entradaTeclado();
			if(respuesta.toUpperCase().equals("S")){
				System.out.println("Ingresa el nuevo nombre de la disquera");
				respuesta = entradaTeclado();
				disquera.setNombreDisquera(respuesta);
				disqueraDAO.actualizaDisquera(disquera);
				System.out.println("La disquera se actulizó correctamente. "+disquera);
			}
			System.out.println("Desea eliminar la disquera registrada? S=SI, N=NO");
			respuesta = entradaTeclado();
			if(respuesta.toUpperCase().equals("S")){
				respuesta = disqueraDAO.bajaDisquera(disquera.getIdDisquera());
				System.out.println(respuesta);
				assertTrue(!respuesta.equals(""));
			} else{
				assertNotNull(disquera);
				assertTrue(disquera.getIdDisquera()>0);
			}
		} catch (PixupDAOException e) {
			System.out.println("Se presentó el siguiente error: "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Recibe las cadenas de entrada del usuario.
	 * @return
	 */
	public String entradaTeclado(){
		Scanner entradaEscaner = new Scanner (System.in);
		String entradaTeclado = "";
        entradaTeclado = entradaEscaner.nextLine();
        //entradaEscaner.close();
        return entradaTeclado;
	}

}
