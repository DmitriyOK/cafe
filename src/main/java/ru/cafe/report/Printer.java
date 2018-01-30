package ru.cafe.report;

import ru.cafe.order.Order;

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
    void print(Order order);

}
