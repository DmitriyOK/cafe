package ru.cafe.additions.milks;

import ru.cafe.additions.Addition;

public abstract class MilkAddition extends Addition {

    private double percentFat;

    MilkAddition(String milkAdditionName, double percentFat, double milkAdditionPrice) {
        super(milkAdditionName, milkAdditionPrice);
        this.percentFat = percentFat;
    }

    public double getPercentFat() {
        return percentFat;
    }
}
