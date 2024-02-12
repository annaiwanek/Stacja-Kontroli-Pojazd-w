import com.myproject.stacja.kontroli.baza.BazaDanych; //ścieżka do klasy
import com.myproject.stacja.kontroli.input.DostawcaDanychWejsciowychUzytkownika;
import com.myproject.stacja.kontroli.logika.Kontroler;

public class Main {
    public static void main(String[] args) {
        DostawcaDanychWejsciowychUzytkownika userImput = new DostawcaDanychWejsciowychUzytkownika(); // stworzenie obiektu, userImput to nazwa obiektu
        System.out.println("Projekt zaliczeniowy");
        System.out.println();
        System.out.println("STACJA KONTROLI POJAZDÓW");
        System.out.println();

        BazaDanych bazaDanych = new BazaDanych(); // jeśli nie ma importu należy dać całą ścieżkę do klasy zamiast Baza danych: com.myproject.stacja.kontroli.baza.BazaDanych
        Kontroler kontroler = new Kontroler(bazaDanych); // wywołanie konstruktora z parametrem

        boolean shouldContinue = true;

        while (shouldContinue) {
            System.out.println("Wybierz opcję: ");
            System.out.println("1. Dodaj nowe badanie techniczne.");
            System.out.println("2. Aktualizuj badanie.");
            System.out.println("3. Wyszukaj badanie.");
            System.out.println("4. Usuń badanie.");
            System.out.println("5. Wyjdź.");

            int userChoice = userImput.pobierzInt(); // na obiekcie userImput wywołujemy metodę pobierzInt bez parametru

            switch (userChoice) {
                case 1 -> kontroler.dodajBadanie();
                case 2 -> kontroler.aktualizujBadanie();
                case 3 -> kontroler.wyszukajBadanie();
                case 4 -> kontroler.usunBadanie();
                case 5 -> shouldContinue = false;
                default -> System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
            }

        }
    }
}
