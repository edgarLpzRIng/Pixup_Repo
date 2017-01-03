package mx.unam.dgscati.pixup.bo;

import java.util.List;
import java.util.Set;

import mx.unam.dgscati.pixup.exception.PixUpBOException;
import mx.unam.dgscati.pixup.model.Catalogo;

public interface CatalogoBO {

	public List<String> listarPreguntaSecreta() throws PixUpBOException;
	public List<String> listarTipoUsuario() throws PixUpBOException;
	
	public String encontrarPreguntaSecretaPorId(int id) throws PixUpBOException;
	public String encontrarTipousuarioPorId(int id) throws PixUpBOException;
	
	Set<Catalogo> obtenerPreguntasSecretas();
	
}
