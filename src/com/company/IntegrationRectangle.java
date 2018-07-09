package com.company;

public class IntegrationRectangle {
    private int function;
    private int modification;
    private double accuracy;
    private double lowBraket;
    private double highBraket;
    private int numOfFractions;
    private double finalAccuracy;

    public int getNumOfFractions() {
        return numOfFractions;
    }

    public void setNumOfFractions(int numOfFractions) {
        this.numOfFractions = numOfFractions;
    }

    public double getFinalAccuracy() {
        return finalAccuracy;
    }

    public void setFinalAccuracy(double finalAccuracy) {
        this.finalAccuracy = finalAccuracy;
    }

    public IntegrationRectangle(int function, int modification, double accuracy, double lowBraket, double highBraket){
        if (highBraket < lowBraket){
            double saver=highBraket;
            highBraket=lowBraket;
            lowBraket=saver;
        }
        this.function=function;
        this.modification=modification;
        this.accuracy=accuracy;
        this.highBraket=highBraket;
        this.lowBraket=lowBraket;
    }
    public double getFunctionResult(double x){
        if(function==1){
            return x*x-4*x;
        }
        else if  (function==2){
            return 7*x+9;
        }
        else {
            return 1/(x+2);
        }
    }
    public double integrate() {
        double integral=0;
        try{
            if (lowBraket<-2 && highBraket>-2 && function==3){
                System.out.println("функция не опрделена на этом отрезке");
                throw new Exception();
            }
        if (lowBraket == highBraket) {
            System.out.println("Результат интегрирования=0");
            throw new Exception();
        }
        int numOfFragmentation = 1;
        while (true) {
            double integral1 = sum(numOfFragmentation);
            numOfFragmentation++;
            double integral2 = sum(numOfFragmentation);
            if (Math.abs(integral1 - integral2) <= accuracy * 3) {
                integral = integral2;
                numOfFractions=numOfFragmentation;
                finalAccuracy=3*Math.abs(integral-integral1);
                break;
            }
            numOfFragmentation++;
        }
        }
        catch (Exception e){
        }
        return integral;
        }
    public double sum(int numOfFragmentation) {
        double x0 = lowBraket;
        double integral = 0;
        double lengtOfFragment = (highBraket - lowBraket) / numOfFragmentation;
        if (modification == 1) {
            for (int i = 0; i < numOfFragmentation; i++) {
                integral += lengtOfFragment * getFunctionResult(x0);
                x0 = x0 + lengtOfFragment;
            }
            return integral;
        }
        else if (modification == 2) {
            for (int i = 0; i < numOfFragmentation; i++) {
                x0+= lengtOfFragment;
                integral += lengtOfFragment * getFunctionResult(x0);
            }
            return integral;
        }
        else {
            for (int i = 0; i < numOfFragmentation; i++) {
                double xi = x0 + lengtOfFragment;
                double mid=(x0+xi)/2;
                integral += lengtOfFragment * getFunctionResult(mid);
                x0+=lengtOfFragment;
            }
            return integral;
        }
    }
}


