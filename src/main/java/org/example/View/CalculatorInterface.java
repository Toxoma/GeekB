package org.example.View;

import org.example.Model.CalculatorWithLogging;

public class CalculatorInterface extends CalculatorWithLogging {
    public CalculatorInterface() {
        super();
        this.init();
    }

    @Override
    public void setCurrentValue() {
        System.out.println("Запуск калькулятора...");
        System.out.println("Введите начальное комплексное число...");
        super.setCurrentValue();
    }

    @Override
    public void Minus() {
        System.out.println("Операция вычитания...");
        super.Minus();
    }

    @Override
    public void Plus() {
        System.out.println("Операция сложения...");
        super.Plus();
    }

    @Override
    public void Multi() {
        System.out.println("Операция умножения...");
        super.Multi();
    }

    @Override
    public void Division() {
        System.out.println("Операция деления...");
        super.Division();
    }

    protected void init() {
        var temp = -1;
        while (temp != 0) {
            System.out.println("1. Операция сложения");
            System.out.println("2. Операция вычитания");
            System.out.println("3. Операция умножения");
            System.out.println("4. Операция деления");
            System.out.println("5. Текущее занчение");
            System.out.println("0. Выход");
            System.out.print("Номер операции: ");
            temp = this.scanner.nextInt();
            switch (temp) {
                case 0:
                    break;
                case 1:
                    this.Plus();
                    break;
                case 2:
                    this.Minus();
                    break;
                case 3:
                    this.Multi();
                    break;
                case 4:
                    this.Division();
                    break;
                case 5:
                    System.out.println("Текущее занчение: " + this.getValue(""));
                    break;
                default:
                    System.out.println("Введено некорректное значение... Попробуйте ещё раз!");
                    break;
            }
            System.out.println("_______________");
        }
        System.out.println("Закрываем калькулятор...");
    }

}

