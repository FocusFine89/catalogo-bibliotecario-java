package NikitaIvanov.entities;

public class Riviste extends Biblioteca {
    //Attributi
    protected String periodicita;


    //Costruttori
    public Riviste(String isbn, String titolo, String autore, int annoPubblicazione, int pagine, String periodicita) {
        super(isbn, titolo, autore, annoPubblicazione, pagine);

        this.periodicita = periodicita;
    }
    //Metodi

    public String getPeriodicita() {
        return periodicita;
    }


    @Override
    public String toString() {
        return "Riviste{" +
                "periodicita='" + periodicita + '\'' +
                ", autore='" + autore + '\'' +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", pagine=" + pagine +
                '}';
    }
}
