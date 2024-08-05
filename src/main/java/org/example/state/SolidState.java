package org.example.state;

public class SolidState implements State {
    private static final String NAME = "твёрдое";
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void freeze(StateContext context) {
        System.out.println("Ничего не произошло.");
    }

    @Override
    public void heat(StateContext context) {
        context.setState(new LiquidState());
    }
}
