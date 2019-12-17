package com.company;

public class Nauczyciel {
    public String imie;
    public String nazwisko;
    public int identyfikator;
    public String haslo;
    String login;
    static int wolny=1;



    public static void setWolny(int wolny) {
        Nauczyciel.wolny = wolny;
    }

    public Nauczyciel (String imie, String nazwisko, String haslo, String login){
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.identyfikator=wolny;
        this.haslo=haslo;
        this.login=login;

        wolny++;
    }
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static int getWolny() {
        return wolny;
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
