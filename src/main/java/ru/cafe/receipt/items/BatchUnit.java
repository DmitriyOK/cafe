package ru.cafe.receipt.items;

import java.util.List;

/**
 * Сущность Позиция. Агрегатор DTO объектов напитка и его дополнений.
 * Необходима для упрощения передачи информации о заказе в Printer для печати чека.
 */
public class BatchUnit { //возможно не самое удачное название.

    private DrinkItem drinkItem;
    private List<AdditionItem> additionItems;

    public BatchUnit(DrinkItem drinkItem, List<AdditionItem> additionItems) {
        this.drinkItem = drinkItem;
        this.additionItems = additionItems;
    }

    public DrinkItem getDrinkItem() {
        return drinkItem;
    }

    public List<AdditionItem> getAdditionItems() {
        return additionItems;
    }
}
