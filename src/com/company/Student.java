package com.company;

public class Student {
    String imie;
    String nazwisko;
    int numerek;
    String haselko;

    public Student (String imie, String nazwisko, int numerek, String haselko){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.numerek=numerek;
        this.haselko=haselko;
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

    public int getNumerek() {
        return numerek;
    }

    public void setNumerek(int numerek) {
        this.numerek = numerek;
    }

    public String getHaselko() { return haselko; }

    public void setHaselko(String haselko) { this.haselko = haselko; }
}
