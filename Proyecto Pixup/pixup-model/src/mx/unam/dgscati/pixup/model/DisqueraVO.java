package mx.unam.dgscati.pixup.model;

public class DisqueraVO {
	
	private Integer idDisquera;
	private String 	nombreDisquera;
	
	public Integer getIdDisquera() {
		return idDisquera;
	}
	public void setIdDisquera(Integer idDisquera) {
		this.idDisquera = idDisquera;
	}
	public String getNombreDisquera() {
		return nombreDisquera;
	}
	public void setNombreDisquera(String nombreDisquera) {
		this.nombreDisquera = nombreDisquera;
	}
	
	@Override
	public String toString() {
		return "DisqueraVO [idDisquera=" + idDisquera + ", nombreDisquera=" + nombreDisquera + "]";
	}

}
