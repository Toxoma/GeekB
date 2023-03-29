package org.example.Model;

import org.example.Controller.DefaultActions;

public class CalculatorWithLogging extends Calculator {
    @Override
    public void setCurrentValue() {
        super.setCurrentValue();
        System.out.println("Логирование: значние = " + this.getValue(""));
    }

    @Override
    public void Minus() {
        var str = "Логирование операции вычитания: " + this.getValue("");
        super.Minus();
        str+=" - ( " + this.getValue("temp") +" ) = " + this.getValue("");
        System.out.println(str);
    }

    @Override
    public void Plus() {
        var str = "Логирование операции сложения: " + this.getValue("");
        super.Plus();
        str+=" + ( " + this.getValue("temp") +" ) = " + this.getValue("");
        System.out.println(str);
    }

    @Override
    public void Multi() {
        var str = "Логирование операции умножения: ( " + this.getValue("") + " )";
        super.Multi();
        str+=" * ( " + this.getValue("temp") +" ) = " + this.getValue("");
        System.out.println(str);
    }

    @Override
    public void Division() {
        var str = "Логирование операции деления: ( " + this.getValue("") + " )";
        super.Division();
        str+=" / ( " + this.getValue("temp") +" ) = " + this.getValue("");
        System.out.println(str);
    }
}
