package algorithm.fsm;

public final class RtTransition implements Transition {

	private String rule;
	private State next;
	
	public RtTransition(String rule, State next) {
		this.rule = rule;
		this.next = next;
	}
	
	@Override
	public boolean isPossible(CharSequence c) {
		return this.rule.equalsIgnoreCase(String.valueOf(c));
	}

	@Override
	public State state() {
		return this.next;
	}

}
