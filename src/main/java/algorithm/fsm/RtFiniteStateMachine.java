package algorithm.fsm;

public final class RtFiniteStateMachine implements FiniteStateMachine {

	private State current;
	
	public RtFiniteStateMachine(final State initial) {
		this.current = initial;
	}
	@Override
	public FiniteStateMachine switchState(CharSequence c) {
		return new RtFiniteStateMachine(this.current.transit(c));
	}

	@Override
	public boolean canStop() {
		return this.current.isFinal();
	}

}
