package mx.unam.dgscati.pixup.wrapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import mx.unam.dgscati.pixup.exception.PixUpBOException;
import mx.unam.dgscati.pixup.model.Catalogo;
import mx.unam.dgscati.pixup.model.TipoUsuario;
import mx.unam.dgscati.pixup.model.Usuario;

public class UsuarioWrapper {
	
	private Usuario usuario;
	
	private int identificador;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String correoElectronico;
	private String fechaNacimiento;
	private int preguntaSecreta;
	private int tipoUsuario;
	private String respuestaSecreta;
	
	public UsuarioWrapper(){
		usuario = new Usuario();		
	}
	
	public int getIdentificador(){
		return this.identificador;
	}
	
	public void setIdentificador(int identificador){
		this.identificador = identificador;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getPreguntaSecreta() {
		return preguntaSecreta;
	}
	public void setPreguntaSecreta(int preguntaSecreta) {
		this.preguntaSecreta = preguntaSecreta;
	}
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	public String getRespuestaSecreta() {
		return respuestaSecreta;
	}
	public void setRespuestaSecreta(String respuestaSecreta) {
		this.respuestaSecreta = respuestaSecreta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Date getFechaNacimientoDate(){
		return usuario.getFechaNacimiento();
	}

	public Usuario toUsuario() throws PixUpBOException {
		Catalogo preguntaSecreta = new Catalogo();
		TipoUsuario tipoUsuario = new TipoUsuario();
		usuario.setCorreoElectronico(correoElectronico);
		usuario.setNombre(nombre);
		usuario.setPrimerApellido(apellidoPaterno);
		usuario.setSegundoApellido(apellidoMaterno);
//		usuario.setPreguntaSecreta(preguntaSecreta.buscarPorId(this.preguntaSecreta));
		usuario.setRespuestaSecreta(respuestaSecreta);
//		usuario.setTipo(tipoUsuario.buscarPorId(this.tipoUsuario));
		Date miFechaNacimiento = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			miFechaNacimiento = dateFormat.parse(fechaNacimiento);
			usuario.setFechaNacimiento(miFechaNacimiento);
		} catch (ParseException e) {
			throw new PixUpBOException(String.format("Imposible asignar el valor de fecha dado %s%n", fechaNacimiento));
		}
		return usuario;
	}
	
}
