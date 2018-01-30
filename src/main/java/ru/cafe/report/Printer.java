package ru.cafe.report;

import ru.cafe.order.Order;

/**
 *  Интерфейс Printer.
 *  С помощью интерфейста можно увидеть состав заказа и его стоимость
 *  и распечатать заказ. Используется для печати чеков, отчетов разных форм.
 *
 */
public interface Printer {

    /**
     * Показаывает общий состав состав заказа и его стоимость.
     *
     * @param order - заказ клиента кафе
     */
    void show(Order order);


    /**
     * Печатает состав заказа.
     *
     * @param order - заказ клиента кафе
     */
    void print(Order order);

}
