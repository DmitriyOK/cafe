package ru.cafe.report;

import ru.cafe.additions.Addition;
import ru.cafe.drinks.Drink;
import ru.cafe.receipt.Receipt;

import java.io.IOException;
import java.util.List;

/**
 * Интерфейс Printer.
 * Используется для печати чеков, отчетов разных форм.
 * В реализации определены информационные сообщения по сопровождению заказа.
 * Каждый реализованный метод должен выводить сообщение для отказа от шага.
 */
public interface Printer {

    String TRIPLE_POSITION_PATTERN = "%s. %s, стоимость: %s";

    /**
     * Выводит доступные дополнения к напиткам.
     *
     * @param additions
     */
    void printDrinkAdditions(List<? extends Addition> additions);

    /**
     * Выводит меню напитков
     *
     * @param drinks
     */
    void printAvailableDrinks(List<Drink> drinks);

    /**
     * Выводит чек клиента на экран
     *
     * @param order - чек клиента
     */
    void printReceipt(Receipt order);

    /**
     * Выводит сообщение с предложением выбрать колличество напитков.
     *
     * @throws IOException
     */
    void printMessageForSelectDrinksCount() throws IOException;

    /**
     * Выводит доступный объем напитков.
     *
     * @param availableDrinksBatchSize
     */
    void printAvailableDrinkBatchSize(List<Integer> availableDrinksBatchSize);

    /**
     * Выводит предложение добавить сахар
     *
     */
     void printSugarMessageChoice();
}

