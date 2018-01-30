package ru.cafe.validator;

import java.util.HashSet;
import java.util.Set;

public class Validatior {

    private Set<Integer> availableDrinksBatchSize;

    public Validatior() {
        availableDrinksBatchSize = new HashSet<Integer>();
        availableDrinksBatchSize.add(200);
        availableDrinksBatchSize.add(300);
        availableDrinksBatchSize.add(500);
    }

    public boolean validateDrinkBatchSize(int drinkBatchSize){
        return availableDrinksBatchSize.contains(drinkBatchSize);
    }

    public boolean validateSugarBatchSize(int sugarBatchSize){
        return sugarBatchSize >= 0 && sugarBatchSize <= 10;
    }

    public Set<Integer> getAvailableDrinksBatchSize() {
        return availableDrinksBatchSize;
    }
}
