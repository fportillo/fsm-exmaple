package br.foo.bar;

public interface Transition {

    Transition from(State origin);

    void to(State destination);

    State getFrom();

    State getTo();

}
