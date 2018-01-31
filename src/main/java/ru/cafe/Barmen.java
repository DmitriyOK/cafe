package ru.cafe;

import ru.cafe.additions.Addition;
import ru.cafe.additions.sweet.SweetAddition;
import ru.cafe.drinks.Drink;
import ru.cafe.order.Order;
import ru.cafe.report.Printer;
import ru.cafe.report.PrinterImpl;
import ru.cafe.validator.Validatior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Основной класс программы. Принимает заказ у клиента.
 *  Достаточно вызвать метод {@link Barmen#takeOrder()} и следовать инструкциям.
 */
public class Barmen {

    private Menu menu;
    private Validatior validatior;
    private volatile int orderId = 0;
    private Printer printer = new PrinterImpl();

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
        int drinksCount = selectDrinksCount();
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

        printer.printAvailableDrinks(drinks);
        while (!validatior.validateClientChoice(selectedDrink = Integer.parseInt(clientChoiceReader.readLine()), drinks.size())){
            printer. printAvailableDrinks(drinks);
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

    private int selectDrinksCount() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        printer.printMessageForSelectDrinksCount();
        return Integer.parseInt(clientChoiceReader.readLine());
    }

    private int selectDrinkBatchSize() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        int drinkBatchSizeId;
        List<Integer> availableDrinksBatchSize = validatior.getAvailableDrinksBatchSize();
        printer.printAvailableDrinkBatchSize(availableDrinksBatchSize);
        while (!validatior.validateClientChoice(drinkBatchSizeId = Integer.parseInt(clientChoiceReader.readLine()), availableDrinksBatchSize.size())) {
            printer.printAvailableDrinkBatchSize(availableDrinksBatchSize);
        }
        return availableDrinksBatchSize.get(drinkBatchSizeId); //TODO не совсем нравится, что за присваивание размера порции отвечает валидатор. Подумать как исправить.
    }

    private int selectDrinksAddition(List<? extends Addition> additions) throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        int clientChoice;
        printer.printDrinkAdditions(additions);
        while (!validatior.validateClientChoice(clientChoice = Integer.parseInt(clientChoiceReader.readLine()), additions.size() )) {
            printer.printDrinkAdditions(additions);
        }
        return clientChoice;
    }

    private int selectSugarLevel() throws IOException {
        BufferedReader clientChoiceReader = new BufferedReader(new InputStreamReader(System.in));
        int sugarLevel;
        printer.printSugarMessageChoice();
        while (!validatior.validateSugarBatchSize(sugarLevel = Integer.parseInt(clientChoiceReader.readLine()))) {
            printer.printSugarMessageChoice();
        }
        return sugarLevel;
    }
}
