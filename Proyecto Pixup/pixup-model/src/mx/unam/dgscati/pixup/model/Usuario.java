package mx.unam.dgscati.pixup.model;

import java.util.Date;
import java.util.List;

public class Usuario {

	private Integer			identificador;
	private String 			nombre;
	private String 			primerApellido;
	private String 			segundoApellido;
	private String 			correoElectronico;
	private Date 			fechaNacimiento;
	private Catalogo 		preguntaSecreta;
	private String 			respuestaSecreta;
	private String 			contrasenia;
	private String 			login;
	private boolean			estatus;
	private List<Perfil>	perfiles;

	public Usuario() {
		super();
	}
	
	/**
	 * Constructor para el login de usuario
	 * @param contrasenia
	 * @param login
	 */
	public Usuario(String login, String contrasenia) {
		this.login = login;
		this.contrasenia = contrasenia;
	}

	public Integer getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Integer identificador) {
		this.identificador = identificador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Catalogo getPreguntaSecreta() {
		return preguntaSecreta;
	}

	public void setPreguntaSecreta(Catalogo preguntaSecreta) {
		this.preguntaSecreta = preguntaSecreta;
	}

	public String getRespuestaSecreta() {
		return respuestaSecreta;
	}

	public void setRespuestaSecreta(String respuestaSecreta) {
		this.respuestaSecreta = respuestaSecreta;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	@Override
	public String toString() {
		return "Usuario [identificador=" + identificador + ", nombre=" + nombre + ", primerApellido=" + primerApellido
				+ ", segundoApellido=" + segundoApellido + ", correoElectronico=" + correoElectronico
				+ ", fechaNacimiento=" + fechaNacimiento + ", preguntaSecreta=" + preguntaSecreta
				+ ", respuestaSecreta=" + respuestaSecreta + ", contrasenia=" + contrasenia + ", login=" + login
				+ ", estatus=" + estatus + ", perfiles=" + perfiles + "]";
	}

	public String getNombreCompleto() {
		return this.nombre.concat(" ").concat(this.primerApellido).concat(" ").concat(this.segundoApellido);
	}

}
