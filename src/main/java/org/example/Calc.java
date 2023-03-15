package org.example;

import java.util.List;

public class Calc{
    public Double sum(List<? extends Number> items){
        double sum = 0;
        for (Number i: items)
            sum += i.doubleValue();
        return sum;
    }

    public Double multi(List<? extends Number> items){
        double multi = 1;
        for (Number i: items)
            multi *= i.doubleValue();
        return multi;
    }

    public Double division(Number first, Number second){
        return first.doubleValue()/second.doubleValue();
    }

    public String binary(Number item){
        return Integer.toBinaryString(item.intValue());
    }

    public String binary(String item){
       return this.binary(Double.parseDouble(item));
    }
}