package ru.cafe.report;

import ru.cafe.additions.Addition;
import ru.cafe.drinks.Drink;
import ru.cafe.receipt.Receipt;
import ru.cafe.receipt.items.AdditionItem;
import ru.cafe.receipt.items.BatchUnit;
import ru.cafe.receipt.items.DrinkItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class PrinterImpl implements Printer {


    public void printReceipt(Receipt receipt) {
        System.out.println("Номер вашего заказа: "+receipt.getReceiptId());
        for (BatchUnit batchUnit : receipt.getOrderedItems()) {
            DrinkItem drinkItem = batchUnit.getDrinkItem();
            System.out.println("Напиток: "+drinkItem.getFullName());
            System.out.println(drinkItem);
            for (AdditionItem additionItem : batchUnit.getAdditionItems()) {
                System.out.println(additionItem);
            }
        }
        System.out.println("Итого к оплате: "+receipt.getReceiptPrice());
    }


    public void printMessageForSelectDrinksCount() throws IOException {
        System.out.println("Выберите количество напитков. Для отказа введите -1");
    }

    public void printAvailableDrinks(List<Drink> drinks){
        System.out.println("Выберите напиток: ");
        for (int drinkPosition = 0; drinkPosition < drinks.size(); drinkPosition++) {
            Drink drink = drinks.get(drinkPosition);
            System.out.println(String.format(TRIPLE_POSITION_PATTERN, drinkPosition, drink.getName(), drink.getPrice()));
        }
    }

    public void printAvailableDrinkBatchSize(List<Integer> availableDrinksBatchSize) {
        System.out.println("Выберите объем напитка, мг");
        for (int batchSizePosition = 0; batchSizePosition < availableDrinksBatchSize.size(); batchSizePosition++) {
            Integer batchSizeValue = availableDrinksBatchSize.get(batchSizePosition);
            System.out.println(String.format("%s. %s", batchSizePosition, batchSizeValue));
        }
    }

    public void printSugarMessageChoice(){
        System.out.println("Выберите уровень сахара от 1 до 10");
    }

    public void printDrinkAdditions(List<? extends Addition> additions){
        System.out.println("Выберите дополнение к напитку");
        System.out.println("Если добавка не нужна, введите -1");
        for (int additionPosition = 0; additionPosition < additions.size(); additionPosition++) {
            Addition addition = additions.get(additionPosition);
            System.out.println(String.format(TRIPLE_POSITION_PATTERN, additionPosition, addition.getName(), addition.getPrice()));
        }
    }
}
