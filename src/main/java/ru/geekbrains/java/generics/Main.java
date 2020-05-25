package ru.geekbrains.java.generics;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Data data = new Data(Paths.get("data.csv"));
        System.out.printf("Чтение из фала data.csv:\n%s\n", data.toString());
    }







}
