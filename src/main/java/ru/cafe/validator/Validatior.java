package ru.cafe.validator;

import java.util.Set;

public class Validatior {

    private Set<Integer> availableDrinksBatchSize;
    private Set<Integer> availableSugarsBatchSize;

    public boolean validateDrinkBatchSize(int drinkBatchSize){
        return availableDrinksBatchSize.contains(drinkBatchSize);
    }

    public boolean validateSugarBatchSize(int sugarBatchSize){
        return availableSugarsBatchSize.contains(sugarBatchSize);
    }
}
