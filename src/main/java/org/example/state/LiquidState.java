package org.example.state;

public class LiquidState implements State {
    private static final String NAME = "жидкое";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void freeze(StateContext context) {
        context.setState(new SolidState());
    }

    @Override
    public void heat(StateContext context) {
        context.setState(new GaseousState());
    }
}
