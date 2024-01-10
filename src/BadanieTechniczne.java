import java.time.LocalDate;



public class BadanieTechniczne {
    private final int idBadania;
    private final Pojazd pojazd;
    private final LocalDate dataBadania;


    public BadanieTechniczne (int idBadania, Pojazd pojazd, LocalDate dataBadania)
    {
        this.idBadania = idBadania;
        this.pojazd = pojazd;
        this.dataBadania = dataBadania;

    }

    public Pojazd getPojazd() {
        return pojazd;
    }

    public int getIdBadania() {
        return idBadania;
    }

//  public void drukujRaport()
//    {
//        System.out.println("RAPORT Z BADANIA TECHNICZNEGO");
//        System.out.println("Id badania: " + idBadania);
//        System.out.println("Pojazd: " + pojazd);
//        System.out.println("Data badania: " + dataBadania);
//        System.out.println();
//
//    }

    @Override
    public String toString() {
        return "\nData Badania: " + dataBadania +
                "\nId badania: " + idBadania +
                "\n" +
                "\nDane pojazdu: " + pojazd;
    }
}

