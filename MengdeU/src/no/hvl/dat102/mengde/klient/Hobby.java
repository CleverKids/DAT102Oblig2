package no.hvl.dat102.mengde.klient;

public class Hobby {
	private String hobbyNavn;
	
	public Hobby(String hobby) {
		hobbyNavn = hobby;
	}
	
	public void setHobbyNavn(String hobbyNavn) {
		this.hobbyNavn = hobbyNavn;
	}
	
	public String getHobbyNavn() {
		return hobbyNavn;
	}
	
	public String toString() {
		return getHobbyNavn();
	}
	
	@Override
	public boolean equals(Object hobby2) {
		if (this == hobby2) {
			return true;
		}
		if (hobby2 == null) {
			return false;
		}
		if (getClass() != hobby2.getClass()) {
			return false;
		}
		
		Hobby hobbyDenAndre = (Hobby)hobby2;
		return(hobbyNavn.equals(hobbyDenAndre.getHobbyNavn()));
	}
	
	
}
