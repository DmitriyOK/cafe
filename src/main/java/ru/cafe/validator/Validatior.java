package ru.cafe.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validatior {

    private List<Integer> availableDrinksBatchSize;

    public Validatior() {
        availableDrinksBatchSize = new ArrayList<Integer>();
        availableDrinksBatchSize.add(200);
        availableDrinksBatchSize.add(300);
        availableDrinksBatchSize.add(500);
    }

    public boolean validateDrinkBatchSize(int drinkBatchSize){
        return drinkBatchSize >= 0 && drinkBatchSize <= availableDrinksBatchSize.size();
    }

    public boolean validateSugarBatchSize(int sugarBatchSize){
        return sugarBatchSize >= 0 && sugarBatchSize <= 10;
    }

    public List<Integer> getAvailableDrinksBatchSize() {
        return availableDrinksBatchSize;
    }
}
