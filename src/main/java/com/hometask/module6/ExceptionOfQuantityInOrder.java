package com.hometask.module6;

public class ExceptionOfQuantityInOrder extends Exception {

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public ExceptionOfQuantityInOrder(String message, Integer quantity) {

        super(message);
        this.quantity = quantity;
    }
}
