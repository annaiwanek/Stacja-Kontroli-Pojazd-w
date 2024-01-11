package model;

import java.sql.SQLOutput;

public abstract class Pojazd {
    private String numerDowoduRejestracyjnego;
    private String numerRejestracyjny;
    private String marka;
    private String model;
    private TypPojazdu typ;
    private int rokProdukcji;
    private KategoriaPojazdu kategoria;
    private long przebieg;

    public Pojazd(){
    }

    public Pojazd (String numerDowoduRejestracyjnego, String numerRejestracyjny, String marka, String model, TypPojazdu typ,
                   KategoriaPojazdu kategoria, int rokProdukcji, long przebieg)
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
    public abstract Pojazd stworzPojazd();

    // gettery
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
    public TypPojazdu getTyp()
    {
        return typ;
    }
    public String getModel()
    {
        return model;
    }
    public int getRokProdukcji(){
        return rokProdukcji;
    }
    public KategoriaPojazdu getKategoria(){
        return kategoria;
    }
    public long getPrzebieg() {
        return przebieg;
    }

    // settery
    public void setNumerDowoduRejestracyjnego(String numerDowoduRejestracyjnego){
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

    public void setTyp(TypPojazdu typ)
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

    public void setKategoria(KategoriaPojazdu kategoria)
    {
        this.kategoria = kategoria;
    }

    public void setPrzebieg(long przebieg) {
        this.przebieg = przebieg;
    }

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
