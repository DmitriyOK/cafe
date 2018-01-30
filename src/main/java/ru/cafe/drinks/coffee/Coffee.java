package ru.cafe.drinks.coffee;

import ru.cafe.additions.Addition;
import ru.cafe.drinks.Drink;

import java.util.Set;

public abstract class Coffee extends Drink {

    Coffee(String coffeeName, double coffeePrice) {
        super(coffeeName, coffeePrice);
    }
}
