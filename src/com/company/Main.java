package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ReadFromCommandLine read=new ReadFromCommandLine();
        read.readFromCommandLine();
        IntegrationRectangle integr=new IntegrationRectangle(read.getFunction(), read.getModification(), read.getAccuracy(), read.getLowBraket(), read.getHighBraket());
        System.out.println("Результат=" +integr.integrate());
        System.out.println("Количество разбиений="+integr.getNumOfFractions());
        System.out.println("Точность="+integr.getFinalAccuracy());
    }
}
