package mx.unam.dgscati.pixup.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;

import mx.unam.dgscati.pixup.dao.TipoDomicilioDAO;
import mx.unam.dgscati.pixup.model.Catalogo;

public class TipoDomicilioDAOImpl implements TipoDomicilioDAO {

	@Override
	public List<Catalogo> encuentraTodos() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/pixup");
		dataSource.setUsername("root");
		dataSource.setPassword("diplomadojava");
		
		String sql = "select id, descripcion from tipo_domicilio";
		List<Catalogo> tipoDomicilioLT = new ArrayList<>();
		
		try (
				Connection conn =  dataSource.getConnection();
				PreparedStatement pst = conn.prepareStatement(sql);
				ResultSet rs = pst.executeQuery();){
			while(rs.next()){
				Catalogo catalogo = new Catalogo();
				catalogo.setIdentificador(rs.getInt("id"));
				catalogo.setDescripcion(rs.getString("descripcion"));
				tipoDomicilioLT.add(catalogo);
			} 
		} catch(Exception e){
			System.out.println("Error en TipoDomicilioDAO: "+e.getMessage());
			e.printStackTrace();
		}
		
		return tipoDomicilioLT;
	}

}
