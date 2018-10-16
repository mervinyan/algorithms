package algorithms.linkedlist;

public class CycleDetectionResult<T> {

	boolean cycleExists;
	Node<T> node;
	
	public CycleDetectionResult(boolean cycleExists, Node<T> node) {
		this.cycleExists = cycleExists;
		this.node = node;
	}
	
	
}
