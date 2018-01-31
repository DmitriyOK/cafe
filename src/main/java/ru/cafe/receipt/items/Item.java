package ru.cafe.receipt.items;

public abstract class Item {

    private String fullName;
    private int count;
    private double price;

    public Item(String fullName, int count, double price) {
        this.fullName = fullName;
        this.count = count;
        this.price = price;
    }

    public String getFullName() {
        return fullName;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

}
