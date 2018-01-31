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

public class Main {

    public static void main(String[] args) throws IOException {

        Printer printer = new PrinterImpl();
        BatchUnitFactory batchUnitFactory = new BatchUnitFactory();
        RecepitFactory recepitFactory = new RecepitFactory();
        Barmen barmen = new Barmen(new Validatior(), new Menu());

        Order order = barmen.takeOrder();
        List<BatchUnit> batchUnits = batchUnitFactory.getInstance(order);
        Receipt receipt = recepitFactory.getInstance(order.getId(), batchUnits);
        printer.print(receipt);

    }

}


