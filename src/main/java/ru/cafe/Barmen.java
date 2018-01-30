package ru.cafe;

import ru.cafe.additions.Addition;
import ru.cafe.additions.sweet.SweetAddition;
import ru.cafe.drinks.Drink;
import ru.cafe.order.Order;
import ru.cafe.validator.Validatior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Barmen {

    private Validatior validatior;
    private Menu menu;
    private volatile int orderId = 0;
    private final static String TRIPLE_POSITION_PATTERN = "%s. %s, стоимость: %s";

    public Barmen(Validatior validatior, Menu menu) {
        this.validatior = validatior;
        this.menu = menu;
    }

    public Order takeOrder() throws IOException {
        int currentOrderId;
        Set<Drink> result = new HashSet<Drink>();
        synchronized (this) {
            currentOrderId = orderId++;
        }

        Drink selectedDrink = takeDrinkOrder();
        selectedDrink.setBathSize(selectDrinkBatchSize());
        selectedDrink.setDrinkAdditions(takeAdditionOrder(menu.getMilkAdditions()))
                .setDrinkAdditions(takeAdditionOrder(menu.getSweetAdditions()))
                .setDrinkAdditions(takeAdditionOrder(menu.getOtherAdditions()));
        result.add(selectedDrink);
        return new Order(currentOrderId, result);
    }


    private Drink takeDrinkOrder() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        List<Drink> drinks = menu.getDrinks();
        System.out.println("Выберите напиток: ");
        for (int drinkPosition = 0; drinkPosition < drinks.size(); drinkPosition++) {
            Drink drink = drinks.get(drinkPosition);
            System.out.println(String.format(TRIPLE_POSITION_PATTERN, drinkPosition, drink.getName(), drink.getPrice()));
        }
        int selectedDrink = Integer.parseInt(clientChoiceReader.readLine());
        return menu.getDrinks().get(selectedDrink);
    }

    private int selectDrinkBatchSize() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        int drinkBatchSize;
        System.out.println("Выберите объем напитка, мг");
        printAvailableDrinkBatchSize();
        while (!validatior.validateDrinkBatchSize(drinkBatchSize = Integer.parseInt(clientChoiceReader.readLine()))) {
            System.out.println("Выберите объем из предложенных вариантов: ");
            printAvailableDrinkBatchSize();
        }
        return drinkBatchSize;
    }


    private void printAvailableDrinkBatchSize() {
        List<Integer> availableDrinksBatchSize = validatior.getAvailableDrinksBatchSize();
        for (int batchSizePosition = 0; batchSizePosition < availableDrinksBatchSize.size(); batchSizePosition++) {
            Integer batchSizeValue = availableDrinksBatchSize.get(batchSizePosition);
            System.out.println(String.format("%s. %s", batchSizePosition, batchSizeValue));
        }
    }

    private Map<Addition, Integer> takeAdditionOrder(List<? extends Addition> additions) throws IOException {
        Map<Addition, Integer> result = new HashMap<Addition, Integer>();
        int selectedAdditionId = showAdditionMenu(additions);
        int additionCount = 1; //количество порций дополнения (сахар, мёд: 1-10; сливки, молоко, лимон: 1)
        if (selectedAdditionId == -1) {
            return result;
        }
        if (additions.get(selectedAdditionId) instanceof SweetAddition) {
            additionCount = showSweetAdditionCount();
        }
        result.put(additions.get(selectedAdditionId), additionCount);
        return result;
    }

    private int showAdditionMenu(List<? extends Addition> additions) throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите дополнение к напитку");
        System.out.println("Если добавка не нужна, введите -1");
        for (int additionPosition = 0; additionPosition < additions.size(); additionPosition++) {
            Addition addition = additions.get(additionPosition);
            System.out.println(String.format(TRIPLE_POSITION_PATTERN, additionPosition, addition.getName(), addition.getPricePerUnit()));
        }
        return Integer.parseInt(clientChoiceReader.readLine());
    }

    private int showSweetAdditionCount() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        int sugarLevel;
        System.out.println("Выберите уровень сахара от 1 до 10");
        while (!validatior.validateSugarBatchSize(sugarLevel = Integer.parseInt(clientChoiceReader.readLine()))) {
            System.out.println("Недопустимый уровень. Выберите уровень сахара от 1 до 10");
        }
        return sugarLevel;
    }
}
