import java.time.LocalDate;



public class BadanieTechniczne {
    private String idBadania;
    private Pojazd pojazd;
    private LocalDate dataBadania;
    private String opis;

    public BadanieTechniczne (String idBadania, Pojazd pojazd, LocalDate dataBadania, String opis)
    {
        this.idBadania = idBadania;
        this.pojazd = pojazd;
        this.dataBadania = dataBadania;
        this.opis = opis;
    }


    public void drukujRaport()
    {
        System.out.println("RAPORT Z BADANIA TECHNICZNEGO");
        System.out.println("Id badania: " + idBadania);
        System.out.println("Pojazd: " + pojazd);
        System.out.println("Data badania: " + dataBadania);
        System.out.println("Opis badania: " + opis);
        System.out.println();

    }

}

