package com.myproject.stacja.kontroli.model;

public class SamochodDostawczy extends Pojazd{

    public SamochodDostawczy(){
        super();
        setTyp(TypPojazdu.SAMOCHOD_DOSTAWCZY);
        setKategoria(KategoriaPojazdu.B);
    }
}
