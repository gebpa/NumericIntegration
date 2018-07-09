package com.company;

import java.util.Scanner;

public class ReadFromCommandLine {
    public int getFunction() {
        return function;
    }

    public int getModification() {
        return modification;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getLowBraket() {
        return lowBraket;
    }

    public double getHighBraket() {
        return highBraket;
    }

    private int function;
    private int modification;
    private double accuracy;
    private double lowBraket;
    private double highBraket;
    public void readFromCommandLine(){
        System.out.println("Выберите функцию, указав ее номер");
        System.out.println("1) y=x^2-4x");
        System.out.println("2) y=7x+9");
        System.out.println("3) y=1/(x+2)");
        function=0;
        Scanner sc = new Scanner(System.in);
        while(function==0) {
            if (sc.hasNext()) {
                try {
                    function = (int)Double.parseDouble(sc.next());
                    if (function!=1 && function!=2 && function!=3) throw new Exception();
                } catch (Exception e) {
                    System.out.println("Нужно число от 1 до 3");
                    function=0;
                }
            }
        }
        System.out.println("Какую модификацию использовать для интегрирования методом прямоугольников? (левая, правая, средняя)");
        modification=0;
        while (modification==0){
            if(sc.hasNext()){
                try {
                    String mod = sc.next();
                    mod.trim();
                    mod = mod.substring(0, 3);
                    if (mod.equals("лев")) {
                        modification = 1;
                    } else if (mod.equals("пра")) {
                        modification = 2;
                    } else if (mod.equals("сре")) {
                        modification = 3;
                    } else {
                        throw new Exception();
                    }
                }catch (Exception e){
                    System.out.println("Вы что-то сделали не так, попробуйте снова");
                }
            }
        }
        System.out.println("Введите нижний предел интегрирования");
        lowBraket=getBracket();
        System.out.println("Введите верхний предел интегрирования");
        highBraket=getBracket();
        System.out.println("Введите точность");
        accuracy=getBracket();
        System.out.println("Сейчас вы получите результат интегрирования");
    }
    private static double getBracket(){
        double braket;
        Scanner sc=new Scanner(System.in);
        while (true) {
            if (sc.hasNext()) {
                try {
                    braket = Double.parseDouble(sc.next());
                    break;
                } catch (Exception e) {
                    System.out.println("Нужно ввести одно число");
                }
            }
        }
        return braket;
    }
}
