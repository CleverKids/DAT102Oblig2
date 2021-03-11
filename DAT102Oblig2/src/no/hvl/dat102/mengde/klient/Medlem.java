package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.adt.MengdeADT;

public class Medlem {
    private String navn;
    private MengdeADT<Hobby> hobbyer;
    private int statusIndeks = -1;

    public Medlem(String navn, Hobby hobby) {
        this.navn = navn;
        hobbyer.leggTil(hobby);
        statusIndeks++;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public MengdeADT<Hobby> getHobbyer() {
        return hobbyer;
    }

    public void setHobbyer(MengdeADT<Hobby> hobbyer) {
        this.hobbyer = hobbyer;
    }

    public int getStatusIndeks() {
        return statusIndeks;
    }

    public void setStatusIndeks(int statusIndeks) {
        this.statusIndeks = statusIndeks;
    }

    public boolean passerTilMedlem(Medlem medlem2){
        return medlem2.getHobbyer().equals(hobbyer);
    }

    public static void main(String[] args) {
    }
}
