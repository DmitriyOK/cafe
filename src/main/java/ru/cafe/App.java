package ru.cafe;


import ru.cafe.order.Order;
import ru.cafe.receipt.Receipt;
import ru.cafe.receipt.factory.BatchUnitFactory;
import ru.cafe.receipt.factory.RecepitFactory;
import ru.cafe.receipt.items.BatchUnit;
import ru.cafe.report.Printer;
import ru.cafe.report.PrinterImpl;
import ru.cafe.validator.Validatior;
import java.io.IOException;
import java.util.List;

/**
 * Запускающий приложение класс.
 *
 * Имена позиций указаны в конструкторах POJO-классов.
 * Цены на товар инициализируются при создании экземпляра класса {@link ru.cafe.Menu}.
 * Полные и короткие имена позиций для печати в чеке определяются в классе {@link ru.cafe.receipt.factory.BatchUnitFactory}
 * За создание чека и подсчет общей стоимости отвечает класс {@link ru.cafe.receipt.factory.RecepitFactory}
 * За печать информационных сообщений отвечает реализация интерфейса {@link ru.cafe.report.Printer}
 */

public class App {

    public static void main(String[] args) throws IOException {

        Printer printer = new PrinterImpl();
        BatchUnitFactory batchUnitFactory = new BatchUnitFactory();
        RecepitFactory recepitFactory = new RecepitFactory();
        Barmen barmen = new Barmen(new Validatior(), new Menu(), printer);

        Order order = barmen.takeOrder();
        List<BatchUnit> batchUnits = batchUnitFactory.getInstance(order);
        Receipt receipt = recepitFactory.getInstance(order.getId(), batchUnits);
        printer.printReceipt(receipt);

    }

}


