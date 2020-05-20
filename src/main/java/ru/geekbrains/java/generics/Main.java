package ru.geekbrains.java.generics;

public class Main {
    public static void main(String[] args) {
        Box<Apples> appleBox = new Box<>(new Apples(), new Apples(), new Apples(), new Apples());
        System.out.printf("appleBox:\t%s \nweight-%s%n\n", appleBox.toString(), appleBox.getWeight());

        System.out.println("Pour");
        Box<Apples> anotherAppleBox = new Box<>(new Apples(), new Apples());
        System.out.printf("appleBox:\t%s \nweight-%s%n", appleBox.toString(), appleBox.getWeight());
        System.out.printf("anotherAppleBox:\t%s \nweight-%s%n", anotherAppleBox.toString(), anotherAppleBox.getWeight());
        System.out.println("Pour appleBox to anotherAppleBox");
        appleBox.pourIntoAnotherBox(anotherAppleBox);
        System.out.printf("appleBox:\t%s \nweight-%s%n", appleBox.toString(), appleBox.getWeight());
        System.out.printf("anotherAppleBox:\t%s \nweight-%s%n\n", anotherAppleBox.toString(), anotherAppleBox.getWeight());

        System.out.println("Add");
        Box<Oranges> orangeBox = new Box<>(new Oranges(), new Oranges());
        System.out.printf("orangeBox:\t%s \nweight-%s%n", orangeBox.toString(), orangeBox.getWeight());
        System.out.println("Add 1 orange");
        orangeBox.add(new Oranges());
        System.out.printf("orangeBox:\t%s \nweight-%s%n\n", orangeBox.toString(), orangeBox.getWeight());

        System.out.println("Compare");
        System.out.printf("orangeBox:\t%s \nweight-%s%n", orangeBox.toString(), orangeBox.getWeight());
        System.out.printf("appleBox:\t%s \nweight-%s%n", appleBox.toString(), appleBox.getWeight());
        System.out.printf("weight is equal:\t%s", appleBox.compare(orangeBox));

    }

}
