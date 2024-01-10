import java.sql.SQLOutput;

public class Pojazd {
    private String numerDowoduRejestracyjnego;
    private String numerRejestracyjny;
    private String marka;
    private String typ;
    private String model;
    private int rokProdukcji;
    private String kategoria;
    private long przebieg;

    public Pojazd (String numerDowoduRejestracyjnego, String numerRejestracyjny, String marka, String typ, String model,
                   int rokProdukcji, String kategoria, long przebieg)
    {
        this.numerDowoduRejestracyjnego = numerDowoduRejestracyjnego;
        this.numerRejestracyjny = numerRejestracyjny;
        this.marka = marka;
        this.typ = typ;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.kategoria = kategoria;
        this.przebieg = przebieg;
    }
    public String getNumerDowoduRejestracyjnego()
    {
        return numerDowoduRejestracyjnego;
    }
    public String getNumerRejestracyjny()
    {
        return numerRejestracyjny;
    }
    public String getMarka()
    {
        return marka;
    }
    public String getTyp()
    {
        return typ;
    }
    public String getModel()
    {
        return model;
    }
    public int getRokProdukcji()
    {
        return rokProdukcji;
    }
    public String getKategoria()
    {
        return kategoria;

    }
    public long getPrzebieg() {
        return przebieg;
    }

    public void setNumerDowoduRejestracyjnego(String numerDowoduRejestracyjnego)
    {
        this.numerDowoduRejestracyjnego = numerDowoduRejestracyjnego;
    }

    public void setNumerRejestracyjny(String numerRejestracyjny)
    {
        this.numerRejestracyjny = numerRejestracyjny;
    }

    public void setMarka(String marka)
    {
        this.marka = marka;
    }

    public void setTyp(String typ)
    {
        this.typ = typ;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public void setRokProdukcji(int rokProdukcji)
    {
        this.rokProdukcji = rokProdukcji;
    }

    public void setKategoria(String kategoria)
    {
        this.kategoria = kategoria;
    }

    public void setPrzebieg(long przebieg) {
        this.przebieg = przebieg;
    }

//    public void drukuj()
//    {
//       System.out.println("DANE POJAZDU: ");
//        System.out.println("1. Numer dowodu rejestracyjnego: " + numerDowoduRejestracyjnego);
//        System.out.println("2. Numer rejestracyjny: " + numerRejestracyjny);
//        System.out.println("3. Marka: " + marka);
//        System.out.println("4. Typ: " + typ);
//        System.out.println("5. Model: " + model);
//        System.out.println("6. Rok produkcji: " + rokProdukcji);
//        System.out.println("7. Kategoria: " + kategoria);
//        System.out.println();
//    }

    @Override
    public String toString()
    {
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
