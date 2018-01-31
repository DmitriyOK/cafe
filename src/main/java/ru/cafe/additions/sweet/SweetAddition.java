package ru.cafe.additions.sweet;

import ru.cafe.additions.Addition;

public abstract class SweetAddition extends Addition {

     private int sugarLevel;

    SweetAddition(String sweetAdditionName, double sweetAdditionPrice) {
        super(sweetAdditionName, sweetAdditionPrice);
    }

    public int getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(int sugarLevel) {
        this.sugarLevel = sugarLevel;
    }
}
