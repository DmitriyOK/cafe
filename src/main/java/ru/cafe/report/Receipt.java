package ru.cafe.report;

import ru.cafe.additions.Addition;
import ru.cafe.additions.sweet.SweetAddition;
import ru.cafe.drinks.Drink;
import ru.cafe.order.Order;

import java.util.Map;

public class Receipt implements Printer {


    public void print(Order order) {
        System.out.println("Номер вашего заказа: "+order.getId());

        for (Drink drink : order.getDrinks()) {
            System.out.println(drink.getName());
            for (Map.Entry<Addition, Integer> additionsEntry : drink.getDrinkAdditions().entrySet()) {
                Addition addition = additionsEntry.getKey();
                System.out.println(addition.getName());
            }
        }
    }
}
