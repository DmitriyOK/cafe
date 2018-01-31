package ru.cafe.receipt.factory;

import ru.cafe.receipt.items.BatchUnit;
import ru.cafe.receipt.Receipt;

import java.util.List;

/**
 * Фабрика чеков.
 *
 * Создает чек для заказа клиента.
 *
 */
public class RecepitFactory {

    /**
     * Создает чек для заказа клиента.
     * Содержит наименование, стоимость и количество купленных единиц товара.
     * Содержит полную стоимость заказа.
     *
     * @param orderId
     * @param batchUnits
     * @return {@link Receipt} - чек
     */
    public Receipt getInstance(long orderId, List<BatchUnit> batchUnits){
        double totalReceiptPrice = 0.0;

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
