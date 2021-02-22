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

        int a1 = number / 100;
        for (int i = 0; i < a1; i++){
            resault.append("C");
            number = number % 100;
        }
        int a2 = number / 50;
        for (int i = 0; i < a2; i++){
            resault.append("L");
            number = number % 50;
        }
        int a3 = number / 10;
        for (int i = 0; i < a3; i++){
            resault.append("X");
            number = number % 10;
        }
        int a4 = number / 5;
        for (int i = 0; i < a4; i++){
            resault.append("V");
            number = number % 5;
        }

        int a5 = number / 1;
        for (int i = 0; i < a5; i++){
            resault.append("I");
        }

        setRow(String.valueOf(resault));
        return getRow();
    }

}
