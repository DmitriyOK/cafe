package ru.cafe.order;

import ru.cafe.drinks.Drink;

import java.util.PriorityQueue;
import java.util.Set;

public class Order {

    private long id;
    private boolean paid;
    private Set<Drink> drinks;
    private Double totalPriceOrder;

    public Order(long id, Set<Drink> drinks) {
        this.id = id;
        this.drinks = drinks;
    }

    public long getId() {
        return id;
    }

    public Set<Drink> getDrinks() {
        return drinks;
    }

    public Double getTotalPriceOrder() {

        //TODO вывести общую цену.
    return totalPriceOrder;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
