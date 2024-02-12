package com.myproject.stacja.kontroli.model;

import com.myproject.stacja.kontroli.input.DostawcaDanychWejsciowychUzytkownika;

import java.io.Serializable;
import java.time.LocalDate;

/*Serializacja to proces konwersji obiektu na strumień bajtów, co umożliwia zapisanie obiektu do pliku
lub przesłanie go przez sieć do innego systemu.
 */
public abstract class Pojazd implements Serializable {

    /*transient: Modyfikator używany w kontekście serializacji obiektów.
    Pola oznaczone jako transient są pomijane podczas serializacji obiektu, co oznacza,
    że ich wartości nie są zapisywane do strumienia bajtów podczas serializacji.
     */
    private final transient DostawcaDanychWejsciowychUzytkownika dostawcaDanych = new DostawcaDanychWejsciowychUzytkownika();
    private String numerDowoduRejestracyjnego;
    private String numerRejestracyjny;
    private String marka;
    private String model;
    private TypPojazdu typ;
    private int rokProdukcji;
    private KategoriaPojazdu kategoria;
    private long przebieg;

    /* Poniższe metody pozwalają na interaktywne wypełnianie informacji o pojeździe przez użytkownika.
    Każda z tych metod wyświetla monit, pobiera dane od użytkownika za pośrednictwem instancji
    DostawcaDanychWejsciowychUzytkownika i przypisuje te dane do odpowiednich pól w klasie.
     */

    public Pojazd stworzPojazd() {
        wypelnijNrDowodu();
        wypelnijNrRejestracyjny();
        wypelnijMarkePojazdu();
        wypelnijModelPojazdu();
        wypelnijRokProdukcji();
        wypelnijPrzebieg();

        return this;

    }

    // Metody getter i setter pozwalają na odczytywanie i ustawianie wartości pól klasy z zewnątrz.
    public void wypelnijNrDowodu() {
        System.out.println("Wprowadź numer dowodu rejestracyjnego: ");
        String numerDowoduRejestracyjnego = dostawcaDanych.wprowadzTekst();
        setNumerDowoduRejestracyjnego(numerDowoduRejestracyjnego);
    }

    public void wypelnijNrRejestracyjny() {
        System.out.println("Wprowadź numer rejestracyjny: ");
        String numerRejestracyjny = dostawcaDanych.wprowadzTekst();
        setNumerRejestracyjny(numerRejestracyjny);
    }

    public void wypelnijMarkePojazdu() {
        System.out.println("Wprowadź markę pojazdu: ");
        String marka = dostawcaDanych.wprowadzTekst();
        setMarka(marka);
    }

    public void wypelnijModelPojazdu() {
        System.out.println("Wprowadź model pojazdu: ");
        String model = dostawcaDanych.wprowadzTekst();
        setModel(model);
    }

    public void wypelnijRokProdukcji() {
        boolean poprawnyRok = false;
        do {
            System.out.println("Wprowadź rok produkcji (od 1950): ");
            int rokProdukcji = dostawcaDanych.pobierzInt();

            if (rokProdukcji >= 1950 && rokProdukcji <= LocalDate.now().getYear()) {
                setRokProdukcji(rokProdukcji);
                poprawnyRok = true;
            } else {
                System.out.println("Niepoprawny rok produkcji. Wprowadź prawidłową wartość");
            }
        } while (!poprawnyRok);
    }

    public void wypelnijPrzebieg() {
        System.out.println("Wprowadź przebieg pojazdu: ");
        long przebieg = dostawcaDanych.pobierzLong();
        setPrzebieg(przebieg);
    }

    // gettery

    public String getNumerDowoduRejestracyjnego() {
        return numerDowoduRejestracyjnego;
    }

    public String getNumerRejestracyjny() {
        return numerRejestracyjny;
    }

    public String getMarka() {
        return marka;
    }

    public TypPojazdu getTyp() {
        return typ;
    }

    public String getModel() {
        return model;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public KategoriaPojazdu getKategoria() {
        return kategoria;
    }

    public long getPrzebieg() {
        return przebieg;
    }

    // settery
    public void setNumerDowoduRejestracyjnego(String numerDowoduRejestracyjnego) {
        this.numerDowoduRejestracyjnego = numerDowoduRejestracyjnego;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny) {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setTyp(TypPojazdu typ) {
        this.typ = typ;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public void setKategoria(KategoriaPojazdu kategoria) {
        this.kategoria = kategoria;
    }

    public void setPrzebieg(long przebieg) {
        this.przebieg = przebieg;
    }

    /* @Override to adnotacja w Javie, która jest używana nad metodą, aby zaznaczyć,
    że ta metoda przesłania metodę z klasy bazowej.
     */
    @Override
      /* Nadpisana metoda toString zwraca łańcuch reprezentujący instancję Pojazd,
    zawierający wszystkie ważne informacje o pojeździe.
     */
    public String toString() {
        return
                "\na) nr dowodu rejestracyjnego: " + numerDowoduRejestracyjnego +
                        "\nb) nr tablicy rejestracyjnej: " + numerRejestracyjny +
                        "\nc) marka: " + marka +
                        "\nd) typ: " + typ +
                        "\ne) model: " + model +
                        "\nf) rok produkcji: " + rokProdukcji +
                        "\ng) kategoria: " + kategoria +
                        "\nh) przebieg: " + przebieg +
                        "\n";

    }
}
