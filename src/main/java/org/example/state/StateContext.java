package org.example.state;

public class StateContext {
    private State state = new SolidState();

    public void freeze() {
        System.out.println("Охлаждение " + state.getName() + " состояние...");
        state.freeze(this);
    }

    public void heat() {
        System.out.println("Нагревание " + state.getName() + " состояние...");
        state.heat(this);
    }

    public void setState(State state) {
        System.out.println("Смена состояния на " + state.getName() + "...");
        this.state = state;
    }

    public State getState() {
        return state;
    }
}
