package com.skolarajak.model;

public class Vlasnik {
	private String ime;
	private String prezime;
	private String brojVozackeDozvole;
	private Vozilo vozila;
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getBrojVozackeDozvole() {
		return brojVozackeDozvole;
	}
	public void setBrojVozackeDozvole(String brojVozackeDozvole) {
		this.brojVozackeDozvole = brojVozackeDozvole;
	}
	public Vozilo getVozila() {
		return vozila;
	}
	public void setVozila(Vozilo vozila) {
		this.vozila = vozila;
	}

}
