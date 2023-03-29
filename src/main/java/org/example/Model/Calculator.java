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

    @Override
    public void Division() {
        this.setTempValue();
//      ЧИСЛИТЕЛЬ
        var temp1A = this.getActualPartValue() * this.getTempActualPartValue() + this.getFakePartValue() * this.getTempFakePartValue();
        var temp1F = this.getFakePartValue() * this.getTempActualPartValue() + this.getActualPartValue() * (-1) * this.getTempFakePartValue();
//      Знаменатель
        var temp2A = Math.pow(this.getTempActualPartValue(), 2);
        var temp2F = Math.pow(this.getTempFakePartValue(), 2);
        var temp2R = temp2A + temp2F;
        this.setActualPartValue(temp1A/temp2R);
        this.setFakePartValue(temp1F/temp2R);
    }
}
