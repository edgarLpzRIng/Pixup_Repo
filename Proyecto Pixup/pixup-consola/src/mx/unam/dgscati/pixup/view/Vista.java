package mx.unam.dgscati.pixup.view;

import java.io.Console;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import mx.unam.dgscati.pixup.bo.CatalogoBO;
import mx.unam.dgscati.pixup.bo.RegistroBO;
import mx.unam.dgscati.pixup.bo.impl.CatalogoBOImpl;
import mx.unam.dgscati.pixup.bo.impl.RegistroBOImpl;
import mx.unam.dgscati.pixup.exception.PixUpBOException;
import mx.unam.dgscati.pixup.wrapper.UsuarioWrapper;

public final class Vista {

	private static final Console CONSOLA = System.console();
	private static PrintWriter out;

	private static final String SALTO_LINEA = System.lineSeparator();

	private static final String CABECERA = " ::: Pixup-Console ::: ".concat(SALTO_LINEA);
	private static final String BIENVENIDA = "- Bienvenido a la aplicación PixUp-Console         -".concat(SALTO_LINEA);
	private static final String OPCION_SALIDA = "- para salir de la aplicación presiona X           -"
			.concat(SALTO_LINEA);
	private static final String OPCION_REGISTRO = "- 1 Registrar usuario                              -"
			.concat(SALTO_LINEA);
	private static final String OPCION_DESACTIVAR = "- 3 Desactivar usuario                             -"
			.concat(SALTO_LINEA);
	private static final String OPCION_CAMBIA_CONTRASENIA = "- 2 CAMBIAR CONTRASEÑA                             -"
			.concat(SALTO_LINEA);

	private static final String DESPEDIDA = "- Gracias por usar PixUp-Console                   -".concat(SALTO_LINEA);
	private static final String SELECCION_MENU = "- Selecciona una opción de menú                    -"
			.concat(SALTO_LINEA);
	private static final String SELECCION_MENU_NO_VALIDO = "- La opción que seleccionaste no es valida         -"
			.concat(SALTO_LINEA);

	private static final char MENU_SALIDA = 'X';
	private static final char MENU_REGISTRO = '1';
	private static final char MENU_DESACTIVAR = '2';
	private static final char MENU_CAMBIAR_CONTRASENIA = '3';

	public Vista() {
		out = CONSOLA.writer();
		imprimeBienvenida();
	}

	public void iniciar() {
		// CONSOLA.printf("HEY");
		char seleccion = '\0';

		do {
			imprimeMenu();
			out.flush();
			String seleccionUsuario = CONSOLA.readLine();
			seleccion = seleccionUsuario.charAt(0);
			switch (seleccion) {
			case MENU_REGISTRO:
				// realiza registro;
				registrarUsuario();
				break;
			case MENU_DESACTIVAR:
				// desactiva al usuario;
				break;
			case MENU_CAMBIAR_CONTRASENIA:
				// cambia la contraseña;
				break;
			case MENU_SALIDA:
				imprimeDespedida();
				out.flush();
				break;
			default:
				imprimeSeleccionNoValida();
				out.flush();
			}
		} while (seleccion != MENU_SALIDA);
	}

	private void registrarUsuario() {

		CatalogoBO catalogos = new CatalogoBOImpl();
		UsuarioWrapper usuarioWrapper = new UsuarioWrapper();
		String respuesta;
		out.write("Cuál es tu nombre?");
		out.flush();
		respuesta = CONSOLA.readLine();
		usuarioWrapper.setNombre(respuesta);

		out.write("Cuál es tu apellido paterno?");
		out.flush();
		respuesta = CONSOLA.readLine();
		usuarioWrapper.setApellidoPaterno(respuesta);

		out.write("Cuál es tu apellido materno?");
		out.flush();
		respuesta = CONSOLA.readLine();
		usuarioWrapper.setApellidoMaterno(respuesta);

		out.write("Cuál es tu correo electrónico?");
		out.flush();
		respuesta = CONSOLA.readLine();
		usuarioWrapper.setCorreoElectronico(respuesta);

		out.write("Cuál es tu fecha de nacimiento (dd/mm/yyyy)?");
		out.flush();
		respuesta = CONSOLA.readLine();
		usuarioWrapper.setFechaNacimiento(respuesta);
		try{
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date miFecha = dateFormat.parse(respuesta);
			out.write(miFecha.toString());
		} catch (java.text.ParseException e) {
			out.write(e.getMessage());
		}
		out.flush();

		out.write("De la lista siguiente selecciona la pregunta secreta".concat(SALTO_LINEA));
		List<String> listaPreguntaSecreta = new ArrayList<>();
		try {
			listaPreguntaSecreta = catalogos.listarPreguntaSecreta();
		} catch (PixUpBOException e) {
			out.write("Imposible listar las preguntas secretas. ".concat(e.getMessage()));
			out.flush();
			return;
		}
		for (String registro : listaPreguntaSecreta) {
			out.write(registro.concat(SALTO_LINEA));
		}
		out.flush();

		respuesta = CONSOLA.readLine();
		usuarioWrapper.setPreguntaSecreta(Integer.valueOf(respuesta) - 1);

		out.write("Indique la respuesta a la pregunta secreta ...".concat(SALTO_LINEA));
		out.flush();
		respuesta = CONSOLA.readLine();
		usuarioWrapper.setRespuestaSecreta(respuesta);

		out.write("De la lista siguiente selecciona el tipo de usuario a registrar".concat(SALTO_LINEA));
		List<String> listaTipoUsuario = new ArrayList<>();
		try {
			listaTipoUsuario = catalogos.listarTipoUsuario();
			for (String registro : listaTipoUsuario) {
				out.write(registro.concat(SALTO_LINEA));
			}
			out.flush();
			respuesta = CONSOLA.readLine();
		} catch (PixUpBOException e) {
			out.write("Imposible listar los tipos de usuario. ".concat(e.getMessage()));
			out.flush();
			respuesta = "1";
		}
		usuarioWrapper.setTipoUsuario(Integer.valueOf(respuesta) - 1);

		RegistroBO registro = new RegistroBOImpl();
		try {
			usuarioWrapper = registro.registrar(usuarioWrapper);
		} catch (PixUpBOException e) {
			out.write("Imposible registrar al usuario en este momento, ".concat(e.getMessage()));
			return;
		}
		if (usuarioWrapper.getIdentificador() > 0) {
			out.write("Usuario registrado correctamente con identificador: "
					.concat(String.valueOf(usuarioWrapper.getIdentificador())));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			out.write("Fecha de nacimiento: ".concat(usuarioWrapper.getFechaNacimiento()).concat(SALTO_LINEA));
			out.write("Fecha de nacimiento Date: ".concat(dateFormat.format(usuarioWrapper.getFechaNacimientoDate())));
			out.flush();
		}

	}

	private void imprimeSeleccionNoValida() {
		out.write(SELECCION_MENU_NO_VALIDO);
	}

	private void imprimeBienvenida() {
		out.write(CABECERA);
		out.write(BIENVENIDA);
	}

	private void imprimeDespedida() {
		out.write(DESPEDIDA);
	}

	private void imprimeMenu() {
		out.write(SELECCION_MENU);
		out.write(OPCION_REGISTRO);
		out.write(OPCION_CAMBIA_CONTRASENIA);
		out.write(OPCION_DESACTIVAR);
		out.write(OPCION_SALIDA);
	}

}
