package mx.unam.dgscati.pixup.model;

public class Estado {
	
	private int 	identificador;
	private String 	nombre;
	
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
	
	@Override
	public String toString() {
		return "Estado [identificador=" + identificador + ", nombre=" + nombre + "]";
	}

}
