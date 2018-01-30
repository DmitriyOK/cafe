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

    public Drink setDrinkAdditions(Map<Addition, Integer> drinkAdditions) {
        if (this.drinkAdditions == null){
            this.drinkAdditions = drinkAdditions;
        }
        this.drinkAdditions.putAll(drinkAdditions);
        return this;
    }

    public void setBathSize(int bathSize) {
        this.bathSize = bathSize;
    }
}
