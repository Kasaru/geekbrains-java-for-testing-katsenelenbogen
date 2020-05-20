package ru.geekbrains.java.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruits> {
    private ArrayList<T> box;
    private Class<?> type;

    public Box(T... fruits) {
        this.type = fruits.getClass().getComponentType();
        this.box = new ArrayList<>(Arrays.asList(fruits));
    }
    float getWeight() {
        float weight = 0.0f;
        for (Fruits fruits:box) {
            weight += fruits.getWeight();
        }
        return weight;
    }
    public boolean compare(Box<?> Box2) {
        return Math.abs(this.getWeight() - Box2.getWeight()) < 0.0001;
    }

    public void pourIntoAnotherBox(Box<T> anotherBox) {
        if (this == anotherBox) {
            return;
        }
        anotherBox.box.addAll(this.box);
        box.clear();
    }
    public void add(T... fruit) {
        box.addAll(Arrays.asList(fruit));
    }

    public String toString() {
        return  "Box contains " + box.size() + " " + type.getSimpleName();
    }
}
