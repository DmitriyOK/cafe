package ru.cafe.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Простой валидатор пользовательского ввода размера порции напитка и
 * уровня сахара для сладких дополнений SweetAddition
 * Используется при создании барменом {@link ru.cafe.Barmen} заказа.
 */
public class Validatior {

    private List<Integer> availableDrinksBatchSize;

    public Validatior() {
        availableDrinksBatchSize = new ArrayList<Integer>();
        availableDrinksBatchSize.add(200);
        availableDrinksBatchSize.add(300);
        availableDrinksBatchSize.add(500);
    }

    public boolean validateDrinkBatchSize(int drinkBatchSizeChoice){
        return drinkBatchSizeChoice >= 0 && drinkBatchSizeChoice <= availableDrinksBatchSize.size();
    }

    /**
     * Проверяет введеный уровень сахара в диапазоне от 1 до 10
     * @param sugarBatchSize - уровень сахара.
     * @return - результат провеки
     */
    public boolean validateSugarBatchSize(int sugarBatchSize){
        return sugarBatchSize >= 0 && sugarBatchSize <= 10;
    }

    public List<Integer> getAvailableDrinksBatchSize() {
        return availableDrinksBatchSize;
    }
}
