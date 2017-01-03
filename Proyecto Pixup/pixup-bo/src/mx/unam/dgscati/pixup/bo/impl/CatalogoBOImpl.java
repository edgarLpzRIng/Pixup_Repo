package mx.unam.dgscati.pixup.bo.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mx.unam.dgscati.pixup.bo.CatalogoBO;
import mx.unam.dgscati.pixup.dao.PreguntaSecretaDAO;
import mx.unam.dgscati.pixup.dao.impl.PreguntaSecretaDAOImpl;
import mx.unam.dgscati.pixup.exception.PixUpBOException;
import mx.unam.dgscati.pixup.model.Catalogo;
import mx.unam.dgscati.pixup.model.TipoUsuario;

public class CatalogoBOImpl implements CatalogoBO {
	private static final Catalogo PREGUNTA_SECRETA = new Catalogo();
	private static final TipoUsuario TIPO_USUARIO = new TipoUsuario();
	
	private PreguntaSecretaDAO preguntaSecretaDAO;
	
	public CatalogoBOImpl() {
		this.preguntaSecretaDAO = new PreguntaSecretaDAOImpl();
	}

	@Override
	public List<String> listarPreguntaSecreta() throws PixUpBOException {
//		return armaListado(PREGUNTA_SECRETA.listar());
		return null;
	}

	@Override
	public List<String> listarTipoUsuario() throws PixUpBOException {
		return armaListado(TIPO_USUARIO.listar());
	}

	@Override
	public String encontrarPreguntaSecretaPorId(int id) throws PixUpBOException {
		
//		Catalogo elemento = PREGUNTA_SECRETA.buscarPorId(id);
//		return elemento.getDescripcion();
		
		// TODO manejo de la excepción en caso de que no se localice el valor
		return null;
	}

	@Override
	public String encontrarTipousuarioPorId(int id) throws PixUpBOException {

		Catalogo elemento = TIPO_USUARIO.buscarPorId(id);
		return elemento.getDescripcion();

		// TODO manejo de la excepción en caso de que no se localice el valor
	
	}

	private List<String> armaListado(List<Catalogo> lista) {
		List<String> listado = new ArrayList<>();
		for (Catalogo catalogo : lista) {
			StringBuilder registro = new StringBuilder();
			registro.append(String.valueOf(catalogo.getIdentificador())).append(" - ");
			registro.append(catalogo.getDescripcion());
			listado.add(registro.toString());
		}
		return listado;
	}

	@Override
	public Set<Catalogo> obtenerPreguntasSecretas() {
		Set<Catalogo> catalogos = new HashSet<>();
		catalogos.addAll(preguntaSecretaDAO.encuentraTodos());
		return catalogos;
	}

}
