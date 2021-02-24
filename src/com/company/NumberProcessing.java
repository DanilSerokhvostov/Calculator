package com.company;

import java.util.HashMap;


public class NumberProcessing extends Thread {

    private static final HashMap<String,Integer > RomanAndArabic = new HashMap<>();
    private static String row;


    public static String getRow() {
        return row;
    }

    public static void setRow(String row) {
        NumberProcessing.row = row;
    }

    @Override
    public void run() {
        RomanAndArabic.put("I",1);
        RomanAndArabic.put("II",2);
        RomanAndArabic.put("III",3);
        RomanAndArabic.put("IV",4);
        RomanAndArabic.put("V",5);
        RomanAndArabic.put("VI",6);
        RomanAndArabic.put("VII",7);
        RomanAndArabic.put("VIII",8);
        RomanAndArabic.put("IX",9);
        RomanAndArabic.put( "X",10);
    }
/*
    Метод для того, чтобы узнать какой формат у числа и для выхода из программы,
    если введеные числа не попадают в заданный диапазон
 */
    public  Number numberProcessingFirstNumber(String figure) throws Exception {

        int number;
        String numberFormat;

        try {
            number = Integer.parseInt(figure);
            numberFormat = "ARABIC";
        } catch (Exception e) {
            number = romanNumber(figure);
            numberFormat = "ROMAN";
        }

        if (number < 0 || number > 11) {
            throw new Exception("Неподходящее значение, введите число от 1 до 10 включительно");
        }

        return new Number(number, numberFormat);
    }

    //Метод для сравнения формата чисел
    public  Number numberProcessingSecondNumber(String figure, String formatNumber) throws Exception {

        Number number = numberProcessingFirstNumber(figure);
        if (!number.getFormatNumber().equals(formatNumber)) {
            throw new Exception("У чисел разный тип, введите числа одного типа");
        }

        return number;
    }

    //Метод для нахождения соответствующего арабского числа при введении римских чисел в консоль
    private static int romanNumber(String number){
        int value = 0;
       for(HashMap.Entry<String,Integer> entry : RomanAndArabic.entrySet()){
           String key = entry.getKey();
           if (key.equals(number)){
               value = entry.getValue();
               break;
           }
       }
        return value;
    }

    // Метод для преобразования арабских чисел в римские
    public static String toRomanNumber(int number){
        StringBuffer resault = new StringBuffer("");

        while (number >= 100) {
            resault.append("C");
            number -= 100;
        }
        while (number >= 90) {
            resault.append("XC");
            number -= 90;
        }
        while (number >= 50) {
            resault.append("L");
            number -= 50;
        }
        while (number >= 40) {
            resault.append("XL");
            number -= 40;
        }
        while (number >= 10) {
            resault.append("X");
            number -= 10;
        }
        while (number >= 9) {
            resault.append("IX");
            number -= 9;
        }
        while (number >= 5) {
            resault.append("V");
            number -= 5;
        }
        while (number >= 4) {
            resault.append("IV");
            number -= 4;
        }
        while (number >= 1) {
            resault.append("I");
            number -= 1;
        }

        setRow(String.valueOf(resault));
        return getRow();
    }



}
