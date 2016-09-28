package data.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

private Connection connection; // a ser utiliado no DAO
	
	private final String URL = "jdbc:mysql://localhost:3306/bd"; // ver a porta
	
	private final String USER = "root";
	
	private final String PASSWORD = "";	// senha, eu acho que é nulo
	
	private final String TPCONEXAO = "com.mysql.jdbc.Driver";
	
	public Connection abrirConexao(){
		try {
			Class.forName(TPCONEXAO);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			connection.setAutoCommit(false);
		} catch (ClassNotFoundException ex){
			ex.printStackTrace();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return connection;
	}
	
	public void fecharConexao(){
		if (connection != null){
			try{
				connection.commit();
				connection.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
	
}
