package mx.unam.dgscati.pixup.model;

public class Municipio {
	
	private int 	identificador;
	private String 	nombre;
	private Estado	estado;
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Municipio [identificador=" + identificador + ", nombre=" + nombre + ", estado=" + estado + "]";
	}

}
