package com.company;

public class Ocena {
    public int waga;
    public int nauczyciel;
    public int student;
    public String powod;
    public String przedmiot;
    public int identyfikator;
    static int wolny=1;

    public Ocena(int waga, int nauczyciel, int student, String powod, String przedmiot) {
        this.waga = waga;
        this.nauczyciel = nauczyciel;
        this.student = student;
        this.powod = powod;
        this.przedmiot = przedmiot;
        this.identyfikator = wolny;
        wolny++;
    }

    public int getIdentyfikator() {

        return identyfikator;
    }

    public void setIdentyfikator(int identyfikator) {
        this.identyfikator = identyfikator;
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getWaga() {
        return waga;
    }

    public void setWaga(int waga) {
        this.waga = waga;
    }

    public int getNauczyciel() {
        return nauczyciel;
    }

    public void setNauczyciel(int nauczyciel) {
        this.nauczyciel = nauczyciel;
    }

    public String getPowod() {
        return powod;
    }

    public void setPowod(String powod) {
        this.powod = powod;
    }

    public String getPrzedmiot() {
        return przedmiot;
    }

    public void setPrzedmiot(String przedmiot) {
        this.przedmiot = przedmiot;
    }

    @Override
    public String toString() {
        return "Ocena{" +
                "waga=" + waga +
                ", nauczyciel=" + nauczyciel +
                ", student=" + student +
                ", powod='" + powod + '\'' +
                ", przedmiot='" + przedmiot + '\'' +
                ", identyfikator=" + identyfikator +
                '}';
    }
}
