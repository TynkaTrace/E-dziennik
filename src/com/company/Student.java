package com.company;

public class Student {
    String imie;
    String nazwisko;
    int id;
    String haselko;
    String login;


    static int wolny = 1;

    public Student(String imie, String nazwisko, String haselko, String login) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = wolny;
        this.haselko = haselko;
        this.login = login;
        wolny++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static void setWolny(int wolny) {
        Student.wolny = wolny;
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

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getHaselko() {
        return haselko;
    }

    public void setHaselko(String haselko) {
        this.haselko = haselko;
    }
}
