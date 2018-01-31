package ru.cafe.report;

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
            System.out.println(drinkItem);
            for (AdditionItem additionItem : batchUnit.getAdditionItems()) {
                System.out.println(additionItem);
            }
        }
        System.out.println("Итого к оплате: "+receipt.getReceiptPrice());
    }
}
