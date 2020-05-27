package ru.geekbrains.java.katsenelenbogen;

import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    private static int[] array = {4,1,3,1,5,6,1};
    private static int[] array1 = {1,1,1,1,1,4};
    public static void main(String[] args) {
        System.out.println(Array.partOfArray(array));
        System.out.println(Array.checkArrayForNumbers(array1));
    }
}
