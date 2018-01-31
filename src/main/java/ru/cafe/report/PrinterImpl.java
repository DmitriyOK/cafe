package ru.cafe.report;

import ru.cafe.additions.Addition;
import ru.cafe.additions.milks.MilkAddition;
import ru.cafe.additions.sweet.SweetAddition;
import ru.cafe.drinks.Drink;
import ru.cafe.order.Order;

public class PrinterImpl implements Printer {


    public void print(Order order) {
        System.out.println("Номер вашего заказа: "+order.getId());

        for (Drink drink : order.getDrinks()) {
            StringBuilder itemName = new StringBuilder(drink.getName());
            itemName.append(" - ")
                    .append(drink.getBathSize())
                    .append(" ")
                    .append(drink.getMetricShortName())
                    .append(", ");

            for (Addition addition : drink.getDrinkAdditions()) {
                itemName.append(addition.getName()).append(" ");
                if (addition instanceof MilkAddition){
                    MilkAddition milkAddition = (MilkAddition) addition;
                    itemName.append("-")
                            .append(milkAddition.getPercentFat())
                            .append("% ");
                }
                if (addition instanceof SweetAddition){
                    SweetAddition sweetAddition = (SweetAddition) addition;
                    itemName.append("-")
                            .append(sweetAddition.getSugarLevel())
                            .append(" ");
                }
            }
            System.out.println(itemName.toString());
        }
    }
}
