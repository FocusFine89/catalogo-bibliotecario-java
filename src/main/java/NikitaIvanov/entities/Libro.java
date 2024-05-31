package NikitaIvanov.entities;

import java.util.Date;

public class Libro extends Biblioteca {
    //Attributi
    protected String autore;
    protected String genere;

    //Costruttori
    public Libro(String autore, String genere, String isbn, String titolo, Date annoPubblicazione, int pagine) {
        super(isbn, titolo, annoPubblicazione, pagine);
        this.autore = autore;
        this.genere = genere;
    }
    //Metodi

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }


}
