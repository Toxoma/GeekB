package org.example.Model;

import org.example.Controller.DefaultActions;

public class Calculator extends AbstractCalculator implements DefaultActions {


    @Override
    public void Minus() {
        this.setTempValue();
        this.setActualPartValue(this.getActualPartValue() - this.getTempActualPartValue());
        this.setFakePartValue(this.getFakePartValue() - this.getTempFakePartValue());
    }

    @Override
    public void Plus() {
        this.setTempValue();
        this.setActualPartValue(this.getActualPartValue() + this.getTempActualPartValue());
        this.setFakePartValue(this.getFakePartValue() + this.getTempFakePartValue());
    }

    @Override
    public void Multi() {
        this.setTempValue();
        var temp = this.getActualPartValue() * this.getTempActualPartValue() + (-1) * this.getFakePartValue() * this.getTempFakePartValue();
        this.setFakePartValue(this.getFakePartValue() * this.getTempActualPartValue() + this.getActualPartValue() * this.getTempFakePartValue());
        this.setActualPartValue(temp);
    }
}
