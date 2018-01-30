package ru.cafe.additions.sweet;

import ru.cafe.additions.Addition;

public abstract class SweetAddition extends Addition {

     private int sugarLevel;

    SweetAddition(String sweetAdditionName, double sweetAdditionPrice, int sugarLevel) {
        super(sweetAdditionName, sweetAdditionPrice);
        this.sugarLevel = sugarLevel;
    }

    public int getSugarLevel() {
        return sugarLevel;
    }
}
