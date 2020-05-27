package ru.geekbrains.java.katsenelenbogen;

import java.util.Arrays;

public class Array {
    public static String partOfArray(int[] array){
        for (int i = array.length-1; i >=0; i--) {
            if(array[i]==4){
                if(array[array.length-1]!=4){
            return Arrays.toString(Arrays.copyOfRange(array, i+1,array.length));
                }
                else throw new RuntimeException("Цифра 4 является последним элементом массива");
            }
        }
        throw new RuntimeException("Цифра 4 не содержится в массиве");
    }

    public static boolean checkArrayForNumbers(int[] array){
    boolean b = false;
    int a=0;
        for (int i = 0; i < array.length; i++) {
            if((array[i]==1 && array[i]!=a)||(array[i]==4 && array[i]!=a)) a+=array[i];
            if(a==5){b=true; break;}
        }
        return b;
    }
}
