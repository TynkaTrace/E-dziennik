package com.company;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    private static int zalogowanyN;
    private static int zalogowanyS;
    static DB bazaDanych = new DB();

    public static void dodajOcene() {
        int waga;
        int student;
        String powod;
        String przedmiot;


        System.out.println("Jaka ma byc waga oceny?");
        waga = scanner.nextInt();
        System.out.println("Jaki jest numerek ucznia, ktoremu chcesz wystawic ocene?");
        student = scanner.nextInt();
        System.out.println("Jaki jest powod wstawianej oceny?");
        powod = scanner.next();
        System.out.println("Z jakiego przedmiotu jest wstawiana ocena?");
        przedmiot = scanner.next();


        bazaDanych.listaOcen.add(new Ocena(waga, zalogowanyN, student, powod, przedmiot));
    }

    public static void wyswietlWszystkieOceny() {
        if (bazaDanych.listaOcen.isEmpty()) {
            System.out.println("Brak ocen do wyswietlenia.");
        } else {
            for (int i = 0; i < bazaDanych.listaOcen.size(); i++) {
                System.out.println(bazaDanych.listaOcen.get(i));
            }
        }
    }

    public static void dodajNauczyciela() {
        String imie;
        String nazwisko;
        String haslo;
        String login;

        System.out.println("Jakie jest imie nauczyciela?");
        imie = scanner.next();
        System.out.println("Jakie jest nazwisko nauczyciela?");
        nazwisko = scanner.next();
        System.out.println("Jaki ma być login nauczyciela?");
        login = scanner.next();
        System.out.println("Jakie ma być haslo nauczyciela?");
        haslo = scanner.next();

        bazaDanych.listaNauczycieli.add(new Nauczyciel(imie, nazwisko, haslo, login));
    }

    public static void dodajStudenta() {
        String imie;
        String nazwisko;
        String haselko;
        String login;

        System.out.println("Jakie jest imie ucznia?");
        imie = scanner.next();
        System.out.println("Jakie jest nazwisko ucznia?");
        nazwisko = scanner.next();
        System.out.println("Jakie ma byc haslo ucznia?");
        haselko = scanner.next();
        System.out.println("Jaki ma byc login ucznia?");
        login=scanner.next();

        bazaDanych.listaStudentow.add(new Student(imie, nazwisko, haselko, login));
    }

    public static void menuDodadaniaUzytkownika() {
        System.out.println("Wybierz operacje, ktora chcesz wykonac.");
        System.out.println("1. Dodaj nauczyciela.");
        System.out.println("2. Dodaj ucznia.");

        int opcja = scanner.nextInt();

        switch (opcja) {
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

    public static void wyswietlSredniaUcznia() {
        if (bazaDanych.listaOcen.isEmpty()) {
            System.out.println("Brak ocen do wyswietlenia.");
        } else {
            double suma = 0;
            double ilosc = 0;
            for (Ocena ocena : bazaDanych.listaOcen) {
                if (ocena.getStudent() == zalogowanyS) {
                    suma += ocena.getWaga();
                    ilosc++;
                }
            }
            System.out.println("Srednia ucznia to " + suma / ilosc);
        }
    }

    public static void wyswietlSrednieUczniow() {
        if (bazaDanych.listaOcen.isEmpty()) {
            System.out.println("Brak ocen do wyswietlenia.");
        } else {
            int i = 1;
            double suma = 0;
            double ilosc = 0;
            for (Student student : bazaDanych.listaOcen) {
                if (ocena.getStudent() == i) {
                    suma += ocena.getWaga();
                    ilosc++;
                }
                System.out.println("Srednia ucznia "+ i +" to " + suma / ilosc);
                i++;
            }
        }
    }

    public static void menuLogowaniaUcznia() {
        System.out.println("Wprowadz login");

        String login;
        login = scanner.next();

        System.out.println("Wprowadz haslo.");

        String haslo;
        haslo = scanner.next();

        for (Student student : bazaDanych.listaStudentow) {
            if (student.getLogin().equals(login)) {
                if (student.getHaselko().equals(haslo)) {
                    zalogowanyS=student.getid();
                    menuUcznia();
                    break;
                }

            }
        }

        System.out.println("Bledne haslo!");
        System.out.println("Wybierz kolejna akcje:");
        System.out.println("1. Sproboj ponownie.");
        System.out.println("2. Wroc do menu głównego.");
        int wyborek;
        wyborek = scanner.nextInt();
        switch (wyborek) {
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

    public static void menuLogowaniaNauczyciela() {
        System.out.println("Wprowadz login");

        String login;
        login = scanner.next();

        System.out.println("Wprowadz haslo.");

        String haslo;
        haslo = scanner.next();

        for (Nauczyciel nauczyciel : bazaDanych.listaNauczycieli) {
            if (nauczyciel.getLogin().equals(login)) {
                if (nauczyciel.getHaslo().equals(haslo)) {
                    zalogowanyN=nauczyciel.getIdentyfikator();
                    menuNauczyciela();
                    break;
                }

            }
        }

        System.out.println("Bledne haslo!");
        System.out.println("Wybierz kolejna akcje:");
        System.out.println("1. Sproboj ponownie.");
        System.out.println("2. Wroc do menu głównego.");
        int wyborek;
        wyborek = scanner.nextInt();
        switch (wyborek) {
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

    public static void menuLogowania() {
        System.out.println("Wybierz operacje, ktora chcesz wykonac.");
        System.out.println("1. Zaloguj sie na konto ucznia.");
        System.out.println("2. Zaloguj sie na konto nauczyciela.");
        System.out.println("3. Zamknij E-dziennik");

        int wybor = scanner.nextInt();

        switch (wybor) {
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

    public static void menuNauczyciela() {
        System.out.println("Wybierz operacje, ktora chcesz wykonac.");
        System.out.println("1. Dodaj ocene.");
        System.out.println("2. Wyswietl oceny.");
        System.out.println("3. Wyswietl srednie uczniow.");
        System.out.println("4. Dodaj użytkownika.");
        System.out.println("5. Wyloguj sie.");

        int wybor = scanner.nextInt();

        switch (wybor) {
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

    public static void wyswietlMojeOceny() {
        if (bazaDanych.listaOcen.isEmpty()) {
            System.out.println("Brak ocen do wyswietlenia.");
        } else {
            for (Ocena ocena : bazaDanych.listaOcen) {
                if (ocena.getStudent() == zalogowanyS) {
                    System.out.println(ocena.getWaga() + " " + ocena.getPrzedmiot());
                }
            }
        }
    }

    public static void menuUcznia() {
        System.out.println("Wybierz operacje, ktora chcesz wykonac.");
        System.out.println("1. Wyświetl oceny.");
        System.out.println("2. Wyświetl średnią.");
        System.out.println("3. Wyloguj sie.");

        int wybor = scanner.nextInt();

        switch (wybor) {
            case 1:
                wyswietlMojeOceny();
                menuUcznia();
                break;
            case 2:
                wyswietlSredniaUcznia();
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
        bazaDanych.listaOcen.add(new Ocena(5, 1, 1, "sprawdzian", "matematyka"));
        bazaDanych.listaOcen.add(new Ocena(5, 1, 2, "sprawdzian", "matematyka"));
        bazaDanych.listaOcen.add(new Ocena(2, 1, 3, "sprawdzian", "matematyka"));
        bazaDanych.listaOcen.add(new Ocena(6, 2, 1, "kartkówka", "fizyka"));
        bazaDanych.listaOcen.add(new Ocena(4, 2, 2, "kartkówka", "fizyka"));
        bazaDanych.listaOcen.add(new Ocena(2, 2, 3, "kartkówka", "fizyka"));
        bazaDanych.listaOcen.add(new Ocena(3, 3, 1, "odpowiedź", "chemia"));
        bazaDanych.listaOcen.add(new Ocena(4, 3, 2, "odpowiedź", "chemia"));
        bazaDanych.listaOcen.add(new Ocena(1, 3, 3, "odpowiedź", "chemia"));
        bazaDanych.listaNauczycieli.add(new Nauczyciel("Jan", "Kowalski", "plok", "nauczyciel1"));
        bazaDanych.listaNauczycieli.add(new Nauczyciel("Janin", "Kowal", "ijuh", "nauczyciel2"));
        bazaDanych.listaNauczycieli.add(new Nauczyciel("Janon", "Kowalki", "ygtf", "nauczyciel3"));
        bazaDanych.listaStudentow.add((new Student("Anna", "Nowak","123", "uczen1")));
        bazaDanych.listaStudentow.add((new Student("Jonna", "Nwak","456", "uczen2")));
        bazaDanych.listaStudentow.add((new Student("Ana", "Noak","789", "uczen3")));

        while (true) {
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

