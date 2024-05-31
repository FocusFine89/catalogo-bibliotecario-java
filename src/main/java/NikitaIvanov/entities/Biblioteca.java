package NikitaIvanov.entities;

public abstract class Biblioteca {
    //Attributi
    protected String isbn;
    protected String titolo;
    protected String autore;
    protected int annoPubblicazione;
    protected int pagine;

    //Costruttori
    public Biblioteca(String isbn, String titolo, String autore, int annoPubblicazione, int pagine) {
        this.isbn = isbn;
        this.titolo = titolo;
        this.autore = autore;
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

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public int getPagine() {
        return pagine;
    }

    public String getAutore() {
        return autore;
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
