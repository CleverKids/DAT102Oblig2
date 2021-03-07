package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Medlem {
	private String navn;
	private int statusIndeks;
	private MengdeADT<Hobby> hobbyer;
	
	public Medlem(String navn) {
		this(navn, -1);
	}
	
	public Medlem(String navn, int statusIndeks) {
		hobbyer = new TabellMengde<Hobby>();
		this.navn = navn;
		this.statusIndeks = statusIndeks;
	}
	
	public void setNavn(String navn) {
		this.navn = navn;
	}
	
	public String getNavn() {
		return navn;
	}
	
	public void setStatus(int statusIndeks) {
		this.statusIndeks = statusIndeks;
	}
	
	public int getStatus() {
		return statusIndeks;
	}
	
	public void leggTilHobby(Hobby hobby) {
		hobbyer.leggTil(hobby);
	}
	
	public MengdeADT<Hobby> getHobbyer(){
		return hobbyer;
	}
	
	public boolean passerTil(Medlem medlem2) {
		return hobbyer.equals(medlem2.getHobbyer());
	}
	
	public void utskrift() {
		System.out.println("Medlemsdata for " + navn + ":");
		System.out.println("Status: " + (statusIndeks == -1 ? "Single":"I et forhold"));
		System.out.println("Hobbyer: " + hobbyer.toString());
	}
}

