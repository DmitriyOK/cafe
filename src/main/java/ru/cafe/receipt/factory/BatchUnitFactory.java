package ru.cafe.receipt.factory;

import ru.cafe.additions.Addition;
import ru.cafe.additions.milks.Milk;
import ru.cafe.additions.milks.MilkAddition;
import ru.cafe.additions.sweet.SweetAddition;
import ru.cafe.drinks.Drink;
import ru.cafe.order.Order;
import ru.cafe.receipt.items.AdditionItem;
import ru.cafe.receipt.items.BatchUnit;
import ru.cafe.receipt.items.DrinkItem;

import java.util.ArrayList;
import java.util.List;

public class BatchUnitFactory {

    public List<BatchUnit> getInstance(Order order) {
        List<BatchUnit> result= new ArrayList<>();
        List<AdditionItem> additionItems;

        for (Drink drink : order.getDrinks()) {
            additionItems = new ArrayList<>();
            for (Addition addition : drink.getDrinkAdditions()) {
               additionItems.add(this.getAdditionItem(addition));
            }
            result.add(new BatchUnit(getDrinkItem(drink), additionItems));
        }
        return result;
    }

    private String getDrinkFullName(Drink drink){
        ArrayList<String> preparedNames = new ArrayList<>();

                                                                                                //Шаблон полного наименования: чай черный 200 мг с молоком 1.5% и сахаром 3.
        for (Addition addition : drink.getDrinkAdditions()) {                                   //не самый лучший код.
            String additionName = addition.getName().toLowerCase();                             //Основная проблема - присвоить верное окончание имени.
            if (additionName.equals("молоко")){                                                 //погуглить
              preparedNames.add("c молоком "+((Milk) addition).getPercentFat()+"%");                //либо пересмотреть шаблон вывода, во избежание проблем с поддержкой этого кода
            }
            if (additionName.equals("сливки")){
                preparedNames.add("cо сливками "+((MilkAddition) addition).getPercentFat()+"%");
            }
            if (additionName.equals("сахар")){
                preparedNames.add("c сахаром "+((SweetAddition) addition).getSugarLevel());
            }
            if (additionName.equals("мёд")){
                preparedNames.add("c мёдом "+((SweetAddition) addition).getSugarLevel());
            }
            if (additionName.equals("лимон")){
                preparedNames.add("c лимоном");
            }
        }
        return drink.getName()+" "+drink.getBathSize()+" "+drink.getMetricShortName()+" "+String.join(" и ", preparedNames);
    }

    private String getAdditionFullName(Addition addition){
        String additionName = addition.getName();
        if (addition instanceof MilkAddition){
            MilkAddition milkAddition = (MilkAddition) addition;
            additionName =  additionName+" "+ milkAddition.getPercentFat() + "%";
        }

        if (addition instanceof SweetAddition){
            SweetAddition sweetAddition = (SweetAddition) addition;
            additionName = String.format("%s-%s", additionName,sweetAddition.getSugarLevel());
        }
        return additionName;
    }

    private AdditionItem getAdditionItem(Addition addition){
        if (addition instanceof SweetAddition){
            SweetAddition sweetAddition = (SweetAddition) addition;
            return new AdditionItem(getAdditionFullName(addition),sweetAddition.getSugarLevel(),sweetAddition.getPrice());
        }
        return new AdditionItem(getAdditionFullName(addition),1,addition.getPrice());
    }

    private DrinkItem getDrinkItem(Drink drink){
        String shortName = drink.getName()+" "+drink.getBathSize()+" "+drink.getMetricShortName();
        return new DrinkItem(this.getDrinkFullName(drink), shortName, drink.getPrice());
    }
}
