package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import data.util.Conexao;
import domain.Persistible;
import domain.RotaTaxi;

public class RotaTaxiDAO  implements Persistible<RotaTaxi>{

	private Connection connection;
	private Conexao conexao;
	
	public RotaTaxiDAO(Conexao conexao) {
		this.conexao = conexao;
		connection = conexao.abrirConexao();
	}
	/*
	id integer auto_increment not null primary key,
	idTaxi integer not null,
	dataHora datetime not null,
	latitude double not null,
	longitude double not null
	*/
	@Override
	public void save(RotaTaxi rotaTaxi) {
		
		// Usado o mesmo metodo para gravar tabelas diferentes para testar!!!
		//String sql = "insert into rotaTaxi100 (idTaxi, dataHora, latitude, longitude)"
		//		+ "values(?,?,?,?)";
		
		String sql = "insert into rotaTaxi10 (idTaxi, dataHora, latitude, longitude)"
				+ "values(?,?,?,?)";
		PreparedStatement pstmt;
		
		try{
			pstmt = connection.prepareStatement(sql);
			
			// setar parametros
			pstmt.setLong(1, rotaTaxi.getIdTaxi());
			pstmt.setTimestamp(2, rotaTaxi.getDataHora());
			pstmt.setDouble(3, rotaTaxi.getLatitude());
			pstmt.setDouble(4, rotaTaxi.getLongitude());
			
			pstmt.execute();
			pstmt.close();
			
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public RotaTaxi getOne(Long id) {
		RotaTaxi rt = null;
		try{
			Statement sta = connection.createStatement();
			// Usado o mesmo metodo para ler tabelas diferentes para testar!!!
			//ResultSet elements = sta.executeQuery("select * from rotaTaxi100 "
			//		+ "where id = " + id);
			
			ResultSet elements = sta.executeQuery("select * from rotaTaxi10 "
					+ "where id = " + id);
			
			while (elements.next()){
				rt = new RotaTaxi(elements.getLong("id"),
						elements.getLong("idTaxi"),
						elements.getTimestamp("dataHora"),
						elements.getDouble("latitude"),
						elements.getDouble("longitude"));
			}			
		} catch (SQLException ex){
			ex.printStackTrace();
		} 
		return rt;
	}
	
	@Override
	public RotaTaxi getLatLon(Double latitude, Double longitude) {
		RotaTaxi rt = null;
		try{
			Statement sta = connection.createStatement();
			// Usado o mesmo metodo para ler tabelas diferentes para testar!!!
			//ResultSet elements = sta.executeQuery("select * from rotaTaxi100 "
			//		+ "where latitude = " + latitude + " and longitude = " + longitude);
			
			ResultSet elements = sta.executeQuery("select * from rotaTaxi10 "
					+ "where latitude = " + latitude + " and longitude = " + longitude);
			
			while (elements.next()){
				rt = new RotaTaxi(elements.getLong("id"),
						elements.getLong("idTaxi"),
						elements.getTimestamp("dataHora"),
						elements.getDouble("latitude"),
						elements.getDouble("longitude"));
			}			
		} catch (SQLException ex){
			ex.printStackTrace();
		} 
		return rt;
	}

	@Override
	public List<RotaTaxi> getAll() {
		List<RotaTaxi> result = new ArrayList<RotaTaxi>();
		
		try{
			Statement sta = connection.createStatement();
			ResultSet elements = sta.executeQuery("select * from rotaTaxi10");
			//ResultSet elements = sta.executeQuery("select * from rotaTaxi100");
			
			while (elements.next()){
				RotaTaxi rt = new RotaTaxi();
				rt.setId(elements.getLong("id"));
				rt.setIdTaxi(elements.getLong("idTaxi"));
				rt.setDataHora(elements.getTimestamp("dataHora"));
				rt.setLatitude(elements.getDouble("latitude"));
				rt.setLongitude(elements.getDouble("longitude"));
				
				result.add(rt);
			}
			
		} catch (SQLException ex){
			ex.printStackTrace();
		} 
		return result;
	}

	@Override
	public void delete(RotaTaxi entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(RotaTaxi entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gravar(RotaTaxi entity) {
		// TODO Auto-generated method stub
		
	}
	
}
