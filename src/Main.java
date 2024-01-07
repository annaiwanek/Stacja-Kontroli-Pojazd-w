import java.time.LocalDate;


public class Main {
    public static void main(String[] args)
    {
        System.out.println("PROJEKT ZALICZENIOWY");

        StacjaKontroliPojazdow stacjaKontroliPojazdow = new StacjaKontroliPojazdow("Stacja Kontroli Pojazdów Koszalin");

        System.out.println("Stacja Kontroli Pojazdów");
        System.out.println();




        Pojazd p1 = new Pojazd("256987", "WA6642E", "Toyota", "sedan", "Avensis",
                2008, "B");
        stacjaKontroliPojazdow.getDb().getZbiorPojazdow().getLista().add(p1);



        BadanieTechniczne r1 = new BadanieTechniczne("B23", p1, LocalDate.parse("2023-12-03"),
                "Przegląd zaliczony" );

        r1.drukujRaport();




        Pojazd p2 = new Pojazd("125698","WA6842E", "Toyota", "sedan", "Avensis",
                2010, "B");
        stacjaKontroliPojazdow.getDb().getZbiorPojazdow().getLista().add(p2);

        stacjaKontroliPojazdow.getDb().getZbiorPojazdow().drukujWszystkie();

    }
}