package ru.cafe.receipt.items;


/**
 * DTO класса {@link ru.cafe.additions.Addition}
 * Используется для создания Позиции {@link ru.cafe.receipt.items.BatchUnit}
 */
public class AdditionItem extends Item {

    public AdditionItem(String fullName, int count, double price) {
        super(fullName, count, price);
    }

    @Override
    public String toString() {
        return getFullName()+" "+getCount()+" "+getPrice();
    }
}
