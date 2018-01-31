package ru.cafe;


import ru.cafe.order.Order;
import ru.cafe.report.Printer;
import ru.cafe.report.PrinterImpl;
import ru.cafe.validator.Validatior;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Printer printer = new PrinterImpl();
        Barmen barmen = new Barmen(new Validatior(), new Menu());
        Order order = barmen.takeOrder();
        printer.print(order);
    }

}


