package br.foo.bar;

import org.junit.Test;

public class FsmTest {

    @Test
    public void testOne() {
        Fsm fsm = FsmFactory.createInstance();

        // add states here
        State started = new Started() {};
        fsm.addState(started);
        State running = new Running() {};
        fsm.addState(running);
        State canceled = new Canceled() {};
        fsm.addState(canceled);
        State finished = new Finished() {};
        fsm.addState(finished);

        // add transitions
        fsm.addTransition().from(started).to(running);
        fsm.addTransition().from(started).to(canceled);
        fsm.addTransition().from(running).to(canceled);
        fsm.addTransition().from(running).to(finished);

        // create subject of processing
        FsmSubject washingMachine = new WashingMachine();

        FsmProcessor processor = FsmProcessorFactory.createProcessor(fsm, washingMachine);
        processor.to(running);
    }
}
