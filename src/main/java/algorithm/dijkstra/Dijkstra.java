package algorithm.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Dijkstra {

	public static Graph calcualteShortestPathFromSource(Graph graph, Node source) {
		source.setDistance(0);
		
		Set<Node> settledNodes = new HashSet<>();
		Set<Node> unsettledNodes = new HashSet<>();
		unsettledNodes.add(source);
		
		while (!unsettledNodes.isEmpty()) {
			Node currentNode = getLowestDistanceNode(unsettledNodes);
			unsettledNodes.remove(currentNode);
			for (Entry<Node, Integer> adjacentPair : currentNode.getAdjacentNodes().entrySet()) {
				Node adjacentNode = adjacentPair.getKey();
				Integer edgeWeight = adjacentPair.getValue();
				
				if (!settledNodes.contains(adjacentNode)) {
					calcualteMinimumDistance(adjacentNode, edgeWeight, currentNode);
					unsettledNodes.add(adjacentNode);
				}
			}
			settledNodes.add(currentNode);
		}
		
		return graph;
	}
	
	private static void calcualteMinimumDistance(Node evaluationNode, Integer edgeWeight, Node sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		if (sourceDistance + edgeWeight < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceDistance + edgeWeight);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			shortestPath.add(sourceNode);
			evaluationNode.setShortestPath(shortestPath);
		}
	}
	
	private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		Node lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Node node : unsettledNodes) {
			int nodeDistance = node.getDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		
		return lowestDistanceNode;
	}
}
