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

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Menu {

    private Set<Tea> teas;
    private Set<Coffee> coffees;
    private Set<SweetAddition> sweetAdditions;
    private Set<MilkAddition>  milkAdditions;
    private Set<OtherAddition> otherAdditions;

    public Menu() {
        createTeaMenu();
        createCoffeeMenu();
        createMilkAdditionsMenu();
        createSweetAdditionsMenu();
        createOtherAdditionsMenu();
    }

    private void createTeaMenu(){
        teas = new LinkedHashSet<Tea>();
        WhiteTea whiteTea = new WhiteTea(55.0);
        GreenTea greenTea = new GreenTea(50.0);
        BlackTea blackTea = new BlackTea(60.0);
        teas.add(whiteTea);
        teas.add(greenTea);
        teas.add(blackTea);
    }

    private void createCoffeeMenu(){
        coffees = new LinkedHashSet<Coffee>();
        Espresso espresso = new Espresso(120.0);
        BlackСoffee blackСoffee = new BlackСoffee(100.0);
        Latte latte = new Latte(150.0);
        coffees.add(blackСoffee);
        coffees.add(latte);
        coffees.add(espresso);
    }

    private void createMilkAdditionsMenu(){
        milkAdditions = new LinkedHashSet<MilkAddition>();
        Milk milk = new Milk(3.1,30);
        MilkCream milkCream = new MilkCream(20.0,50);
        milkAdditions.add(milk);
        milkAdditions.add(milkCream);
    }

    private void createSweetAdditionsMenu(){
        sweetAdditions = new LinkedHashSet<SweetAddition>();
        Sugar sugar = new Sugar(10);
        Mead mead = new Mead(20);
        sweetAdditions.add(sugar);
        sweetAdditions.add(mead);
    }

    private void createOtherAdditionsMenu(){
        otherAdditions = new LinkedHashSet<OtherAddition>();
        LemonSlice lemonSlice = new LemonSlice(30.0);
        otherAdditions.add(lemonSlice);
    }

    public Set<Tea> getTeas() {
        return teas;
    }

    public Set<Coffee> getCoffees() {
        return coffees;
    }

    public Set<SweetAddition> getSweetAdditions() {
        return sweetAdditions;
    }

    public Set<MilkAddition> getMilkAdditions() {
        return milkAdditions;
    }

    public Set<OtherAddition> getOtherAdditions() {
        return otherAdditions;
    }
}
