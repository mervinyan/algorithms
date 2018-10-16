package algorithms.fsm;

public interface FiniteStateMachine {

	/**
	 * Follow a transition, switch the state of the machine.
	 * @param c
	 * @return A new finite state machine with the new state.
	 */
	FiniteStateMachine switchState(final CharSequence c);
	
	/**
	 * Is the current state a final one?
	 * @return
	 */
	boolean canStop();
}
