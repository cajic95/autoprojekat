package com.skolarajak.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.skolarajak.exceptions.dao.ResultNotFoundException;
import com.skolarajak.model.Vozilo;

public class VoziloDBDAOImpl implements VoziloDAO {

	@Override
	public Vozilo create(Vozilo vozilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vozilo read(String registarskiBroj) throws ResultNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vozilo update(Vozilo vozilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String registarskiBroj) {
		// TODO Auto-generated method stub

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
		String myDriver = "com.mysql.jdbc.Driver";
		String myUrl = "jdbc:mysql://localhost:3306/ams";
		Class.forName(myDriver);
		return DriverManager.getConnection(myUrl, "root", "root");
	}
}
