package mx.unam.dgscati.pixup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import mx.unam.dgscati.pixup.dao.UsuarioDAO;
import mx.unam.dgscati.pixup.dao.exception.PixupDAOException;
import mx.unam.dgscati.pixup.model.Domicilio;
import mx.unam.dgscati.pixup.model.Perfil;
import mx.unam.dgscati.pixup.model.TipoUsuario;
import mx.unam.dgscati.pixup.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {

	private DataSource dataSource;

	public UsuarioDAOImpl() {
		this.dataSource = new PixupDataSource().getDataSource();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario, List<Domicilio> domicilios, List<TipoUsuario> tiposUsuario) {
		Connection conn = null;
		String sql = "insert into usuario "
				+ " (nombre,primer_apellido,segundo_apellido,login,password,email, id_pregunta_secreta,respuesta_secreta) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?);";
		try {
			conn = dataSource.getConnection();
			conn.setAutoCommit(false);
			try(PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);){
				pst.setString(1, usuario.getNombre());
				pst.setString(2, usuario.getPrimerApellido());
				pst.setString(3, usuario.getSegundoApellido());
				pst.setString(4, usuario.getLogin());
				pst.setString(5, usuario.getContrasenia());
				pst.setString(6, usuario.getCorreoElectronico());
				pst.setInt(7, usuario.getPreguntaSecreta().getIdentificador());
				pst.setString(8, usuario.getRespuestaSecreta());
				
				pst.executeUpdate();
				
				try(ResultSet rs = pst.getGeneratedKeys();){
					if(rs.next()){
						usuario.setIdentificador(rs.getInt(1));
					}
				}
				
				sql = "insert into domicilio "
						+ " (calle, num_exterior, num_interior, id_usuario, id_colonia, id_tipo_domicilio) "
						+ " values (?, ?, ?, ?, ?, ?);";
				
				try(PreparedStatement pstDom = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
					for(Domicilio domicilio : domicilios){
						pstDom.setString(1, domicilio.getCalle());
						pstDom.setString(2, domicilio.getNumeroExterior());
						pstDom.setString(3, domicilio.getNumeroInterior());
						pstDom.setInt(4, usuario.getIdentificador());
						pstDom.setInt(5, domicilio.getColonia().getIdentificador());
						pstDom.setInt(6, domicilio.getTipoDomicilio().getIdentificador());
						
						pstDom.executeUpdate();
						
						try(ResultSet rs = pstDom.getGeneratedKeys();){
							if(rs.next()){
								domicilio.setIdentificador(rs.getInt(1));
							}
						}
					}
				}
				sql = "insert into perfil (id_usuario,id_tipo_usuario) values (?, ?)";
				List<Perfil> perfiles = new ArrayList<>();
				try(PreparedStatement pstPer = conn.prepareStatement(sql)){
					for(TipoUsuario tipoUsuario : tiposUsuario){
						pstPer.setInt(1, usuario.getIdentificador());
						pstPer.setInt(2, tipoUsuario.getIdentificador());
						
						pstPer.executeUpdate();
						
						Perfil perfil = new Perfil(usuario, tipoUsuario);
						perfiles.add(perfil);
						
						usuario.setPerfiles(perfiles);
					}
					
				}
			}
			conn.commit();
		} catch (Exception e) {
			try {conn.rollback();} catch(Exception ex){}
			System.out.println("Excepcion en UsuarioDAOImpl: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			if(conn!=null){
				try {
					conn.close();
				} catch(Exception ex){}
			}
		}

		return usuario;
	}

	@Override
	public Usuario buscarUsuario(Usuario usuario) {
		String query = "select id, nombre, primer_apellido, segundo_apellido, login, email "
				+ " from usuario where login = ? and password = ?";
		
		try(Connection conn =  dataSource.getConnection();
				PreparedStatement pstm = conn.prepareStatement(query);
				){
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getContrasenia());
			try(ResultSet rs = pstm.executeQuery();){
				if(rs.next()){
					Usuario usuarioPersistente = new Usuario();
					usuarioPersistente.setIdentificador(rs.getInt(1));
					usuarioPersistente.setNombre(rs.getString(2));
					usuarioPersistente.setPrimerApellido(rs.getString(3));
					usuarioPersistente.setSegundoApellido(rs.getString(4));
					usuarioPersistente.setLogin(rs.getString(5));
					usuarioPersistente.setCorreoElectronico(rs.getString(6));
					return usuarioPersistente;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("Excepcion en UsarioDAOImpl: "+e.getMessage());
			//throw new PixupDAOException("Excepcion en UsarioDAOImpl: "+e.getMessage());
		}
		return null;
	}

}
