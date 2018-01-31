package ru.cafe.receipt.factory;

import ru.cafe.receipt.items.AdditionItem;
import ru.cafe.receipt.items.BatchUnit;
import ru.cafe.receipt.items.Item;
import ru.cafe.receipt.Receipt;

import java.util.List;

public class RecepitFactory {


    public Receipt getInstance(long orderId, List<BatchUnit> batchUnits){
        double totalReceiptPrice=0.0;

        for (BatchUnit batchUnit : batchUnits) {
            totalReceiptPrice += batchUnit.getDrinkItem().getPrice();
            totalReceiptPrice += batchUnit.getAdditionItems()
                                           .stream()
                                           .mapToDouble(additionItem -> additionItem.getCount() * additionItem.getPrice())
                                           .sum();
        }
        return new Receipt(orderId, batchUnits, totalReceiptPrice);
    }
}
