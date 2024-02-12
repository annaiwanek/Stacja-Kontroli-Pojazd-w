package com.myproject.stacja.kontroli.input;

import java.util.InputMismatchException;
import java.util.Scanner;

//Klasa dostarcza wymaganych danych od użytkownika (user imput provider)
//reużywalność kodu - w tej klasie będą metody, które mogą być używane w innych klasach
//klasa pomocnicza
public class DostawcaDanychWejsciowychUzytkownika {
    private Scanner scanner = new Scanner(System.in);

    /**
     * metoda, która pobiera od użytkownika int
     *
     * @return wybrana poprawna wartosc od użytkownika
     */
    public int pobierzInt() {
        boolean shouldContinue = true;
        int wybranaWartosc = 0; // ustawienie wartosci poczatkowej
        while (shouldContinue) {
            try {
                int userChoice = scanner.nextInt();
                scanner.nextLine();
                wybranaWartosc = userChoice;
                shouldContinue = false;
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawny format danych. Spróbuj ponownie.");
                scanner.nextLine();
            }
        }
        return wybranaWartosc;
    }

    public String wprowadzTekst() {
        return scanner.nextLine();
    }

    public long pobierzLong() {
        boolean shouldContinue = true;
        long wybranaWartosc = 0;
        while (shouldContinue) {
            try {
                long userChoice = scanner.nextLong();
                scanner.nextLine(); // Odczyt dodatkowego znaku nowej linii
                wybranaWartosc = userChoice;
                shouldContinue = false;
            } catch (InputMismatchException e) {
                System.out.println("Wprowadzono niepoprawny format danych. Spróbuj ponownie.");
                scanner.nextLine(); // Odczyt dodatkowego znaku nowej linii
            }
        }
        return wybranaWartosc;
    }
}



