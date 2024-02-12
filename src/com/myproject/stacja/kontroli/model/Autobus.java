package com.myproject.stacja.kontroli.model;

public class Autobus extends Pojazd {

    public Autobus() {
        super(); //wywołanie konstruktora klasy nadrzędnej
        setTyp(TypPojazdu.AUTOBUS);
        setKategoria(KategoriaPojazdu.D);
    }
}
