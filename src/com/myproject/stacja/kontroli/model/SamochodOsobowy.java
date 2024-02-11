package com.myproject.stacja.kontroli.model;

public class SamochodOsobowy extends Pojazd {

    public SamochodOsobowy() {
        super();
        setTyp(TypPojazdu.SAMOCHOD_OSOBOWY);
        setKategoria(KategoriaPojazdu.B);
    }
}
