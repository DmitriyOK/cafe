package ru.cafe.additions;

public abstract class Addition implements Cloneable {

    private String name;
    private double pricePerUnit;

    public Addition(String name, double pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }
}
