public class StacjaKontroliPojazdow {

    private String nazwaStacji;
    private BazaDanych db;
    public StacjaKontroliPojazdow(String nazwaStacji)
    {
        this.nazwaStacji = nazwaStacji;
        db = new BazaDanych();
    }
    public BazaDanych getDb(){
        return db;
    }


}
