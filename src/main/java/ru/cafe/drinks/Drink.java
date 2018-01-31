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

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
        this.metricShortName="мг";
        this.drinkAdditions = new ArrayList<Addition>();
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

    public void setBathSize(int bathSize) {
        this.bathSize = bathSize;
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


}
