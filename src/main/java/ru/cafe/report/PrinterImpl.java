package ru.cafe.report;

import ru.cafe.additions.Addition;
import ru.cafe.additions.milks.MilkAddition;
import ru.cafe.additions.sweet.SweetAddition;
import ru.cafe.drinks.Drink;
import ru.cafe.order.Order;
import ru.cafe.receipt.Receipt;
import ru.cafe.receipt.items.AdditionItem;
import ru.cafe.receipt.items.BatchUnit;
import ru.cafe.receipt.items.DrinkItem;

public class PrinterImpl implements Printer {


    public void print(Receipt receipt) {
        System.out.println("Номер вашего заказа: "+receipt.getReceiptId());
        for (BatchUnit batchUnit : receipt.getOrderedItems()) {
            DrinkItem drinkItem = batchUnit.getDrinkItem();
            System.out.println("Напиток: "+drinkItem.getFullName());
            System.out.println(drinkItem.getShortName() +" "+" "+drinkItem.getCount()+" "+drinkItem.getPrice());
            for (AdditionItem additionItem : batchUnit.getAdditionItems()) {
                System.out.println(additionItem.getFullName()+" "+additionItem.getCount()+" "+additionItem.getPrice());
            }
        }
        System.out.println("Итого к оплате: "+receipt.getReceiptPrice());
    }
}
