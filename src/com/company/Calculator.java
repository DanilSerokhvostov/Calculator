package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Calculator {

    public static void main(String[] args) {

        startCalculator();

        //Запускаем вторую нить для добавления значений в Map
        NumberProcessing numberProcessing = new NumberProcessing();
        numberProcessing.start();

        // Считывание строки с консоли
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String readLine = reader.readLine();

            //При вводе "exit" программа завершается
            if (readLine.equals("exit")){
                closeCalculator();
                System.exit(1);
            }

            // Разбиваем строку на элементы и помещаем их в массив
            String [] parseRow = readLine.split(" ");

            //Если длина массива не равна 3-ем, то выдаем сообщение и закрываем программу
            if (parseRow.length != 3){
                System.out.println("Неверно введена строка");
                System.exit(1);
            }

            //Узнаем формат первого числа, и проверяем одного ли формата эти числа
            Number numberFirst = numberProcessing.numberProcessingFirstNumber(parseRow[0]);
            Number numberSecond = numberProcessing.numberProcessingSecondNumber(parseRow[2]
                    ,numberFirst.getFormatNumber());

            //Производим расчет
            String resault = ActionCalculator.ActionCalculator(numberFirst,numberSecond,parseRow[1]);
            System.out.println("Результат: " + resault);
            closeCalculator();

        } catch (Exception e){
            System.out.println("Неверно введа строка");
        }

    }

    public static void  startCalculator(){
        System.out.println("Добро пожаловать в консольный калькулятор " +
                "\nВведите выражение вида: A (+,-,*,/) B");
    }

    public static void  closeCalculator(){
        System.out.println("Программа завершена" +
                "\nСпасибо за использование");
    }
}
