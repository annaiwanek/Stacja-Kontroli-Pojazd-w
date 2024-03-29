package com.myproject.stacja.kontroli.model;
import java.io.Serializable;
import java.time.LocalDate;

public class BadanieTechniczne implements Serializable {
    private final int idBadania;
    private final Pojazd pojazd;
    private final LocalDate dataBadania;

    public BadanieTechniczne(int idBadania, Pojazd pojazd, LocalDate dataBadania) {
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

    @Override
    public String toString() {
        return "\nData Badania: " + dataBadania +
                "\nId badania: " + idBadania +
                "\n" +
                "\nDane pojazdu: " + pojazd;
    }
}

