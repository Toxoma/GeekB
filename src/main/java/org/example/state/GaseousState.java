package org.example.state;

public class GaseousState implements State {
    private static final String NAME = "газообразное";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void freeze(StateContext context) {
        context.setState(new LiquidState());
    }

    @Override
    public void heat(StateContext context) {
        System.out.println("Ничего не произошло.");
    }
}
