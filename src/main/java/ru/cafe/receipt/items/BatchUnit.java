package ru.cafe.receipt.items;

import java.util.List;

public class BatchUnit {

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
