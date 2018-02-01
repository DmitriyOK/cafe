package ru.cafe.drinks;

import ru.cafe.additions.Addition;

import java.util.ArrayList;
import java.util.List;


public abstract class Drink {

    private String name;
    private double price;
    private int bathSize;
    private String metricShortName;
    private List<Addition> drinkAdditions;
    private List<Integer> availableBatchSize;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
        this.metricShortName="мг";
        this.drinkAdditions = new ArrayList<>();
        availableBatchSize = new ArrayList<>();
        availableBatchSize.add(200);
        availableBatchSize.add(300);
        availableBatchSize.add(500);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getBathSize() {
        return bathSize;
    }

    public Drink setBathSize(int bathSize) {
        this.bathSize = bathSize;
        return this;
    }

    public String getMetricShortName() {
        return metricShortName;
    }

    public List<Addition> getDrinkAdditions() {
        return drinkAdditions;
    }

    public Drink setDrinkAdditions(List<Addition> drinkAdditions) {
        this.drinkAdditions.addAll(drinkAdditions);
        return this;
    }

    public List<Integer> getAvailableBatchSize() {
        return availableBatchSize;
    }
}
