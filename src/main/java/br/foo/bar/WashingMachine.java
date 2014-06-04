package br.foo.bar;

public class WashingMachine implements FsmSubject {

    private State state;

    public WashingMachine() {
        this.state = new Started();
    }

    @Override
    public State getState() {
        return state;
    }

}
