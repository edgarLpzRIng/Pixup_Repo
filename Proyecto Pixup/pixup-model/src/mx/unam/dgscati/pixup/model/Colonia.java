package mx.unam.dgscati.pixup.model;

public class Colonia {
	
	private Integer		identificador;
	private String 		nombre;
	private String 		codigoPostal;
	private Municipio	municipio;
	
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
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Municipio getMunicipio() {
		return municipio;
	}
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}
	@Override
	public String toString() {
		return "Colonia [identificador=" + identificador + ", nombre=" + nombre + ", codigoPostal=" + codigoPostal
				+ ", municipio=" + municipio + "]";
	}

}
