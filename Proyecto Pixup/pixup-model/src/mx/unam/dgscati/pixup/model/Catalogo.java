package mx.unam.dgscati.pixup.model;

/***
 * 
 * @author Carlos Farias 
 * @category Cargador de catalogos generales
 *
 */


public class Catalogo {

	protected int identificador;
	protected String descripcion;
	
	public Catalogo(){}

	
	/***
	 * Constructor especializado de la clase para dar oportunidad de aplicar una mala práctica en programación OO
	 * @param identificador valor entero que representa la identificación de la tupla dentro de la proyección del almacenaje
	 * @param descripcion valor descriptivo del identificador
	 * 
	 */
	public Catalogo(int identificador, String descripcion) {
		this.identificador = identificador;
		setDescripcion(descripcion);
	}

	/***
	 * 
	 * @return
	 * @throws Exception
	 * 
	 */
	
	public int getIdentificador() {		
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Catalogo [identificador=" + identificador + ", descripcion=" + descripcion + "]";
	}
	
}










