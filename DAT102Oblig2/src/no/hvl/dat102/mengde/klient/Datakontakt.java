package no.hvl.dat102.mengde.klient;

import no.hvl.dat102.mengde.tabell.TabellMengde;

public class Datakontakt {
    Medlem[] medlemTab;
    int antall;

    public Datakontakt(int antall) {
        medlemTab = new Medlem[antall];
    }

    public int finnMedlemsIndeks(String medlemsnavn){
        int medlemsIndeks = -1;
        for(int i = 0; i < antall && medlemsIndeks == -1; i++){
            if(medlemTab[i].getNavn().equals(medlemsnavn)){
                medlemsIndeks = i;
            }
        }
        return medlemsIndeks;
    }

    public boolean leggTilMedlem(Medlem person){
        Boolean b = false;

        if(finnMedlemsIndeks(person.getNavn()) != -1){
            medlemTab[antall] = person;
            antall++;
            b = true;
        }
        return b;
    }

    public int finnPartnerFor(String medlemsnavn){
        int partnerIndeks = -1;
        int medlemIndeks = finnMedlemsIndeks(medlemsnavn);
        Medlem medlem = medlemTab[medlemIndeks];

        for(int i =  0; i < antall && partnerIndeks == -1; i++){
            Medlem partner = medlemTab[i];
            if(partner.passerTilMedlem(medlem) && i != medlemIndeks && partner.getStatusIndeks() == -1){
                partnerIndeks = i;
            }
        }
        if(partnerIndeks != -1) {
            medlem.setStatusIndeks(partnerIndeks);
            medlemTab[partnerIndeks].setStatusIndeks(medlemIndeks);
        }
        return partnerIndeks;
    }

    public void tilbakestillStausIndeks(String medlemsnavn){
        Medlem medlem = medlemTab[finnMedlemsIndeks(medlemsnavn)];
        if(medlem.getStatusIndeks() != -1){
            medlemTab[medlem.getStatusIndeks()].setStatusIndeks(-1);
            medlem.setStatusIndeks(-1);
        }
    }


}
