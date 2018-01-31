package ru.cafe.report;

import ru.cafe.order.Order;
import ru.cafe.receipt.Receipt;

/**
 *  Интерфейс Printer.
 *  С помощью интерфейста можно распечатать заказ и его стоимость.
 *  Используется для печати чеков, отчетов разных форм.
 *
 */
public interface Printer {

    /**
     * Печатает состав заказа.
     *
     * @param order - заказ клиента кафе
     */
    void print(Receipt order);

}
