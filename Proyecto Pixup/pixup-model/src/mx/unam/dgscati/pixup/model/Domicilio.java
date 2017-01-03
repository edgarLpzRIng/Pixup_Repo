package mx.unam.dgscati.pixup.model;

public class Domicilio {
	
	private int 			identificador;
	private String 			calle;
	private String			numeroExterior;
	private String			numeroInterior;
	private Usuario 		usuario;
	private Colonia 		colonia;
	private TipoDomicilio	tipoDomicilio;
	
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}
	public String getNumeroInterior() {
		return numeroInterior;
	}
	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Colonia getColonia() {
		return colonia;
	}
	public void setColonia(Colonia colonia) {
		this.colonia = colonia;
	}
	public TipoDomicilio getTipoDomicilio() {
		return tipoDomicilio;
	}
	public void setTipoDomicilio(TipoDomicilio tipoDomicilio) {
		this.tipoDomicilio = tipoDomicilio;
	}
	
	@Override
	public String toString() {
		return "Domicilio [identificador=" + identificador + ", calle=" + calle + ", numeroExterior=" + numeroExterior
				+ ", numeroInterior=" + numeroInterior + ", usuario=" + usuario + ", colonia=" + colonia
				+ ", tipoDomicilio=" + tipoDomicilio + "]";
	}

}
