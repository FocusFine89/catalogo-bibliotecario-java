package NikitaIvanov.entities;

import java.util.Date;

public class Riviste extends Biblioteca {
    //Attributi
    protected String periodicita;

    ;

    //Costruttori
    public Riviste(String isbn, String titolo, Date annoPubblicazione, int pagine, String periodicity) {
        super(isbn, titolo, annoPubblicazione, pagine);
        this.periodicita = periodicita;
    }
    //Metodi

    public String getPeriodicita() {
        return periodicita;
    }
}
