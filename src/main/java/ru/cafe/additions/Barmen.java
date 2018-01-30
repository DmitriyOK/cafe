package ru.cafe.additions;

import ru.cafe.Menu;
import ru.cafe.drinks.Drink;
import ru.cafe.drinks.coffee.Espresso;
import ru.cafe.validator.Validatior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Barmen {

    Validatior validatior;
    Menu menu;

    public Barmen(Validatior validatior, Menu menu) {
        this.validatior = validatior;
        this.menu = menu;
    }

    public Drink takeDrinkOrder(){
        return new Espresso(80);
    }

    public HashMap<Addition, Integer> takeAdditionOrder(HashMap<Integer, Addition> additions) throws IOException {
        HashMap<Addition, Integer> result = new HashMap<Addition, Integer>();
        int selectedAdditionId = showAdditionMenu(additions);
        int additionCount = showAdditionCount();
        result.put(additions.get(selectedAdditionId), additionCount);
        return result;
    }

    private int showAdditionCount() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        int batchSize=0;
        while (validatior.validateSugarBatchSize(batchSize = Integer.parseInt(clientChoiceReader.readLine()))){
            System.out.println("Выберите количество добавки от 1 до 10");
            System.out.println("Если добавка не нужна, нажмите 0");
        }
        return batchSize;
    }

    private int showAdditionMenu(HashMap<Integer, Addition> additions) throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите дополнение к напитку");
        for (Map.Entry<Integer, Addition> additionEntry : additions.entrySet()) {
            Addition addition = additionEntry.getValue();
            String.format("%s: %s - %s",additionEntry.getKey(), addition.getName(),addition.getPrice());
        }
        return Integer.parseInt(clientChoiceReader.readLine());
    }

    private int showDrinksBatchSize(Drink drink) throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        int drinkBatchSize;
        while (validatior.validateDrinkBatchSize(drinkBatchSize = Integer.parseInt(clientChoiceReader.readLine()))){
            System.out.println("Выберите размер порции напитка.");
            for (Integer batchSize : validatior.getAvailableDrinksBatchSize()) {
                System.out.println(String.format("%s, %s", batchSize, drink.getMetricShortName()));
            }
        }
        return drinkBatchSize;
    }
}
