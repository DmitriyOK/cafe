package ru.cafe.additions;

public abstract class Addition {

    private String additionName;
    private double additionPricePerUnit;

    public Addition(String additionName, double additionPricePerUnit) {
        this.additionName = additionName;
        this.additionPricePerUnit = additionPricePerUnit;
    }

    public String getAdditionName() {
        return additionName;
    }

    public double getAdditionPricePerUnit() {
        return additionPricePerUnit;
    }

}
