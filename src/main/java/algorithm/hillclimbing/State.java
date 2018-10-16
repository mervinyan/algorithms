package algorithm.hillclimbing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class State {

	private List<Stack<String>> state;
	private int heuristics;
	
	public State(List<Stack<String>> state) {
		this.state = state;
	}
	
	State(List<Stack<String>> state, int heuristics) {
		this.state = state;
		this.heuristics = heuristics;
	}
	
	@SuppressWarnings("unchecked")
	State(State state) {
		if (state != null) {
			this.state = new ArrayList<>();
			for (Stack<String> s : state.getState()) {
				Stack<String> s1 = (Stack<String>)s.clone();
				this.state.add(s1);
			}
			this.heuristics = state.getHeuristics();
		}
	}
	
	public List<Stack<String>> getState() {
		return state;
	}
	
	public int getHeuristics() {
		return heuristics;
	}
	
	public void setHeuristics(int heuristics) {
		this.heuristics = heuristics;
	}
}
