package br.foo.bar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FsmFactory {

    public static Fsm createInstance() {
        return new Fsm() {

            private final List<Transition> transitions = new ArrayList<>();
            private final Set<State> states = new HashSet<>();

            @Override
            public void addState(State state) {
                states.add(state);
            }

            @Override
            public Transition addTransition() {
                final Transition t = new Transition() {

                    private State from;
                    private State to;

                    @Override
                    public Transition from(State origin) {
                        validatePresenceOf(origin);
                        from = origin;
                        return this;
                    }

                    @Override
                    public void to(State destination) {
                        validatePresenceOf(destination);
                        to = destination;
                    }

                    private void validatePresenceOf(State origin) {
                        if (!states.contains(origin)) {
                            throw new IllegalArgumentException("State " + origin + " does not exist!!!");
                        }
                    }

                    @Override
                    public State getFrom() {
                        return this.from;
                    }

                    @Override
                    public State getTo() {
                        return this.to;
                    }
                };
                transitions.add(t);
                return t;
            }

            @Override
            public boolean hasTransition(State from, State to) {
                boolean found = false;
                for (Transition t : transitions) {
                    if (t.getFrom().equals(from) && t.getTo().equals(to)) {
                        found = true;
                    }
                }
                return found;
            }

        };
    }

}
