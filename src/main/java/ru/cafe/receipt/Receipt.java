package ru.cafe.receipt;

import ru.cafe.receipt.items.BatchUnit;

import java.util.List;

public class Receipt {

    private long orderId;
    private List<BatchUnit> batchUnit;
    private double receiptPrice;

    public Receipt(long orderId, List<BatchUnit> batchUnit, double receiptPrice) {
        this.orderId = orderId;
        this.batchUnit = batchUnit;
        this.receiptPrice = receiptPrice;
    }

    public long getReceiptId() {
        return orderId;
    }

    public List<BatchUnit> getOrderedItems() {
        return batchUnit;
    }

    public double getReceiptPrice() {
        return receiptPrice;
    }

}
