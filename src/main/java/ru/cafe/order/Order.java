package ru.cafe.order;

import ru.cafe.drinks.Drink;

import java.util.List;

public class Order {

    private long id;
    private boolean paid;
    private List<Drink> drinks;

    public Order(long id, List<Drink> drinks) {
        this.id = id;
        this.drinks = drinks;
    }

    public long getId() {
        return id;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}
