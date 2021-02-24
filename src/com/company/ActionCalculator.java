package com.company;

public class ActionCalculator{

    public static String ActionCalculator(Number firstNumber,Number secondNumber,String action) throws Exception {

        int resault = 0;


        if (action.equals("+")){
          resault = firstNumber.getNumber() + secondNumber.getNumber();
        } else  if (action.equals("-")){
            resault = firstNumber.getNumber() - secondNumber.getNumber();
        } else if (action.equals("*")){
            resault = firstNumber.getNumber() * secondNumber.getNumber();
        } else if (action.equals("/") || action.equals("\\")) {
            Double firstDouble = (double) firstNumber.getNumber();
            Double secondDouble = (double) secondNumber.getNumber();
            if (firstDouble % secondDouble != 0) {
                System.out.println("Неверная операция, ответ является дробным числом");
                System.exit(1);
            } else {
                resault = firstNumber.getNumber() / secondNumber.getNumber();
            }
        }
/*
        Возникла проблема при возврате значений в формате римских цифр, из-за этого
        пришлось добавить возврат значения через другое поле
 */
        if (secondNumber.getFormatNumber().equals("ROMAN")){
            NumberProcessing.toRomanNumber(resault);
            return NumberProcessing.getRow();
        } else {
            return String.valueOf(resault);
        }
    }
}
