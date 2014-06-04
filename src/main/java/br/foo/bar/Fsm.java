package br.foo.bar;

public interface Fsm {

    void addState(State state);

    Transition addTransition();

    boolean hasTransition(State current, State next);

}
