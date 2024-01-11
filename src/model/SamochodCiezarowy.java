package model;

import java.util.Scanner;

public class SamochodCiezarowy extends Pojazd{
    Scanner scanner = new Scanner(System.in);

    public SamochodCiezarowy(){
        super();
        setTyp(TypPojazdu.SAMOCHOD_CIEZAROWY);
        setKategoria(KategoriaPojazdu.C);
    }

    public SamochodCiezarowy (String numerDowoduRejestracyjnego, String numerRejestracyjny, String marka, String model, int rokProdukcji, long przebieg) {
        super(numerDowoduRejestracyjnego, numerRejestracyjny, marka, model, TypPojazdu.SAMOCHOD_CIEZAROWY, KategoriaPojazdu.C, rokProdukcji, przebieg);
    }

    @Override
    public Pojazd stworzPojazd() {
        System.out.println("Wprowadź numer dowodu rejestracyjnego: ");
        String numerDowoduRejestracyjnego = scanner.nextLine();
        setNumerDowoduRejestracyjnego(numerDowoduRejestracyjnego);

        System.out.println("Wprowadź numer rejestracyjny: ");
        String numerRejestracyjny = scanner.nextLine();
        setNumerRejestracyjny(numerRejestracyjny);

        System.out.println("Wprowadź markę pojazdu: ");
        String marka = scanner.nextLine();
        setMarka(marka);

        System.out.println("Wprowadź model pojazdu: ");
        String model = scanner.nextLine();
        setModel(model);

        System.out.println("Wprowadź rok produkcji: ");
        int rokProdukcji = Integer.valueOf(scanner.nextLine());
        setRokProdukcji(rokProdukcji);

        System.out.println("Wprowadź przebieg pojazdu: ");
        long przebieg = scanner.nextLong();
        setPrzebieg(przebieg);

        return this;

    }
}