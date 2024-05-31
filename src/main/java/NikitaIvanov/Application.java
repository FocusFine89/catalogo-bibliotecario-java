package NikitaIvanov;

import NikitaIvanov.entities.Biblioteca;
import NikitaIvanov.entities.Libro;
import NikitaIvanov.entities.Riviste;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {

        Faker faker = new Faker();
        Scanner sc = new Scanner(System.in);
        String[] periodocita = {"Settimanale", "Mensile", "Semestrale"};
        Supplier<Biblioteca> libroSupplier = () -> {
            Random random = new Random();
            return new Libro(faker.book().author(), faker.book().genre(), faker.code().isbn10(), faker.book().title(), faker.date().birthday(), random.nextInt(30, 250));
        };

        Supplier<Biblioteca> rivistaSupplier = () -> {
            Random random = new Random();
            return new Riviste(faker.code().isbn10(), faker.book().title(), faker.date().birthday(), random.nextInt(20, 40), periodocita[random.nextInt(0, 2)]);
        };
        List<Biblioteca> catalogo = new ArrayList<>();

        boolean trigger = true;
        while (trigger) {
            System.out.println("1.Aggiungi Libro\n 2.Aggiungi Catalogo\n3.Rimozione tramite ISBN\n4.Ricerca ISBN\n5.Ricerca per anno pubblicazione\n6.Ricerca per autore\n0.esci");
            int scelta = Integer.parseInt(sc.nextLine());
            switch (scelta) {
                case 0:
                    trigger = false;
                    break;
                case 1:
                    while (true) {
                        System.out.println("1.Aggiungere Libro random\n 2.Aggiungere Libro manualmente\n0.Esci");
                        int scelta2 = Integer.parseInt(sc.nextLine());
                        if (scelta2 == 1) {
                            catalogo.add(libroSupplier.get());
                            System.out.println("Libro aggiungo!");
                            System.out.println("Catalogo: ");
                            for (int i = 0; i < catalogo.size(); i++) {
                                System.out.println(catalogo.get(i));
                            }
                        } else if (scelta2 == 2) {
                            System.out.println("Autore:");
                            String autore = sc.nextLine();
                            System.out.println("Genere:");
                            String genere = sc.nextLine();
                            System.out.println("Titolo:");
                            String titolo = sc.nextLine();
                            System.out.println("Numero di Pagine:");
                            int pagine = Integer.parseInt(sc.nextLine());
                            catalogo.add(new Libro(autore, genere, faker.code().isbn10(), titolo, faker.date().birthday(), pagine));
                            System.out.println("Libro aggiungo!");
                            System.out.println("Catalogo: ");
                            for (int i = 0; i < catalogo.size(); i++) {
                                System.out.println(catalogo.get(i));
                            }


                        } else {
                            break;
                        }
                    }
                    break;
                case 2:
            }
        }

    }
}
