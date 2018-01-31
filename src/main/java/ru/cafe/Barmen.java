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

/**
 * Основной класс программы. Принимает заказ у клиента.
 *  Достаточно вызвать метод {@link Barmen#takeOrder()} и следовать инструкциям.
 * В этом же классе определены информационные сообщения по сопровождению заказа.
 */
public class Barmen {

    private Menu menu;
    private Validatior validatior;
    private volatile int orderId = 0;
    private final static String TRIPLE_POSITION_PATTERN = "%s. %s, стоимость: %s";

    public Barmen(Validatior validatior, Menu menu) {
        this.validatior = validatior;
        this.menu = menu;
    }

    /**
     * Инициирует заказ. Создает в потоке заказ клиента и возвращает его.
     *
     * @return - заказ клиента.
     * @throws IOException
     */

    public Order takeOrder() throws IOException {
        int currentOrderId;
        List<Drink> result = new ArrayList<>();
        synchronized (this) {
            currentOrderId = ++orderId;
        }
        int drinksCount = printAndGetDrinksCount();
        if (drinksCount <=0){
            System.exit(0);
        }
        for (int i = 0; i < drinksCount; i++) {
            Drink selectedDrink = takeDrinkOrder();
            selectedDrink.setBathSize(selectDrinkBatchSize());
            selectedDrink.setDrinkAdditions(takeAdditionOrder(menu.getMilkAdditions()))
                    .setDrinkAdditions(takeAdditionOrder(menu.getSweetAdditions()))
                    .setDrinkAdditions(takeAdditionOrder(menu.getOtherAdditions()));
            result.add(selectedDrink);
        }
        return new Order(currentOrderId, result);
    }

    private Drink takeDrinkOrder() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        List<Drink> drinks = menu.getDrinks();
        int selectedDrink;

        printAvailableDrinks(drinks);
        while (!validatior.validateClientChoice(selectedDrink = Integer.parseInt(clientChoiceReader.readLine()), drinks.size())){
            printAvailableDrinks(drinks);
        }

        return menu.getDrinks().get(selectedDrink);
    }

    private List<Addition> takeAdditionOrder(List<? extends Addition> additions) throws IOException {
        List<Addition> result = new ArrayList<>();
        int selectedAdditionId = selectDrinksAddition(additions);
        if (selectedAdditionId == -1) {
            return result;
        }
        if (additions.get(selectedAdditionId) instanceof SweetAddition) {
            SweetAddition sweetAddition = (SweetAddition) additions.get(selectedAdditionId);
            sweetAddition.setSugarLevel(selectSugarLevel());
            result.add(sweetAddition);
            return result;
        }
        result.add(additions.get(selectedAdditionId));
        return result;
    }
    private int selectDrinkBatchSize() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        int drinkBatchSizeId;
        printAvailableDrinkBatchSize();
        while (!validatior.validateClientChoice(drinkBatchSizeId = Integer.parseInt(clientChoiceReader.readLine()), validatior.getAvailableDrinksBatchSize().size())) {
            printAvailableDrinkBatchSize();
        }
        return validatior.getAvailableDrinksBatchSize().get(drinkBatchSizeId); //TODO не совсем нравится, что за присваивание размера порции отвечает валидатор. Подумать как исправить.
    }

    private int selectDrinksAddition(List<? extends Addition> additions) throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        int clientChoice;
        printDrinkAdditions(additions);
        while (!validatior.validateClientChoice(clientChoice = Integer.parseInt(clientChoiceReader.readLine()), additions.size() )) {
           printDrinkAdditions(additions);
        }
        return clientChoice;
    }

    private int selectSugarLevel() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        int sugarLevel;
        printSugarMessageChoice();
        while (!validatior.validateSugarBatchSize(sugarLevel = Integer.parseInt(clientChoiceReader.readLine()))) {
            printSugarMessageChoice();
        }
        return sugarLevel;
    }

    private int printAndGetDrinksCount() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите количество напитков. Для отказа введите -1");
        return Integer.parseInt(clientChoiceReader.readLine());
    }

    private void printAvailableDrinks(List<Drink> drinks){
        System.out.println("Выберите напиток: ");
        for (int drinkPosition = 0; drinkPosition < drinks.size(); drinkPosition++) {
            Drink drink = drinks.get(drinkPosition);
            System.out.println(String.format(TRIPLE_POSITION_PATTERN, drinkPosition, drink.getName(), drink.getPrice()));
        }
    }

    private void printAvailableDrinkBatchSize() {
        System.out.println("Выберите объем напитка, мг");
        List<Integer> availableDrinksBatchSize = validatior.getAvailableDrinksBatchSize();
        for (int batchSizePosition = 0; batchSizePosition < availableDrinksBatchSize.size(); batchSizePosition++) {
            Integer batchSizeValue = availableDrinksBatchSize.get(batchSizePosition);
            System.out.println(String.format("%s. %s", batchSizePosition, batchSizeValue));
        }
    }

    private void printSugarMessageChoice(){
        System.out.println("Выберите уровень сахара от 1 до 10");
    }

    private void printDrinkAdditions(List<? extends Addition> additions){
        System.out.println("Выберите дополнение к напитку");
        System.out.println("Если добавка не нужна, введите -1");
        for (int additionPosition = 0; additionPosition < additions.size(); additionPosition++) {
            Addition addition = additions.get(additionPosition);
            System.out.println(String.format(TRIPLE_POSITION_PATTERN, additionPosition, addition.getName(), addition.getPrice()));
        }
    }
}
