package com.myproject.stacja.kontroli.logika;

import com.myproject.stacja.kontroli.baza.BazaDanych;
import com.myproject.stacja.kontroli.model.*;
import com.myproject.stacja.kontroli.input.DostawcaDanychWejsciowychUzytkownika;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Kontroler {
    public static final int MAX_ID = 5000;
    private final BazaDanych bazaDanych; // final, bo pole typu BazaDanych musi być zainicjalizowane, czyli musi być wpisana jakaś wartość
    private final DostawcaDanychWejsciowychUzytkownika userImput;

    public Kontroler(BazaDanych bazaDanych) { //konstruktor klasy Kontroler
        this.bazaDanych = bazaDanych; //zainicjalizowanie pola bazaDanych typu BazaDanch
        this.userImput = new DostawcaDanychWejsciowychUzytkownika(); //inicjalizacja pola userImput
    }

    public void dodajBadanie() {
        System.out.println("Dodaj nowy pojazd.");

        System.out.println();

        Pojazd pojazd = pobierzTypPojazdu();
        if (pojazd == null) {
            return; //powracanie do menu głownego, wyjscie z metody dodajBadanie
        }

        BadanieTechniczne badanieTechniczne = new BadanieTechniczne(new Random().nextInt(MAX_ID), pojazd, LocalDate.now()); //klasa Random
        bazaDanych.dodajBadanie(badanieTechniczne); //na obiekcie typu BazaDanych wykonujemy metode dodajBadanie i przekazujemy wczesniej utworzone badanieTechniczne
        System.out.println("Dodano nowe badanie!");
        System.out.println(badanieTechniczne);
    }

    public void aktualizujBadanie() {
        System.out.println("Aktualizuj badanie");
        System.out.println("Wprowadź nr tablicy rejestracyjnej: ");
        String numerRejestracyjny = userImput.wprowadzTekst();

        boolean dostepneBadania = sprawdzIwyswietlBadania(numerRejestracyjny);

        if (!dostepneBadania) {
            return;
        }

        System.out.println("Wprowadź id badania: ");
        int id = userImput.pobierzInt();

        BadanieTechniczne istniejaceBadanie = bazaDanych.znajdzBadania(numerRejestracyjny, id);

        if (istniejaceBadanie == null) {
            System.out.println("Nie znaleziono badania.");
            return;
        }

        BadanieTechniczne zaktualizowaneBadanie = aktualizujPola(istniejaceBadanie);

        bazaDanych.aktualizujBadanie(numerRejestracyjny, id, zaktualizowaneBadanie);

        System.out.println("Badanie zaktualizowano!");
    }

    public void wyszukajBadanie() {
        System.out.println("Wprowadź nr tablicy rejestracyjnej: ");
        String numerRejestracyjny = userImput.wprowadzTekst();

        System.out.println("Badania Techniczne:");
        sprawdzIwyswietlBadania(numerRejestracyjny);
    }

    public void usunBadanie() {
        System.out.println("Wprowadź nr tablicy rejestracyjnej: ");
        String numerRejestracyjny = userImput.wprowadzTekst();

        List<BadanieTechniczne> badaniaTechniczne = bazaDanych.znajdzBadania(numerRejestracyjny);
        System.out.println("Badania Techniczne" + badaniaTechniczne);

        System.out.println("Wprowadź id badania: ");
        int id = userImput.pobierzInt();

        bazaDanych.usunBadanie(numerRejestracyjny, id);
    }

    private BadanieTechniczne aktualizujPola(BadanieTechniczne aktualneBadanie) {
        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.println("Wybierz opcję: ");
            System.out.println("1. Zmień nr dowodu rejestracyjnego.");
            System.out.println("2. Zmień markę pojazdu.");
            System.out.println("3. Zmień stacja.kontroli.model pojazdu.");
            System.out.println("4. Zmień rok produkcji.");
            System.out.println("5. Zmień przebieg.");
            System.out.println("6. Zakończ aktualizację.");

            int userChoice = userImput.pobierzInt();
            Pojazd aktualnyPojazd = aktualneBadanie.getPojazd();

            switch (userChoice) {
                case 1 -> aktualnyPojazd.wypelnijNrDowodu();
                case 2 -> aktualnyPojazd.wypelnijMarkePojazdu();
                case 3 -> aktualnyPojazd.wypelnijModelPojazdu();
                case 4 -> aktualnyPojazd.wypelnijRokProdukcji();
                case 5 -> aktualnyPojazd.wypelnijPrzebieg();
                case 6 -> shouldContinue = false;
            }
        }
        return aktualneBadanie;
    }

    private boolean sprawdzIwyswietlBadania(String numerRejestracyjny) {

        List<BadanieTechniczne> badaniaTechniczne = bazaDanych.znajdzBadania(numerRejestracyjny);

        if (badaniaTechniczne.isEmpty()) {
            System.out.println("Nie znaleziono żadnych badań.");
            return false;
        } else {
            System.out.println("Badania Techniczne: ");
            for (BadanieTechniczne badanieTechniczne : badaniaTechniczne) {
                System.out.println("=================================================");
                System.out.println(badanieTechniczne);
            }
            return true;
        }
    }

    private Pojazd pobierzTypPojazdu() {
        System.out.println("Wybierz typ pojazdu: ");
        System.out.println("1. Motor.");
        System.out.println("2. Samochód osobowy.");
        System.out.println("3. Autobus.");
        System.out.println("4. Samochód dostawczy.");
        System.out.println("5. Samochód ciężarowy.");
        System.out.println("6. Ciągnik rolniczy.");
        System.out.println("7. Wyjdź.");

        int userChoice = userImput.pobierzInt();

        switch (userChoice) {
            case 1 -> {
                return new Motor().stworzPojazd();
            }
            case 2 -> {
                return new SamochodOsobowy().stworzPojazd();
            }
            case 3 -> {
                return new Autobus().stworzPojazd();
            }
            case 4 -> {
                return new SamochodDostawczy().stworzPojazd();
            }
            case 5 -> {
                return new SamochodCiezarowy().stworzPojazd();
            }
            case 6 -> {
                return new CiagnikRolniczy().stworzPojazd();
            }
            case 7 -> {
                return null;
            }
            default -> {
                System.out.println("Niepoprawny wybór. Operacja dodawania badania przerwana.");
                return null;
            }
        }
    }
}
