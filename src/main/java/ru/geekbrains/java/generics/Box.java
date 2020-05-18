package ru.geekbrains.java.generics;

public class Box<T extends Fruits> {

    public boolean compare(Box<T> Box2) {
        return Math.abs(this.getWeight() - Box2.getWeight()) < 0.0001;
    }
}
