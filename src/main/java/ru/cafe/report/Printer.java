package ru.cafe.report;

import ru.cafe.receipt.Receipt;

/**
 *  Интерфейс Printer.
 *  Используется для печати чеков, отчетов разных форм.
 */
public interface Printer {

    /**
     * Выводит чек клиента на экран
     *
     * @param order - чек клиента
     */
    void print(Receipt order);

}
