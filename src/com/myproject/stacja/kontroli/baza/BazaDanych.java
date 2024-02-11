package com.myproject.stacja.kontroli.baza;

import com.myproject.stacja.kontroli.model.BadanieTechniczne;

import java.io.*;
import java.util.*;

public class BazaDanych {
    public static final String PLIK_BAZA_BADAN_TECHNICZNYCH = "Baza_badań_technicznych";
    private Map<String, List<BadanieTechniczne>> badaniaTechniczne = new HashMap<>();

    public BazaDanych() {
        odczytajZPliku();
    }

    public void dodajBadanie(BadanieTechniczne badanieTechniczne) {
        String numerRejestracyjny = badanieTechniczne.getPojazd().getNumerRejestracyjny();
        List<BadanieTechniczne> badania = badaniaTechniczne.getOrDefault(numerRejestracyjny, new ArrayList<>());
        badania.add(badanieTechniczne);
        badaniaTechniczne.put(numerRejestracyjny, badania);
        zapiszDoPliku();
    }

    public List<BadanieTechniczne> znajdzBadania(String numerRejestracyjny) {
        return badaniaTechniczne.getOrDefault(numerRejestracyjny, new ArrayList<>());
    }

    public BadanieTechniczne znajdzBadania(String numerRejestracyjny, int id) {
        List<BadanieTechniczne> badania = badaniaTechniczne.getOrDefault(numerRejestracyjny, new ArrayList<>());
        for (BadanieTechniczne badanieTechniczne : badania) {
            if (badanieTechniczne.getIdBadania() == id) {
                return badanieTechniczne;
            }
        }
        return null;
    }

    public void aktualizujBadanie(String numerRejestracyjny, int id, BadanieTechniczne noweWartosciBadania) {
        usunBadanie(numerRejestracyjny, id);
        dodajBadanie(noweWartosciBadania);
        zapiszDoPliku();
    }

    public void usunBadanie(String numerRejestracyjny, int id) {
        List<BadanieTechniczne> badania = badaniaTechniczne.get(numerRejestracyjny);
        badania.removeIf(badanie -> badanie.getIdBadania() == id);
        zapiszDoPliku();
    }

    private void zapiszDoPliku() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(PLIK_BAZA_BADAN_TECHNICZNYCH);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(badaniaTechniczne);
        } catch (Exception e) {
            System.out.println("Nie udało się zapisać pliku.");
            throw new RuntimeException(e);
        }
    }

    private void odczytajZPliku() {
        try (FileInputStream fileInputStream = new FileInputStream(PLIK_BAZA_BADAN_TECHNICZNYCH);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            badaniaTechniczne = (Map<String, List<BadanieTechniczne>>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku!");
        } catch (Exception e) {
            System.out.println("Nie udało się odczytać pliku.");
            throw new RuntimeException(e);
        }
    }
}
