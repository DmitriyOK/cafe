package ru.cafe.additions;

public abstract class Addition implements Cloneable {

    private String name;
    private double price;

    public Addition(String name, double pricePerUnit) {
        this.name = name;
        this.price = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
