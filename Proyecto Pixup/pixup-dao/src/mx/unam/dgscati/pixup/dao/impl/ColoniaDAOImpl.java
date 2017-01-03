package mx.unam.dgscati.pixup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import mx.unam.dgscati.pixup.dao.ColoniaDAO;
import mx.unam.dgscati.pixup.model.Colonia;
import mx.unam.dgscati.pixup.model.Estado;
import mx.unam.dgscati.pixup.model.Municipio;

public class ColoniaDAOImpl implements ColoniaDAO {
	
	DataSource dataSource;

	public ColoniaDAOImpl() {
		this.dataSource = new PixupDataSource().getDataSource();
	}

	@Override
	public List<Colonia> obtieneColoniasPorCP(String codigoPostal) {
		List<Colonia> colonias = new ArrayList<>();
		String sql = "select c.id, c.nombre, c.cp, m.nombre, e.nombre "
				+ "from colonia c inner join municipio m on c.id_municipio = m.id "
				+ "inner join estado e on m.id_estado = e.id "
				+ "where c.cp = ? ";
		//Try with resources statement. Se le pasan los parámetros que se deberían cerrar en el finally dentro de la sentencia. 
		try(
			Connection conn = dataSource.getConnection();
			PreparedStatement pst = conn.prepareStatement(sql);
			){
			pst.setString(1, codigoPostal);
			try(ResultSet rs = pst.executeQuery();){
				while(rs.next()){
					Colonia colonia = new Colonia();
					colonia.setIdentificador(rs.getInt(1));
					colonia.setNombre(rs.getString(2));
					colonia.setCodigoPostal(rs.getString(3));
					Municipio municipio = new Municipio();
					municipio.setNombre(rs.getString(4));
					Estado estado = new Estado();
					estado.setNombre(rs.getString(5));
					municipio.setEstado(estado);
					colonia.setMunicipio(municipio);
					colonias.add(colonia);
				}
			}			
		} catch(Exception e){
			System.out.println("Excepcion en ColoniaDAOImpl: "+e.getMessage());
		}
		
		return colonias;
	}

}
