package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc();
        System.out.println( calc.sum(new ArrayList<>(Arrays.asList(1,2,3))) );
        System.out.println( calc.multi(new ArrayList<>(Arrays.asList(2,2,3))) );
        System.out.println( calc.division(10,5) );
        System.out.println( calc.binary(8) );
        System.out.println( calc.binary(8.0) );
        System.out.println( calc.binary("8") );
        System.out.println( calc.binary("8.0") );
    }
}