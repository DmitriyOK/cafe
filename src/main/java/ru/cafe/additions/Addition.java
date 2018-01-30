package ru.cafe.additions;

public abstract class Addition {

    private String name;
    private double pricePerUnit;
    private double totalPrice; //TODO подумать уместна ли эта переменная здесь.

    public Addition(String name, double pricePerUnit) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
