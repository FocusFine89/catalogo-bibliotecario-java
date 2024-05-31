package NikitaIvanov.entities;

import java.util.Date;

public abstract class Biblioteca {
    //Attributi
    protected String isbn;
    protected String titolo;
    protected Date annoPubblicazione;
    protected int pagine;

    //Costruttori
    public Biblioteca(String isbn, String titolo, Date annoPubblicazione, int pagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.pagine = pagine;
    }

    //Metodi


    public String getIsbn() {
        return isbn;
    }

    public String getTitolo() {
        return titolo;
    }

    public Date getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getPagine() {
        return pagine;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", pagine=" + pagine +
                '}';
    }
}
