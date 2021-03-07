package no.hvl.dat102.mengde.klient;

import java.util.Scanner;

public class Tekstgrensesnitt {

	public static void main(String[] args) {
		Datakontakt dk = new Datakontakt();
		setup(dk);
		Medlem[] medlemmer = dk.getMedlemstabell();
		for (int i = 0; i < dk.getAntall(); i++) {
			skrivHobbyListe(medlemmer[i]);
		}
		skrivParListe(dk);
		dk.leggTilMedlem(lesMedlem());
	}

	public static void setup(Datakontakt dk) {
		Medlem[] medlemmer = dk.getMedlemstabell();
		String[] medlemsnavn = { "Bob", "Per", "Mari", "Anna", "Kjell" };
		String[] hobbyer1 = { "Male", "Tegne" };
		String[] hobbyer2 = { "Friluft", "Ski", "Crossfit" };
		for (String e: medlemsnavn) {
			dk.leggTilMedlem(new Medlem(e));
		}
		medlemmer[0].leggTilHobby(new Hobby(hobbyer1[0]));
		medlemmer[0].leggTilHobby(new Hobby(hobbyer1[1]));
		medlemmer[2].leggTilHobby(new Hobby(hobbyer1[0]));
		medlemmer[2].leggTilHobby(new Hobby(hobbyer1[1]));
		medlemmer[1].leggTilHobby(new Hobby(hobbyer2[0]));
		medlemmer[1].leggTilHobby(new Hobby(hobbyer2[1]));
		medlemmer[1].leggTilHobby(new Hobby(hobbyer2[2]));
		medlemmer[3].leggTilHobby(new Hobby(hobbyer2[0]));
		medlemmer[3].leggTilHobby(new Hobby(hobbyer2[1]));
		medlemmer[3].leggTilHobby(new Hobby(hobbyer2[2]));
		medlemmer[4].leggTilHobby(new Hobby("Soving"));
		dk.finnPartnerFor("Bob");
		dk.finnPartnerFor("Per");
	}
	
	public static Medlem lesMedlem() {
		Scanner input = new Scanner(System.in);
		System.out.println("Oppgi navnet til nytt medlem: ");
		Medlem medlem = new Medlem(input.nextLine());
		input.close();
		return medlem;
	}

	public static void skrivHobbyListe(Medlem medlem) {
		System.out.println("Alle hobbyene til " + medlem.getNavn() + ": ");
		System.out.println(medlem.getHobbyer().toString());
		System.out.println();
	}

	public static void skrivParListe(Datakontakt arkiv) {
		int antallpar = 0;
		Medlem[] medlemmer = arkiv.getMedlemstabell();
		System.out.println("Par blant medlemmer: ");
		for (int i = 0; i < arkiv.getAntall(); i++) {
			if (medlemmer[i].getStatus() != -1 && medlemmer[i].getStatus() > i) {
				Medlem medlem1 = medlemmer[i];
				Medlem medlem2 = medlemmer[medlem1.getStatus()];
				antallpar++;
				System.out.println(medlem1.getNavn() + " og " + medlem2.getNavn());
			}
		}
		System.out.println("Antall par funnet: " + antallpar);
		System.out.println();
	}
}
