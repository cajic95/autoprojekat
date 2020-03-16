package com.skolarajak.servisi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import com.skolarajak.model.Vozilo;
import com.skolarajak.utils.Konstante;

/**
 * Servis za administrativne operacije sa vozilima
 * 
 * @author vladobra
 *
 */
public class AdministriranjeVozila {
	private static final boolean STATUS = true;
	private static double PRAG_RASPODELE_AKTIVNIH_VOZILA = 0.5;
	private static int SLOVO_A = 65;
	private static int SLOVO_Z = 90;

	private static final HashMap<String,String> registarskiBrojevi = new HashMap<String,String>();
	/**
	 * Vrati test vozila
	 * 
	 * @return List<Vozilo> test vozila
	 */
	public List<Vozilo> generisi() {
		List<Vozilo> vozila = new ArrayList<Vozilo>();
		for (int i = 0; i < Konstante.UKUPAN_BROJ_VOZILA_U_SISTEMU; i++) {
			int godinaProizvodnje = dodeliGodinuProizvodnje();
			Vozilo vozilo = new Vozilo(godinaProizvodnje);
			vozilo.setAktivno(randomBoolean());
			vozilo.setRegistarskiBroj(kreirajRegistarskiBroj());
			vozila.add(vozilo);
		}
		System.out.println("UKUPNO reg brojeva: " + registarskiBrojevi.keySet().size());
		return vozila;
	}

	public List<Vozilo> euro3Vozila(List<Vozilo> vozila) {
		/*
		 * List<Vozilo> euro3Vozila = new ArrayList<Vozilo>(); for (Vozilo vozilo :
		 * vozila) { if(vozilo.getGodisteProizvodnje() >= Konstante.EURO_3_GODISTE) {
		 * euro3Vozila.add(vozilo);
		 * 
		 * } }
		 */
		List<Vozilo> euro3Vozila = vozila.stream().filter(v -> v.getGodisteProizvodnje() >= 2000)
				.collect(Collectors.toList());

		return euro3Vozila; // vrati euro 3 vozila
	}

	private String kreirajRegistarskiBroj() {
		/*String registarskiBroj = "Reg-" + slucajnoSlovo() + slucajnoSlovo();	
		if(registarskiBrojevi.containsKey(registarskiBroj)) {
			System.out.println("*********** DUPLICAT ************" +registarskiBroj);
			return kreirajRegistarskiBroj();
		}
				registarskiBrojevi.put(registarskiBroj,registarskiBroj);
		registarskiBrojevi.put(registarskiBroj, registarskiBroj);*/
		String registarskiBroj = "";
		while(1==1) {
			registarskiBroj = "Reg-" + slucajnoSlovo() + slucajnoSlovo();
			if(!registarskiBrojevi.containsKey(registarskiBroj)) {
				registarskiBrojevi.put(registarskiBroj, registarskiBroj);
			break;
		}
		else {
			System.out.println("*********** DUPLICAT ************" +registarskiBroj);
		}
		}
		return registarskiBroj;
				
	
	}

	public List<Vozilo> aktivnaVozila(List<Vozilo> vozila) {
		/*
		 * List<Vozilo> aktivnaVozila = new ArrayList<Vozilo>(); for (Vozilo vozilo :
		 * vozila) { if(vozilo.isAktivno()== STATUS) { aktivnaVozila.add(vozilo); } }
		 */List<Vozilo> aktivnaVozila = vozila.stream().filter(v1 -> v1.isAktivno()).collect(Collectors.toList());

		return aktivnaVozila;
	}

	private int dodeliGodinuProizvodnje() {

		int random = slucajanBrojUintervalu(Konstante.MINIMALAN_BROJ_GODINA_PROIZVODNJE,
				Konstante.MAXIMALAN_BROJ_GODINA_PROIZVODNJE);
		return random;
	}

	private String slucajnoSlovo() {
		char c = (char) slucajanBrojUintervalu(SLOVO_A, SLOVO_Z);
		return String.valueOf(c);
	}

	public boolean randomBoolean() {
		return Math.random() < PRAG_RASPODELE_AKTIVNIH_VOZILA;
	}

	private int slucajanBrojUintervalu(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}
}
