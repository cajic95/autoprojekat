package com.skolarajak.servisi;

import java.util.ArrayList;
import java.util.List;
import com.skolarajak.dao.VoziloInMemoryDAOImpl;
import com.skolarajak.exceptions.dao.ResultNotFoundException;
import com.skolarajak.model.Vozilo;
import com.skolarajak.utils.Konstante;
import com.skolarajak.utils.RandomUtils;

/**
 * Servis za administrativne operacije sa vozilima
 * 
 * @author vladobra
 *
 */
public class AdministriranjeVozila {
	private static double PRAG_RASPODELE_AKTIVNIH_VOZILA = 0.5;
	private static final boolean STATUS = true;

	private VoziloInMemoryDAOImpl voziloDAO;

	public AdministriranjeVozila() {
		voziloDAO = new VoziloInMemoryDAOImpl();
	}

	/**
	 * Vrati test vozila
	 * 
	 * @return List<Vozilo> test vozila
	 */
	public List<Vozilo> generisi() {
		List<Vozilo> vozila = new ArrayList<Vozilo>();
		try {
			Vozilo zadnjeVozilo = null;
			for (int i = 0; i < Konstante.UKUPAN_BROJ_VOZILA_U_SISTEMU; i++) {
				int godinaProizvodnje = dodeliGodinuProizvodnje();
				Vozilo vozilo = new Vozilo(godinaProizvodnje);
				vozilo.setAktivno(randomBoolean());
				zadnjeVozilo = voziloDAO.create(vozilo);
			}
			System.out.println("UKUPNO reg brojeva: " + voziloDAO.count());

			vozila = voziloDAO.getAll();

		} catch (ResultNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("OBRISANO");
		}
		
		return vozila;
	}

	public List<Vozilo> euro3Vozila() {

		List<Vozilo> euro3Vozila = voziloDAO.getEuro3Vozila();

		return euro3Vozila; // vrati euro 3 vozila
	}

	public List<Vozilo> aktivnaVozila() {
		List<Vozilo> aktivnaVozila = voziloDAO.getAktivnaVozila();

		return aktivnaVozila;
	}

		public List<Vozilo> dajSvaVozila() throws ResultNotFoundException {
			return voziloDAO.getAll();
		}
		
	private int dodeliGodinuProizvodnje() {

		int random = RandomUtils.slucajanBrojUintervalu(Konstante.MINIMALAN_BROJ_GODINA_PROIZVODNJE,
				Konstante.MAXIMALAN_BROJ_GODINA_PROIZVODNJE);
		return random;
	}

	public static boolean randomBoolean() {
		return Math.random() < PRAG_RASPODELE_AKTIVNIH_VOZILA;
	}

}
