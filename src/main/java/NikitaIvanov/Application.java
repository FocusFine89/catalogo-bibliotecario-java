package NikitaIvanov;

import NikitaIvanov.entities.Biblioteca;
import NikitaIvanov.entities.Libro;
import NikitaIvanov.entities.Riviste;
import NikitaIvanov.functionalInterfaces.FileWriter;
import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] args) {


        Faker faker = new Faker();
        Scanner sc = new Scanner(System.in);
        File file = new File("src/catalogo.txt");


        String[] periodocita = {"Settimanale", "Mensile", "Semestrale"};
        Supplier<Biblioteca> libroSupplier = () -> {
            Random random = new Random();
            return new Libro(faker.book().author(), faker.book().genre(), faker.code().isbn10(), faker.book().title(), random.nextInt(1900, 2024), random.nextInt(30, 250));
        };

        Supplier<Biblioteca> rivistaSupplier = () -> {
            Random random = new Random();
            return new Riviste(faker.code().isbn10(), faker.book().title(), faker.book().author(), random.nextInt(1900, 2025), random.nextInt(20, 40), periodocita[random.nextInt(0, 2)]);
        };
        List<Biblioteca> catalogo = new ArrayList<>();

        FileWriter writefile = list -> {

            try {
                FileUtils.writeStringToFile(file, list.getLast().toString() + System.lineSeparator(), StandardCharsets.UTF_8, true);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }


        };

        boolean trigger = true;
        while (trigger) {
            System.out.println("1.Aggiungi Libro\n 2.Aggiungi Rivista\n3.Rimozione tramite ISBN\n4.Ricerca ISBN\n5.Ricerca per anno pubblicazione\n6.Ricerca per autore\n0.esci");
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
                            writefile.writeFile(catalogo);
                            System.out.println("Libro aggiungo!");
                            System.out.println("Catalogo: ");
                            for (int i = 0; i < catalogo.size(); i++) {
                                System.out.println(catalogo.get(i));
                            }
                        } else if (scelta2 == 2) {
                            try {
                                System.out.println("Autore:");
                                String autore = sc.nextLine();
                                System.out.println("Genere:");
                                String genere = sc.nextLine();
                                System.out.println("Titolo:");
                                String titolo = sc.nextLine();
                                System.out.println("Numero di Pagine:");
                                int pagine = Integer.parseInt(sc.nextLine());
                                System.out.println("Anno pubblicazione: ");
                                int anno = Integer.parseInt(sc.nextLine());
                                catalogo.add(new Libro(autore, genere, faker.code().isbn10(), titolo, anno, pagine));
                                writefile.writeFile(catalogo);
                                System.out.println("Libro aggiungo!");
                                System.out.println("Catalogo: ");
                                for (int i = 0; i < catalogo.size(); i++) {
                                    System.out.println(catalogo.get(i));
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Non puoi inserire lettere quando aggiungi il numero di Pagine, Riprova");
                            }

                        } else {
                            break;
                        }
                    }
                    break;

                case 2:
                    while (true) {
                        System.out.println("1.Aggiungere Rivista random\n 2.Aggiungere Rivista manualmente\n0.Esci");
                        int scelta2 = Integer.parseInt(sc.nextLine());
                        if (scelta2 == 1) {
                            catalogo.add(rivistaSupplier.get());
                            writefile.writeFile(catalogo);
                            System.out.println("Rivista aggiunta!");
                            System.out.println("Catalogo: ");
                            for (int i = 0; i < catalogo.size(); i++) {
                                System.out.println(catalogo.get(i));
                            }
                        } else if (scelta2 == 2) {
                            try {
                                System.out.println("Titolo:");
                                String titolo = sc.nextLine();
                                System.out.println("Autore:");
                                String autore = sc.nextLine();
                                System.out.println("Numero di Pagine:");
                                int pagine = Integer.parseInt(sc.nextLine());
                                System.out.println("Periodicità: [Settimananle, Mensile, Semestrale]");
                                String period = sc.nextLine().toLowerCase(Locale.ROOT);
                                System.out.println("Anno di pubblicazione:");
                                int anno = Integer.parseInt(sc.nextLine());
                                catalogo.add(new Riviste(faker.code().isbn10(), titolo, autore, anno, pagine, period));
                                writefile.writeFile(catalogo);
                                for (int i = 0; i < catalogo.size(); i++) {
                                    System.out.println(catalogo.get(i));
                                }
                            } catch (NumberFormatException ex) {
                                System.out.println("Non puoi inserire lettere quando aggiungi il numero di Pagine, Riprova");
                            }

                        } else {
                            break;
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < catalogo.size(); i++) {
                        System.out.println(catalogo.get(i));
                    }
                    while (true) {
                        System.out.println("Inserisci il codice ISBN del catalogo per eliminarlo: 0.Esci");
                        String deleteIsbn = sc.nextLine();
                        if (deleteIsbn == "0") {
                            break;
                        }
                        int indice = IntStream.range(0, catalogo.size())
                                .filter(i -> catalogo.get(i).getIsbn().equals(deleteIsbn))
                                .findFirst()
                                .orElse(-1);

                        if (indice != -1) {
                            catalogo.remove(indice);
                            System.out.println("Oggetto Eliminato");
                            for (int i = 0; i < catalogo.size(); i++) {
                                System.out.println(catalogo.get(i));
                            }
                        } else {
                            System.out.println("Oggetto non trovato");
                        }


                    }
                    break;
                case 4:
                    for (int i = 0; i < catalogo.size(); i++) {
                        System.out.println(catalogo.get(i));
                    }
                    while (true) {

                        System.out.println("Insersci il codice ISBN per cercare un libro o una rivista: 0.Esci");
                        String codiceIsbn = sc.nextLine();
                        if (Objects.equals(codiceIsbn, "0")) {
                            break;
                        } else {
                            int indice = IntStream.range(0, catalogo.size())
                                    .filter(i -> catalogo.get(i).getIsbn().equals(codiceIsbn))
                                    .findFirst()
                                    .orElse(-1);
                            if (indice != -1) {
                                System.out.println(catalogo.get(indice));

                            } else {
                                System.out.println("Oggetto non trovato");
                            }
                        }


                    }
                    break;
                case 5:
                    while (true) {
                        try {
                            System.out.println("Cerca per anno di pubblicazione: 0.Esci");
                            int anno = Integer.parseInt(sc.nextLine());
                            if (anno == 0) {
                                break;
                            } else {
                                int indice = IntStream.range(0, catalogo.size())
                                        .filter(i -> catalogo.get(i).getAnnoPubblicazione() == anno)
                                        .findFirst()
                                        .orElse(-1);
                                if (indice != -1) {
                                    System.out.println(catalogo.get(indice));

                                } else {
                                    System.out.println("Oggetto non trovato");
                                }
                            }
                        } catch (NumberFormatException ex) {
                            System.out.println("Inserisci una data");
                        }

                    }
                    break;
                case 6:
                    while (true) {
                        System.out.println("Cerca per autore: 0.Esci");
                        String autore = sc.nextLine();
                        if (Objects.equals(autore, "0")) {
                            break;
                        } else {
                            int indice = IntStream.range(0, catalogo.size())
                                    .filter(i -> catalogo.get(i).getAutore().equals(autore))
                                    .findFirst()
                                    .orElse(-1);
                            if (indice != -1) {
                                System.out.println(catalogo.get(indice));

                            } else {
                                System.out.println("Oggetto non trovato");
                            }
                        }
                    }
                    break;

            }
        }

    }
}
