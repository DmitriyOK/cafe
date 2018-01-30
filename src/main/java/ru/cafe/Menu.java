package ru.cafe;

import ru.cafe.additions.milks.Milk;
import ru.cafe.additions.milks.MilkAddition;
import ru.cafe.additions.milks.MilkCream;
import ru.cafe.additions.other.LemonSlice;
import ru.cafe.additions.other.OtherAddition;
import ru.cafe.additions.sweet.Mead;
import ru.cafe.additions.sweet.Sugar;
import ru.cafe.additions.sweet.SweetAddition;
import ru.cafe.drinks.coffee.BlackСoffee;
import ru.cafe.drinks.coffee.Coffee;
import ru.cafe.drinks.coffee.Espresso;
import ru.cafe.drinks.coffee.Latte;
import ru.cafe.drinks.tea.BlackTea;
import ru.cafe.drinks.tea.GreenTea;
import ru.cafe.drinks.tea.Tea;
import ru.cafe.drinks.tea.WhiteTea;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Menu {

    private Map<Integer, Tea> teas;
    private Map<Integer, Coffee> coffees;
    private Map<Integer, SweetAddition> sweetAdditions;
    private Map<Integer, MilkAddition>  milkAdditions;
    private Map<Integer, OtherAddition> otherAdditions;

    public Menu() {
        createTeaMenu();
        createCoffeeMenu();
        createMilkAdditionsMenu();
        createSweetAdditionsMenu();
        createOtherAdditionsMenu();
    }

    private void createTeaMenu(){
        teas = new LinkedHashMap<Integer, Tea>();
        WhiteTea whiteTea = new WhiteTea(55.0);
        GreenTea greenTea = new GreenTea(50.0);
        BlackTea blackTea = new BlackTea(60.0);
        teas.put(1, whiteTea);
        teas.put(2, greenTea);
        teas.put(3, blackTea);
    }

    private void createCoffeeMenu(){
        coffees = new LinkedHashMap<Integer, Coffee>();
        Espresso espresso = new Espresso(120.0);
        BlackСoffee blackСoffee = new BlackСoffee(100.0);
        Latte latte = new Latte(150.0);
        coffees.put(1, blackСoffee);
        coffees.put(2, latte);
        coffees.put(3, espresso);
    }

    private void createMilkAdditionsMenu(){
        milkAdditions = new LinkedHashMap<Integer, MilkAddition>();
        Milk milk = new Milk(3.1,30);
        MilkCream milkCream = new MilkCream(20.0,50);
        milkAdditions.put(1, milk);
        milkAdditions.put(2, milkCream);
    }

    private void createSweetAdditionsMenu(){
        sweetAdditions = new LinkedHashMap<Integer, SweetAddition>();
        Sugar sugar = new Sugar(10);
        Mead mead = new Mead(20);
        sweetAdditions.put(1, sugar);
        sweetAdditions.put(2, mead);
    }

    private void createOtherAdditionsMenu(){
        otherAdditions = new LinkedHashMap<Integer, OtherAddition>();
        LemonSlice lemonSlice = new LemonSlice(30.0);
        otherAdditions.put(1, lemonSlice);
    }

    public Map<Integer, Tea> getTeas() {
        return teas;
    }

    public Map<Integer, Coffee> getCoffees() {
        return coffees;
    }

    public Map<Integer, SweetAddition> getSweetAdditions() {
        return sweetAdditions;
    }

    public Map<Integer, MilkAddition> getMilkAdditions() {
        return milkAdditions;
    }

    public Map<Integer, OtherAddition> getOtherAdditions() {
        return otherAdditions;
    }
}
