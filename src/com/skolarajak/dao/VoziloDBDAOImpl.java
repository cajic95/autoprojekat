package com.skolarajak.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.skolarajak.exceptions.dao.ResultNotFoundException;
import com.skolarajak.model.Vozilo;
import com.skolarajak.utils.DBUtils;

public class VoziloDBDAOImpl implements VoziloDAO {
	 public VoziloDBDAOImpl() throws ClassNotFoundException {
		// TODO Auto-generated constructor stub
		 Class.forName(DBUtils.myDriver);
	}

	@Override
	public Vozilo create(Vozilo vozilo) {

		try {
			// create a mysql database connection

			Connection conn = getConnection();

			// the mysql insert statement
			String query = " insert into vozilo (regbroj, godisteProizvodnje, status, vlasnikId)" + " values (?, ?, ?,?)";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, vozilo.getRegistarskiBroj());
			preparedStmt.setInt(2, vozilo.getGodisteProizvodnje());
			preparedStmt.setBoolean(3, vozilo.isAktivno());
			preparedStmt.setString(4, vozilo.getVlasnik().getBrojVozackeDozvole());

			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return vozilo;
	}

	@Override
	public Vozilo read(String registarskiBroj) throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vozilo update(Vozilo vozilo) {
		try {
			// create a mysql database connection

			Connection conn = getConnection();

			// the mysql insert statement
			String query = "update vozilo set regbroj=?, godisteProizvodnje=?, status=?, vlasnikId=?" 
			+ " where regbroj = ? ";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			preparedStmt.setString(1, vozilo.getRegistarskiBroj());
			preparedStmt.setInt(2, vozilo.getGodisteProizvodnje());
			preparedStmt.setBoolean(3, vozilo.isAktivno());
			preparedStmt.setString(4, vozilo.getVlasnik().getBrojVozackeDozvole());
			preparedStmt.setString(5, vozilo.getRegistarskiBroj());
			  
			// execute the preparedstatement
			preparedStmt.executeUpdate();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
		return vozilo;
	}
	

	@Override
	public void delete(String registarskiBroj) {
		try {
			// create a mysql database connection

			Connection conn = getConnection();

			// the mysql insert statement
			String query = " delete from vozilo where regbroj=? ";

			// create the mysql insert preparedstatement
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			
			
			preparedStmt.setString(1, registarskiBroj);
			// execute the preparedstatement
			preparedStmt.execute();

			conn.close();
		} catch (Exception e) {
			System.err.println("Got an exception!");
			System.err.println(e.getMessage());
		}
	}

	@Override
	public List<Vozilo> getAll() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Vozilo> getEuro3Vozila() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vozilo> getAktivnaVozila() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vozilo> getAllVozilaCijeImeVlasnikaSadrziSlovoA() throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	private Connection getConnection() throws ClassNotFoundException, SQLException {
	
	
		return DriverManager.getConnection(DBUtils.myUrl, "root", "root");
	} 
}
