package mx.unam.dgscati.pixup.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mx.unam.dgscati.pixup.dao.PreguntaSecretaDAO;
import mx.unam.dgscati.pixup.model.Catalogo;

public class PreguntaSecretaDAOImpl implements PreguntaSecretaDAO {

	@Override
	public List<Catalogo> encuentraTodos() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		List<Catalogo> catalogos = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pixup", "root", "diplomadojava");
			
			statement = connection.createStatement();
			String sql = "SELECT * FROM pregunta_secreta";
			resultSet = statement.executeQuery(sql);
			
			if(resultSet!=null){
				while(resultSet.next()){
					Catalogo catalogo = new Catalogo();
					catalogo.setIdentificador(resultSet.getInt(1));
					catalogo.setDescripcion(resultSet.getString(2));
					catalogos.add(catalogo);
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet!=null)
				try { resultSet.close(); } catch (SQLException e) {}
			if(statement!=null)
				try {statement.close();} catch (SQLException e) {e.printStackTrace();}
			if(connection!=null)
				try {connection.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return catalogos;
	}

}
