package ru.cafe;

import ru.cafe.additions.milks.Milk;
import ru.cafe.additions.milks.MilkAddition;
import ru.cafe.additions.milks.MilkCream;
import ru.cafe.additions.other.LemonSlice;
import ru.cafe.additions.other.OtherAddition;
import ru.cafe.additions.sweet.Mead;
import ru.cafe.additions.sweet.Sugar;
import ru.cafe.additions.sweet.SweetAddition;
import ru.cafe.drinks.Drink;
import ru.cafe.drinks.coffee.BlackСoffee;
import ru.cafe.drinks.coffee.Espresso;
import ru.cafe.drinks.coffee.Latte;
import ru.cafe.drinks.tea.BlackTea;
import ru.cafe.drinks.tea.GreenTea;
import ru.cafe.drinks.tea.WhiteTea;

import java.util.*;

public class Menu {

    private List<Drink> drinks;
    private List<SweetAddition> sweetAdditions;
    private List<MilkAddition>  milkAdditions;
    private List<OtherAddition> otherAdditions;

    public Menu() {
        createDrinkMenu();
        createMilkAdditionsMenu();
        createSweetAdditionsMenu();
        createOtherAdditionsMenu();
    }

    private void createDrinkMenu(){
        drinks = new ArrayList<Drink>();

        WhiteTea whiteTea = new WhiteTea(55.0);
        GreenTea greenTea = new GreenTea(50.0);
        BlackTea blackTea = new BlackTea(60.0);
        Espresso espresso = new Espresso(120.0);
        BlackСoffee blackСoffee = new BlackСoffee(100.0);
        Latte latte = new Latte(150.0);
        drinks.add(whiteTea);
        drinks.add(greenTea);
        drinks.add(blackTea);
        drinks.add(blackСoffee);
        drinks.add(latte);
        drinks.add(espresso);
    }

    private void createMilkAdditionsMenu(){
        milkAdditions = new ArrayList<MilkAddition>(4);
        Milk milk = new Milk(3.1,30);
        MilkCream milkCream = new MilkCream(20.0,50);
        milkAdditions.add(milk);
        milkAdditions.add(milkCream);
    }

    private void createSweetAdditionsMenu(){
        sweetAdditions =new ArrayList<SweetAddition>(4);
        Sugar sugar = new Sugar(10);
        Mead mead = new Mead(20);
        sweetAdditions.add(sugar);
        sweetAdditions.add(mead);
    }

    private void createOtherAdditionsMenu(){
        otherAdditions = new ArrayList<OtherAddition>(2);
        LemonSlice lemonSlice = new LemonSlice(30.0);
        otherAdditions.add(lemonSlice);
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<SweetAddition> getSweetAdditions() {
        return sweetAdditions;
    }

    public List<MilkAddition> getMilkAdditions() {
        return milkAdditions;
    }

    public List<OtherAddition> getOtherAdditions() {
        return otherAdditions;
    }
}
