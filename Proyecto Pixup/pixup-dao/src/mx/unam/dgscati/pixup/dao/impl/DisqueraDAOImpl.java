package mx.unam.dgscati.pixup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import mx.unam.dgscati.pixup.dao.DisqueraDAO;
import mx.unam.dgscati.pixup.dao.exception.PixupDAOException;
import mx.unam.dgscati.pixup.model.Colonia;
import mx.unam.dgscati.pixup.model.DisqueraVO;
import mx.unam.dgscati.pixup.model.Estado;
import mx.unam.dgscati.pixup.model.Municipio;

public class DisqueraDAOImpl implements DisqueraDAO {
	
	DataSource dataSource;
	
	public DisqueraDAOImpl() {
		this.dataSource = new PixupDataSource().getDataSource();
	}

	@Override
	public DisqueraVO guardarDisquera(DisqueraVO disquera) throws PixupDAOException {
		String query = "insert into disquera (nombre) values (?)";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			){
			pst.setString(1, disquera.getNombreDisquera());
			pst.executeUpdate();
			
			try(ResultSet rs = pst.getGeneratedKeys();){
				if(rs.next()){
					disquera.setIdDisquera(rs.getInt(1));
				}
			}
			
		}catch (SQLException e) {
			throw new PixupDAOException("Excepcion en DisqueraDAOImpl: "+e.getMessage());
		}
		return disquera;
	}

	@Override
	public DisqueraVO actualizaDisquera(DisqueraVO disquera) throws PixupDAOException {
		String query = "update disquera set nombre = ? where id = ?";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			){
			pst.setString(1, disquera.getNombreDisquera());
			pst.setInt(2, disquera.getIdDisquera());
			pst.executeUpdate();
			
		}catch (SQLException e) {
			throw new PixupDAOException("Excepcion en DisqueraDAOImpl: "+e.getMessage());
		}
		return disquera;
	}

	@Override
	public String bajaDisquera(Integer idDisquera) throws PixupDAOException {
		String query = "delete from disquera where id = ?";
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			){
			pst.setInt(1, idDisquera);
			pst.executeUpdate();
			
			return "La disquera se dio de baja exitosamente";
			
		}catch (SQLException e) {
			throw new PixupDAOException("Error en DisqueraDAOImpl: "+e.getMessage());
		}
	}

	@Override
	public List<DisqueraVO> listarDisqueras() throws PixupDAOException {
		List<DisqueraVO> disqueras = new ArrayList<>();
		String sql = "select * from disquera";
		//Try with resources statement. Se le pasan los parámetros que se deberían cerrar en el finally dentro de la sentencia. 
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
			try(ResultSet rs = pst.executeQuery();){
				while(rs.next()){
					DisqueraVO disquera = new DisqueraVO();
					disquera.setIdDisquera(rs.getInt(1));
					disquera.setNombreDisquera(rs.getString(2));
					disqueras.add(disquera);
				}
			}			
		} catch(Exception e){
			System.out.println("Excepcion en DisqueraDAOImpl: "+e.getMessage());
		}
		
		return disqueras;
	}

}
