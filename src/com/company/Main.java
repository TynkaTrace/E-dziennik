package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static DB bazaDanych = new DB();

    public static void dodajOcene(){
        int waga;
        int nauczyciel;
        int student;
        String powod;
        String przedmiot;
        int identyfikator;

        System.out.println("Jaka ma byc waga oceny?");
        waga= scanner.nextInt();
        System.out.println("Jaki jest indentyfikator nauczyciela wystawiajacego?");
        nauczyciel=scanner.nextInt();
        System.out.println("Jaki jest numerek ucznia, ktoremu chcesz wystawic ocene?");
        student=scanner.nextInt();
        System.out.println("Jaki jest powod wstawianej oceny?");
        powod=scanner.next();
        System.out.println("Z jakiego przedmiotu jest wstawiana ocena?");
        przedmiot=scanner.next();
        System.out.println("Jaki ma być indentyfikator oceny?");
        identyfikator=scanner.nextInt();

        bazaDanych.listaOcen.add(new Ocena(waga, nauczyciel, student, powod, przedmiot, identyfikator));
    }

    public static void wyswietlWszystkieOceny(){
        if (bazaDanych.listaOcen.isEmpty()){
            System.out.println("Brak ocen do wyswietlenia.");
        }
        else{
            for (int i=0; i<bazaDanych.listaOcen.size(); i++){
                System.out.println(bazaDanych.listaOcen.get(i));
            }
        }
    }

    public static void dodajNauczyciela(){
        String imie;
        String nazwisko;
        int identyfikator;
        String haslo;

        System.out.println("Jakie jest imie nauczyciela?");
        imie= scanner.next();
        System.out.println("Jakie jest nazwisko nauczyciela?");
        nazwisko= scanner.next();
        System.out.println("Jaki ma być identyfikator nauczyciela?");
        identyfikator=scanner.nextInt();
        System.out.println("Jakie ma być haslo nauczyciela?");
        haslo=scanner.next();

        bazaDanych.listaNauczycieli.add(new Nauczyciel(imie, nazwisko, identyfikator, haslo));
    }

    public static void dodajStudenta(){
        String imie;
        String nazwisko;
        int numerek;
        String haselko;

        System.out.println("Jakie jest imie ucznia?");
        imie=scanner.next();
        System.out.println("Jakie jest nazwisko ucznia?");
        nazwisko=scanner.next();
        System.out.println("Jaki ma być numerek ucznia?");
        numerek=scanner.nextInt();
        System.out.println("Jakie ma byc haslo ucznia?");
        haselko=scanner.next();

        bazaDanych.listaStudentow.add(new Student(imie, nazwisko, numerek, haselko));
    }

    public static void menuDodadaniaUzytkownika(){
        System.out.println("Wybierz operacje, ktora chcesz wykonac.");
        System.out.println("1. Dodaj nauczyciela.");
        System.out.println("2. Dodaj ucznia.");

        int opcja = scanner.nextInt();

        switch (opcja){
            case 1:
                dodajNauczyciela();
                break;
            case 2:
                dodajStudenta();
                break;
            default:
                System.out.println("Brak podanej operacji!");
                break;
        }
    }

    public static void wyswietlSrednieUczniow(){
        if (bazaDanych.listaOcen.isEmpty()){
            System.out.println("Brak ocen do wyswietlenia.");
        }
        else{
            double suma=0;
            double ilosc=0;
            for(Ocena ocena: bazaDanych.listaOcen){
                if (ocena.getStudent()==13){
                    suma+=ocena.getWaga();
                    ilosc++;
                }
            }
            System.out.println("Srednia ucznia 13 to "+suma/ilosc);
        }
    }

    public static void menuLogowaniaUcznia(){
        String haslo;
        System.out.println("Wprowadz haslo.");

        haslo=scanner.next();

        for (Student student: bazaDanych.listaStudentow){
            if(student.getHaselko().equals(haslo)){
                menuUcznia();
            }
            else{
                int wybor;
                wybor=scanner.nextInt();
                System.out.println("Bledne haslo!");
                System.out.println("Wybierz kolejna akcje:");
                System.out.println("1. Sproboj ponownie.");
                System.out.println("2. Wroc do menu głównego.");

                switch(wybor){
                    case 1:
                        menuLogowaniaUcznia();
                        break;
                    case 2:
                        menuLogowania();
                        break;
                    default:
                        System.out.println("Brak operacji!");
                        menuLogowania();
                        break;
                }
            }
        }
    }

    public static void menuLogowaniaNauczyciela(){
        System.out.println("Wprowadz haslo.");

        String haslo;
        haslo=scanner.next();

        for (Nauczyciel nauczyciel: bazaDanych.listaNauczycieli){
            if(nauczyciel.getHaslo().equals(haslo)){
                menuNauczyciela();
            }
            else{
                int wybor;
                wybor=scanner.nextInt();
                System.out.println("Bledne haslo!");
                System.out.println("Wybierz kolejna akcje:");
                System.out.println("1. Sproboj ponownie.");
                System.out.println("2. Wroc do menu głównego.");

                switch(wybor){
                    case 1:
                        menuLogowaniaNauczyciela();
                        break;
                    case 2:
                        menuLogowania();
                        break;
                    default:
                        System.out.println("Brak operacji!");
                        menuLogowania();
                        break;
                }
            }
        }
    }

    public static void menuLogowania(){
        System.out.println("Wybierz operacje, ktora chcesz wykonac.");
        System.out.println("1. Zaloguj sie na konto ucznia.");
        System.out.println("2. Zaloguj sie na konto nauczyciela.");
        System.out.println("3. Zamknij E-dziennik");

        int wybor=scanner.nextInt();

        switch (wybor){
            case 1:
                menuLogowaniaUcznia();
                break;
            case 2:
                menuLogowaniaNauczyciela();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("Brak podanej operacji!");
                menuLogowania();
                break;
        }

    }

    public static void menuNauczyciela(){
        System.out.println("Wybierz operacje, ktora chcesz wykonac.");
        System.out.println("1. Dodaj ocene.");
        System.out.println("2. Wyswietl oceny.");
        System.out.println("3. Wyswietl srednie uczniow.");
        System.out.println("4. Dodaj użytkownika.");
        System.out.println("5. Wyloguj sie.");

        int wybor = scanner.nextInt();

        switch (wybor){
            case 1:
                dodajOcene();
                menuNauczyciela();
                break;
            case 2:
                wyswietlWszystkieOceny();
                menuNauczyciela();
                break;
            case 3:
                wyswietlSrednieUczniow();
                menuNauczyciela();
                break;
            case 4:
                menuDodadaniaUzytkownika();
                menuNauczyciela();
                break;
            case 5:
                menuLogowania();
                break;
            default:
                System.out.println("Brak podanej operacji!");
                menuNauczyciela();
                break;
        }
    }

    public static void wyswietlMojeOceny(){
        if (bazaDanych.listaOcen.isEmpty()){
            System.out.println("Brak ocen do wyswietlenia.");
        }
        else{
            for (Ocena ocena: bazaDanych.listaOcen){
                if (ocena.getStudent()==13){
                    System.out.println(ocena.getPrzedmiot() +" "+ocena.getWaga());
                }
            }
        }
    }

    public static void menuUcznia(){
        System.out.println("Wybierz operacje, ktora chcesz wykonac.");
        System.out.println("1. Wyświetl oceny.");
        System.out.println("2. Wyświetl średnią.");
        System.out.println("3. Wyloguj sie.");

        int wybor = scanner.nextInt();

        switch (wybor){
            case 1:
                wyswietlMojeOceny();
                menuUcznia();
                break;
            case 2:
                wyswietlSrednieUczniow();
                menuUcznia();
                break;
            case 3:
                menuLogowania();
                break;
            default:
                System.out.println("Brak podanej operacji!");
                menuUcznia();
                break;
        }
    }

    public static void main(String[] args) {
        bazaDanych.listaOcen.add(new Ocena(5 , 1, 13, "sprawdzian", "matematyka", 1));
        bazaDanych.listaOcen.add(new Ocena(2 , 1, 13, "sprawdzian", "matematyka", 1));
        bazaDanych.listaNauczycieli.add(new Nauczyciel("Jan", "Kowalski", 1, "plok"));
        bazaDanych.listaStudentow.add((new Student("Anna", "Nowak", 13, "1234")));

        while (true){
            menuLogowania();
        }

        /*Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz ucznia i wpisz jego indentyfikator: uczen1, uzcen2, uczen3, uczen4, uczen5.");
        String uczen = scanner.nextLine();

        System.out.println("Wybierz operację: dodaj ocene - 1, wyswietl istniejace oceny -2, wyswietl srednia - 3.");
        int operacja = scanner.nextInt();

        if (uczen =="uczen1"){
            switch (operacja){
                case 1:
                case 2:
                case 3:
                default:
                    System.out.println("Nie mozna wykonac operacji!");
                    break;
            }
        }
        else if (uczen == "uczen2"){
            switch (operacja){
                case 1:
                case 2:
                case 3:
                default:
                    System.out.println("Nie mozna wykonac operacji!");
                    break;
            }
        }
        else if (uczen == "uczen3"){
            switch (operacja){
                case 1:
                case 2:
                case 3:
                default:
                    System.out.println("Nie mozna wykonac operacji!");
                    break;
            }
        }
        else if (uczen == "uczen4"){
            switch (operacja){
                case 1:
                case 2:
                case 3:
                default:
                    System.out.println("Nie mozna wykonac operacji!");
                    break;
            }
        }
        else if (uczen == "uczen5"){
            switch (operacja){
                case 1:
                case 2:
                case 3:
                default:
                    System.out.println("Nie mozna wykonac operacji!");
                    break;
            }
        }
        else {
            System.out.println("Nie ma takiego ucznia!");
        }

        Student student= new Student();
        student.setImie("Marek");
        student.setNazwisko("Kowalski");

        List<Student> listStudent = new ArrayList<>();
        listStudent.add(student);

        Ocena ocena = new Ocena(5 , 1, 13, "sprawdzian", "matematyka", 1);*/
    }
}
