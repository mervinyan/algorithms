package algorithms.fsm;

/**
 * Transition in a finite state machine
 *
 */
public interface Transition {

	/**
	 * Is the transition possible with the given character?
	 * @param c
	 * @return
	 */
	boolean isPossible(final CharSequence c);
	
	/**
	 * The state to which this transition leads
	 * @return State
	 */
	State state();
}
