package NikitaIvanov.entities;

public class Libro extends Biblioteca {
    //Attributi

    protected String genere;

    //Costruttori
    public Libro(String autore, String genere, String isbn, String titolo, int annoPubblicazione, int pagine) {
        super(isbn, titolo, autore, annoPubblicazione, pagine);
        this.genere = genere;
    }
    //Metodi

    public String getAutore() {
        return autore;
    }

    public String getGenere() {
        return genere;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "genere='" + genere + '\'' +
                ", isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", autore='" + autore + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", pagine=" + pagine +
                '}';
    }
}
