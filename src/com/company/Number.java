package com.company;

public class Number {

    private int number;
    private String formatNumber;

    public Number(int number, String formatNumber) {
        this.number = number;
        this.formatNumber = formatNumber;
    }

    public int getNumber() {
        return number;
    }

    public String getFormatNumber() {
        return formatNumber;
    }
}
