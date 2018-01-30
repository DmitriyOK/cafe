package ru.cafe.drinks;

import ru.cafe.additions.Addition;
import java.util.Map;

public abstract class Drink {

    private String name;
    private double price;
    private int bathSize;
    private String metricShortName;
    private Map<Addition, Integer> drinkAdditions;

    public Drink(String name, double price) {
        this.name = name;
        this.price = price;
        this.metricShortName="мг";
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

    public String getMetricShortName() {
        return metricShortName;
    }

    public Map<Addition, Integer> getDrinkAdditions() {
        return drinkAdditions;
    }

    public void setDrinkAdditions(Map<Addition, Integer> drinkAdditions) {
        this.drinkAdditions = drinkAdditions;
    }

    public void setBathSize(int bathSize) {
        this.bathSize = bathSize;
    }
}
