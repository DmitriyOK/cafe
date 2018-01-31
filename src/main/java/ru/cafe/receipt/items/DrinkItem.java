package ru.cafe.receipt.items;

public class DrinkItem extends Item{
    private String shortName;

    public DrinkItem(String fullName, String shortName, double price) {
        super(fullName, 1, price);  //1 напиток по умолчанию.
        this.shortName = shortName;       //Т.к. напиток состоит из большинства объектов, то вероятность,
                                          // что его состав повторится на 100% - минимальная
    }

    public String getShortName() {
        return shortName;
    }
}
