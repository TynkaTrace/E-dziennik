package com.company;

public class Nauczyciel {
    public String imie;
    public String nazwisko;
    public int identyfikator;
    public String haslo;

    public Nauczyciel (String imie, String nazwisko, int identyfikator, String haslo){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.identyfikator=identyfikator;
        this.haslo=haslo;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public int getIdentyfikator() {
        return identyfikator;
    }

    public void setIdentyfikator(int identyfikator) {
        this.identyfikator = identyfikator;
    }

    public String getHaslo() { return haslo; }

    public void setHaslo(String haslo) { this.haslo = haslo; }
}
