package no.hvl.dat102.mengde.klient;

public class Datakontakt {

	private int antallMedlemmer;
	private Medlem[] medlemstabell;
	
	public Datakontakt() {
		antallMedlemmer = 0;
		medlemstabell = new Medlem[10];
	}
	
	public Medlem[] getMedlemstabell() {
		return medlemstabell;
	}
	
	public int getAntall() {
		return antallMedlemmer;
	}
	
	public void leggTilMedlem(Medlem person) {
		if(finnMedlemsIndeks(person.getNavn()) == -1) {
			if(antallMedlemmer == medlemstabell.length) {
				utvidTabell();
			}
			medlemstabell[antallMedlemmer] = person;
			antallMedlemmer++;
		}
	}

	public int finnMedlemsIndeks(String medlemsnavn) {
		int indeks = -1;
		for (int i = 0; i < antallMedlemmer; i++) {
			if (medlemstabell[i].getNavn().equals(medlemsnavn)) {
				indeks = i;
			}
		}
		return indeks;
	}

	public int finnPartnerFor(String medlemsnavn) {
		int person1Indeks = finnMedlemsIndeks(medlemsnavn);
		Medlem medlem = medlemstabell[person1Indeks];
		int i = 0;
		boolean funnet = false;
		int person2Indeks = -1;
		if(person1Indeks != -1) {
			if(medlem.getStatus() == -1) {
				while (!funnet && i < antallMedlemmer) {
					if (i != person1Indeks && medlemstabell[i].getStatus() == -1) {
						if (medlem.passerTil(medlemstabell[i])) {
							person2Indeks = i;
							funnet = true;
							medlem.setStatus(person2Indeks);
							medlemstabell[person2Indeks].setStatus(person1Indeks);
						}
					}
					i++;
				}
			}
		}
		return person2Indeks;
	}

	public void tilbakestillStausIndeks(String medlemsnavn) {
		Medlem medlem = medlemstabell[finnMedlemsIndeks(medlemsnavn)];
		if (medlem.getStatus() != -1) {
			medlemstabell[medlem.getStatus()].setStatus(-1);
			medlem.setStatus(-1);
		}
	}
	
	
	public void utvidTabell() {
		Medlem[] hjelpeTab = new Medlem[medlemstabell.length * 2];
		for (int i = 0; i < medlemstabell.length; i++) {
			hjelpeTab[i] = medlemstabell[i];
		}
		medlemstabell = hjelpeTab;
	}
}
