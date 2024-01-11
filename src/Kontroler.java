import model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Kontroler {
    public static final int MAX_ID = 5000;
    private final BazaDanych bazaDanych;
    Scanner scanner = new Scanner(System.in);

    public Kontroler(BazaDanych bazaDanych) {
        this.bazaDanych = bazaDanych;
    }

    public void dodajBadanie() {
        System.out.println("Dodaj nowy pojazd.");

        System.out.println();

        Pojazd pojazd = null;

        System.out.println("Wybierz typ pojazdu: ");
        System.out.println("1. Motor.");
        System.out.println("2. Samochód osobowy.");
        System.out.println("3. Autobus.");
        System.out.println("4. Samochód dostawczy.");
        System.out.println("5. Samochód ciężarowy.");
        System.out.println("6. Ciągnik rolniczy.");
        System.out.println("7. Wyjdź.");

        int userChoice = scanner.nextInt();
        scanner.nextLine();

        switch (userChoice) {
            case 1 -> pojazd = new Motor().stworzPojazd();
            case 2 -> pojazd = new SamochodOsobowy().stworzPojazd();
            case 3 -> pojazd = new Autobus().stworzPojazd();
            case 4 -> pojazd = new SamochodDostawczy().stworzPojazd();
            case 5 -> pojazd = new SamochodCiezarowy().stworzPojazd();
            case 6 -> pojazd = new CiagnikRolniczy().stworzPojazd();
            case 7 -> {
                System.out.println("Nie wybrano pojazdu!");
                return;

            }

        }


//        System.out.println("Wprowadź numer dowodu rejestracyjnego: ");
//        String numerDowoduRejestracyjnego = scanner.nextLine();
//
//        System.out.println("Wprowadź numer rejestracyjny: ");
//        String numerRejestracyjny = scanner.nextLine();
//
//        System.out.println("Wprowadź markę pojazdu: ");
//        String marka = scanner.nextLine();
//
//        System.out.println("Wprowadź typ pojazdu: ");
//        String typ = scanner.nextLine();
//
//        System.out.println("Wprowadź model pojazdu: ");
//        String model = scanner.nextLine();
//
//        System.out.println("Wprowadź rok produkcji: ");
//        int rokProdukcji = Integer.valueOf(scanner.nextLine());
//
//        System.out.println("Wprowadź kategorię pojazdu: ");
//        String kategoria = scanner.nextLine();
//
//        System.out.println("Wprowadź przebieg pojazdu: ");
//        long przebieg = scanner.nextLong();


        //Pojazd pojazd = new Pojazd (numerDowoduRejestracyjnego, numerRejestracyjny, marka, model, typ, kategoria, rokProdukcji, przebieg)

        BadanieTechniczne badanieTechniczne = new BadanieTechniczne(new Random().nextInt(MAX_ID), pojazd, LocalDate.now());

        bazaDanych.dodajBadanie(badanieTechniczne);

        System.out.println("Dodano nowe badanie!");
        System.out.println(badanieTechniczne);

    }

    public void aktualizujBadanie() {
        System.out.println("Aktualizuj badanie");
        System.out.println("Wprowadź nr tablicy rejestracyjnej: ");
        String numerRejestracyjny = scanner.nextLine();

        List<BadanieTechniczne> badaniaTechniczne = bazaDanych.znajdzBadania(numerRejestracyjny);
        System.out.println("Badania Techniczne: ");
        System.out.println(badaniaTechniczne);

        if (badaniaTechniczne.isEmpty()) {
            System.out.println("Nie znaleziono żadnych badań.");
            return;
        }

        System.out.println("Wprowadź id badania: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        BadanieTechniczne istniejaceBadanie = bazaDanych.znajdzBadania(numerRejestracyjny, id);

        if (istniejaceBadanie == null) {
            System.out.println("Nie znaleziono badania.");
            return;
        }

        istniejaceBadanie = aktualizujPola(istniejaceBadanie);

        bazaDanych.aktualizujBadanie(numerRejestracyjny, id, istniejaceBadanie);

        System.out.println("Badanie zaktualizowano!");


    }

    public void wyszukajBadanie() {
        System.out.println("Wprowadź nr tablicy rejestracyjnej: ");
        String numerRejestracyjny = scanner.nextLine();

        List<BadanieTechniczne> badanieTechniczne = bazaDanych.znajdzBadania(numerRejestracyjny);
        System.out.println("Badania Techniczne" + badanieTechniczne);
    }

    public void usunBadanie() {
        System.out.println("Wprowadź nr tablicy rejestracyjnej: ");
        String numerRejestracyjny = scanner.nextLine();

        List<BadanieTechniczne> badanieTechniczne = bazaDanych.znajdzBadania(numerRejestracyjny);
        System.out.println("Badania Techniczne" + badanieTechniczne);

        System.out.println("Wprowadź id badania: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        bazaDanych.usunBadanie(numerRejestracyjny, id);

    }

    private BadanieTechniczne aktualizujPola(BadanieTechniczne aktualneBadanie) {
        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.println("Wybierz opcję: ");
            System.out.println("1. Zmień nr dowodu rejestracyjnego.");
            System.out.println("2. Zmień markę pojazdu.");
            //System.out.println("3. Zmień typ pojazdu.");
            System.out.println("3. Zmień model pojazdu.");
            System.out.println("4. Zmień rok produkcji.");
            //System.out.println("6. Zmień kategorię pojazdu.");
            System.out.println("5. Zmień przebieg.");
            System.out.println("6. Zakończ aktualizację.");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1 -> {
                    System.out.println("Zmień nr dowodu rejestracyjnego: ");
                    String nowyNumerDowoduRejestracyjnego = scanner.nextLine();
                    aktualneBadanie.getPojazd().setNumerDowoduRejestracyjnego(nowyNumerDowoduRejestracyjnego);
                }
                case 2 -> {
                    System.out.println("Zmień markę pojazdu: ");
                    String nowaMarka = scanner.nextLine();
                    aktualneBadanie.getPojazd().setMarka(nowaMarka);
                }
//                case 3 -> {
//                    System.out.println("Zmień typ pojazdu: ");
//                    TypPojazdu nowyTyp = TypPojazdu.valueOf(scanner.nextLine());
//                    aktualneBadanie.getPojazd().setTyp(nowyTyp);
//                }
                case 3 -> {
                    System.out.println("Zmień model pojazdu: ");
                    String nowyModel = scanner.nextLine();
                    aktualneBadanie.getPojazd().setModel(nowyModel);
                }
                case 4 -> {
                    System.out.println("Zmień rok produkcji: ");
                    int nowyRokProdukcji = Integer.valueOf(scanner.nextLine());
                    aktualneBadanie.getPojazd().setRokProdukcji(nowyRokProdukcji);
                }
//                case 6 -> {
//                    System.out.println("Zmień kategorię pojazdu: ");
//                    KategoriaPojazdu nowaKategoria = KategoriaPojazdu.valueOf(scanner.nextLine());
//                    aktualneBadanie.getPojazd().setKategoria(nowaKategoria);
//                }
                case 5 -> {
                    System.out.println("Zmień przebieg: ");
                    long nowyPrzebieg = scanner.nextLong();
                    aktualneBadanie.getPojazd().setPrzebieg(nowyPrzebieg);
                }
                case 6 -> shouldContinue = false;

            }
        }
        return aktualneBadanie;

    }


}
