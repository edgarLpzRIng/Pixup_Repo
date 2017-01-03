package mx.unam.dgscati.pixup.dao.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import mx.unam.dgscati.pixup.dao.UsuarioDAO;
import mx.unam.dgscati.pixup.model.Colonia;
import mx.unam.dgscati.pixup.model.Domicilio;
import mx.unam.dgscati.pixup.model.PreguntaSecreta;
import mx.unam.dgscati.pixup.model.TipoDomicilio;
import mx.unam.dgscati.pixup.model.TipoUsuario;
import mx.unam.dgscati.pixup.model.Usuario;

public class UsuarioDAOImplTest {

	@Test
	public void test() {
		
		UsuarioDAO usuarioDAO = new UsuarioDAOImpl();
		Usuario usuario = new Usuario();
		List<Domicilio> domicilios = new ArrayList<>();
		List<TipoUsuario> tiposUsuario = new ArrayList<>();
		
		usuario = crearUsuario();
		domicilios = crearListaDomicilios();
		tiposUsuario = crearListaTipoUsuario();
		
		usuario = usuarioDAO.guardarUsuario(usuario, domicilios, tiposUsuario);
		
		System.out.println("El usuario creado es: "+usuario.getIdentificador());
		
		
		assertTrue(usuario.getIdentificador()>0);
	}
	
	private Usuario crearUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNombre("Roberto");
		usuario.setPrimerApellido("López");
		usuario.setSegundoApellido("Montes de Oca");
		usuario.setLogin("RobZombie");
		usuario.setContrasenia("robLoRo");
		usuario.setCorreoElectronico("rob_correo@rob.com");
		
		PreguntaSecreta preguntaSecreta = new PreguntaSecreta();
		preguntaSecreta.setIdentificador(1);
		usuario.setPreguntaSecreta(preguntaSecreta);
		usuario.setRespuestaSecreta("Chucky");
		
		return usuario;
	}
	
	private List<Domicilio> crearListaDomicilios(){
		List<Domicilio> domicilios = new ArrayList<>();
		Domicilio domicilio = new Domicilio();
		
		domicilio.setCalle("Porton");
		domicilio.setNumeroExterior("833");
		domicilio.setNumeroInterior("78");
		
		Colonia colonia = new Colonia();
		colonia.setIdentificador(1);
		domicilio.setColonia(colonia);
		
		TipoDomicilio tipoDomicilio = new TipoDomicilio();
		tipoDomicilio.setIdentificador(1);
		domicilio.setTipoDomicilio(tipoDomicilio);
		
		domicilios.add(domicilio);
		
		return domicilios;
	}
	
	private List<TipoUsuario> crearListaTipoUsuario(){
		
		List<TipoUsuario> tiposUsuario = new ArrayList<>();
		
		TipoUsuario tipoUsuarioAdm = new TipoUsuario();
		tipoUsuarioAdm.setIdentificador(1);
		tiposUsuario.add(tipoUsuarioAdm);
		
		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdentificador(3);
		tiposUsuario.add(tipoUsuario);
		
		return tiposUsuario;
	}

}
