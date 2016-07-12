package com.hometask.module6;

public class ExceptionInName extends Exception {

    private String name;

    public String getName() {
        return name;
    }

    public ExceptionInName(String message, String name) {

        super(message);
        this.name = name;
    }

}
