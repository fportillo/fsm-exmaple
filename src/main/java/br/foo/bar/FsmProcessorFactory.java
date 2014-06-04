package br.foo.bar;

import java.text.MessageFormat;

public class FsmProcessorFactory {

    public static FsmProcessor createProcessor(final Fsm fsm, final FsmSubject subject) {
        return new FsmProcessor() {
            @Override
            public void to(State next) {
                State current = subject.getState();
                if (fsm.hasTransition(current, next)) {
                    // fsm.validateTransition(subject, next);
                    // fsm.takeActions(subject, next);
                    // fsm.move(subject).to(next);
                }
                throw new IllegalStateException(MessageFormat.format("State {0} is not able to go to {1}", current, next));
            }
        };
    }


}
