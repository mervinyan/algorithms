package algorithms.mcts.montecarlo;

import java.util.Collections;
import java.util.Comparator;

import algorithms.mcts.tree.Node;

/**
 * Upper Confidence Bound
 * 
 *
 */
public class UCT {

	/**
	 * wi = number of wins after the i-th move
	 * ni = number of simulations after the i-th move
	 * c = exploration parameter (theorectically equal to sqrt 2
	 * t = total number of simulations for the parent node
	 * @param totalVisit
	 * @param nodeWinScore
	 * @param nodeVisit
	 * @return
	 */
	public static double uctValue(int totalVisit, double nodeWinScore, int nodeVisit) {
		if (nodeVisit == 0) {
			return Integer.MAX_VALUE;
		}
		return (nodeWinScore / (double)nodeVisit) + 1.41 * Math.sqrt(Math.log(totalVisit) / (double)nodeVisit);
	}
	
	static Node findBestNodeWithUCT(Node node) {
		int parentVisit = node.getState().getVisitCount();
		return Collections.max(node.getChildArray(), Comparator.comparing(c -> uctValue(parentVisit, c.getState().getWinScore(), c.getState().getVisitCount())));
	}
}
