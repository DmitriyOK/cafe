package ru.cafe.report;

import ru.cafe.additions.Addition;
import ru.cafe.additions.milks.MilkAddition;
import ru.cafe.additions.other.OtherAddition;
import ru.cafe.additions.sweet.SweetAddition;
import ru.cafe.drinks.Drink;
import ru.cafe.order.Order;

import java.util.Map;

public class Receipt implements Printer {


    public void print(Order order) {
        System.out.println("Номер вашего заказа: "+order.getId());

        for (Drink drink : order.getDrinks()) {
            StringBuilder itemName = new StringBuilder(drink.getName());
            itemName.append(" - ")
                    .append(drink.getBathSize())
                    .append(" ")
                    .append(drink.getMetricShortName())
                    .append(", ");

            for (Map.Entry<Addition, Integer> additionsEntry : drink.getDrinkAdditions().entrySet()) {
                Addition addition = additionsEntry.getKey();
                if (addition instanceof MilkAddition){
                    MilkAddition milkAddition = (MilkAddition) addition;
                    itemName.append(milkAddition.getName())
                            .append("-")
                            .append(milkAddition.getPercentFat())
                            .append("% ");
                }
                if (addition instanceof SweetAddition){
                    SweetAddition sweetAddition = (SweetAddition) addition;
                    itemName.append(sweetAddition.getName())
                            .append("-")
                            .append(sweetAddition.getSugarLevel())
                            .append(" ");
                }
                if (addition instanceof OtherAddition){
                    OtherAddition otherAddition = (OtherAddition) addition;
                    itemName.append(otherAddition.getName())
                            .append(" ");
                }
            }
            itemName.trimToSize();
            System.out.println(itemName.toString());
        }
    }
}
