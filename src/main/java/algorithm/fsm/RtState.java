package algorithm.fsm;

import java.util.ArrayList;
import java.util.List;

public final class RtState implements State {

	private List<Transition> transitions;
	private boolean isFinal;
	
	public RtState() {
		this(false);
	}
	
	public RtState(final boolean isFinal) {
		this.transitions = new ArrayList<>();
		this.isFinal = isFinal;
	}
	
	@Override
	public State with(Transition tr) {
		this.transitions.add(tr);
		return this;
	}

	@Override
	public State transit(CharSequence c) {
		return transitions.stream().filter(t -> t.isPossible(c)).map(Transition::state).findAny().orElseThrow(() -> new IllegalArgumentException("Input not accepted: " + c));
	}

	@Override
	public boolean isFinal() {
		return this.isFinal;
	}

}
