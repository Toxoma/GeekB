package org.example.state;

public class Program {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext();
        stateContext.heat();
        stateContext.heat();
        stateContext.heat();
        stateContext.freeze();
        stateContext.freeze();
        stateContext.freeze();

    }
}
