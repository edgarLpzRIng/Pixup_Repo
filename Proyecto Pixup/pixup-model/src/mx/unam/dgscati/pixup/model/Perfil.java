package mx.unam.dgscati.pixup.model;

public class Perfil {
	
	private Usuario 	usuario;
	private TipoUsuario	tipoUsuario;

	public Perfil(Usuario usuario, TipoUsuario tipoUsuario) {
		this.usuario = usuario;
		this.tipoUsuario = tipoUsuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	@Override
	public String toString() {
		return "Perfil [usuario=" + usuario + ", tipoUsuario=" + tipoUsuario + "]";
	}

}
