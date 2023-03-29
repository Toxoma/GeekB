package org.example.Model;

import java.util.Objects;
import java.util.Scanner;

abstract class AbstractCalculator {
    private double actualPartValue = 0;
    private double fakePartValue = 0;
    private double tempActualPartValue = 0;
    private double tempFakePartValue = 0;

    protected Scanner scanner = new Scanner(System.in);

    public AbstractCalculator() {
        this.setCurrentValue();
    }

    protected void setCurrentValue() {
        System.out.print("Действительная часть = ");
        this.setActualPartValue(scanner.nextDouble());
        System.out.print("Мнимая часть = ");
        this.setFakePartValue(scanner.nextDouble());
    }
    protected void setTempValue() {
        System.out.print("Действительная часть = ");
        this.setTempActualPartValue(scanner.nextDouble());
        System.out.print("Мнимая часть = ");
        this.setTempFakePartValue(scanner.nextDouble());
    }
    protected String getValue(String type) {
        var actual = this.getActualPartValue();
        var fake = this.getFakePartValue();
        if (type.equals("temp")){
            actual = this.getTempActualPartValue();
            fake = this.getTempFakePartValue();
        }
        var str = "";
        str+=actual;
        if (fake != 0){
            if (fake < 0){
                str+=" - "+fake*-1;
            }else{
                str+=" + "+fake;
            }
            str+="i";
        }
        return str;
    }
    protected double getFakePartValue() {
        return fakePartValue;
    }

    protected void setFakePartValue(double fakePartValue) {
        this.fakePartValue = fakePartValue;
    }

    protected double getActualPartValue() {
        return actualPartValue;
    }

    protected void setActualPartValue(double actualPartValue) {
        this.actualPartValue = actualPartValue;
    }

    protected double getTempActualPartValue() {
        return tempActualPartValue;
    }

    protected void setTempActualPartValue(double tempActualPartValue) {
        this.tempActualPartValue = tempActualPartValue;
    }

    protected double getTempFakePartValue() {
        return tempFakePartValue;
    }

    protected void setTempFakePartValue(double tempFakePartValue) {
        this.tempFakePartValue = tempFakePartValue;
    }
}
