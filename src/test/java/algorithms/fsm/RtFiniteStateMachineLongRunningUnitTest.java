package algorithms.fsm;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithms.fsm.FiniteStateMachine;
import algorithms.fsm.RtFiniteStateMachine;
import algorithms.fsm.RtState;
import algorithms.fsm.RtTransition;
import algorithms.fsm.State;

public class RtFiniteStateMachineLongRunningUnitTest {

	@Test
	public void acceptSimplePair() {
		String json = "{\"key\":\"value\"}";
		FiniteStateMachine machine = this.buildJsonStateMachine();
		for (int i = 0; i < json.length(); i++) {
			machine = machine.switchState(String.valueOf(json.charAt(i)));
		}
		assertTrue(machine.canStop());
	}
	
	@Test
    public void acceptsMorePairs() {
        String json = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        FiniteStateMachine machine = this.buildJsonStateMachine();
        for (int i = 0; i < json.length(); i++) {
            machine = machine.switchState(String.valueOf(json.charAt(i)));
        }
        assertTrue(machine.canStop());
    }

    @Test(expected = IllegalArgumentException.class)
    public void missingColon() {
        String json = "{\"key\"\"value\"}";
        FiniteStateMachine machine = this.buildJsonStateMachine();
        for (int i = 0; i < json.length(); i++) {
            machine = machine.switchState(String.valueOf(json.charAt(i)));
        }
    }
	
	private FiniteStateMachine buildJsonStateMachine() {
		State first = new RtState();
		State second = new RtState();
		State third = new RtState();
		State fourth = new RtState();
		State fifth = new RtState();
		State sixth = new RtState();
		State seventh = new RtState();
		State eighth = new RtState(true);
		
		first.with(new RtTransition("{",second));
		second.with(new RtTransition("\"", third));
		for (int i = 0; i < 26; i++) {
			if (i < 10) {
				third = third.with(new RtTransition(String.valueOf(i), third));
				sixth = sixth.with(new RtTransition(String.valueOf(i), sixth));
			}
			third = third.with(new RtTransition(String.valueOf((char)('a' + i)), third));
			sixth = sixth.with(new RtTransition(String.valueOf((char)('a' + i)), sixth));
		}
		third.with(new RtTransition("\"", fourth));
		fourth.with(new RtTransition(":", fifth));
		fifth.with(new RtTransition("\"", sixth));
		sixth.with(new RtTransition("\"", seventh));
		seventh.with(new RtTransition(",", second));
		seventh.with(new RtTransition("}", eighth));
		return new RtFiniteStateMachine(first);
	}
}
