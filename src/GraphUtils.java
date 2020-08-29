

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphUtils {
	
	/*
	 * Implement the following methods.
	 */

	public static int minDistance(Graph graph, String src, String dest) {
		
		if(graph == null || src == null || dest == null || !graph.containsNode(src) || !graph.containsNode(dest)) {
			System.out.println("Invalid query, returned -1");
			return -1;
		}
		
		if (src.equals(dest)) {
			return 0;
		}
		
		Set<String> marked = new HashSet<>();
		Queue<String> toExplore = new LinkedList<>();
		HashMap<String, Integer> distanceMap = new HashMap<>();
		
		toExplore.add(src);
		marked.add(src);
		distanceMap.put(src, 0);
		
		while (!toExplore.isEmpty()) {
			String node = toExplore.remove();
			for (String neighbor : graph.getNodeNeighbors(node)) {
				
				if (!marked.contains(neighbor)) {
					
					distanceMap.put(neighbor, distanceMap.get(node) + 1);
					
					if (neighbor.equals(dest)) {
						return distanceMap.get(neighbor);
					}
					
					marked.add(neighbor);
					toExplore.add(neighbor);
 				}
			}
		}
		
		return -1;
	}
	
	
	/*
	 * Breadth-First Search implementation
	 */
//	private static int bfsShortestPath(Graph graph, String start, String elementToFind) {
//		
//		if (start.equals(elementToFind)) {
//			return 0;
//		}
//		
//		
//		ArrayList<String> shortestPathArray = new ArrayList<>();
//		
//		Set<String> marked = new HashSet<>();
//		
//		
//		Queue<String> toExplore = new LinkedList<String>();
//		marked.add(start);
//		toExplore.add(start);
//		
//		shortestPathArray.add(start);
//		
//		while (!toExplore.isEmpty()) {
//			String current = toExplore.remove();
//	
//			if (!shortestPathArray.contains(current)) {
//				shortestPathArray.add(current);	
//			}
//			
//			boolean containsUnmarked = false;
//			
//			for (String neighbor : graph.getNodeNeighbors(current)) {
//				
//				if (!marked.contains(neighbor)) {
//					
//					if (!shortestPathArray.contains(current)) {
//						shortestPathArray.add(current);	
//					}
//					
//					if (neighbor.equals(elementToFind)) {
//						shortestPathArray.add(neighbor);
//						System.out.println("shortest path: " + shortestPathArray.toString());
//						return shortestPathArray.size()-1;
//					} 
//					
//					marked.add(neighbor);
//					toExplore.add(neighbor);
//					
//					containsUnmarked = true;
//				} 	
//					
//			}
//			
//			if (!containsUnmarked) {
//				shortestPathArray.remove(current);
//			}
//
//		}
//		
//		return -1;
//	}

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {
		
		if (graph == null || src == null || distance < 1 || !graph.containsNode(src)) {
			System.out.println("Invalid query, returned null");
			return null;
		}
		
		Set<String> output = new HashSet<>();
		
		for (String n : graph.adjacencySets.keySet()) {
			int d = minDistance(graph, src, n);
			if ( d <= distance && d != -1) {
				output.add(n);
			}
		}
		
		output.remove(src);
		
		return output;
	}

	public static boolean isHamiltonianCycle(Graph g, List<String> values) {
		
		if (g == null || values == null) {
			System.out.println("Invalid query, returned false");
			return false;
		}
		
		//some nodes are not visited
		for (String n : g.adjacencySets.keySet()) {
			if (!values.contains(n)) {
				System.out.println("Some nodes not visited, returned false");
				return false;
			}
		}
		
		Set<String> visitedNodes = new HashSet<>();
		
		for (int i = 0; i < values.size(); i++) {
			
			String n = values.get(i);
			
			//same node is visited more than once (excludes first and last node)
			if (visitedNodes.contains(n) && i != (values.size()-1)) {
				System.out.println("Node " + n + " visited more than once");
				return false;
			} 
			
			visitedNodes.add(n);
			
			//checks if value do not have corresponding node in the graph
			if (!g.containsNode(n)) {
				System.out.println("This node does not exist in the graph");
				return false;
			}
		
			//checks if the input is not a valid path (i.e., there is a sequence of nodes in the List that are not connected by an edge)
			if (i < values.size()-1) {
				String nextNode = values.get(i+1);
				if (!g.getNodeNeighbors(n).contains(nextNode)) {
					System.out.println("Invalid path: " + n + " to " + nextNode);
					return false;
				}
			} else {
				String firstNode = values.get(0);
				if (n != firstNode) { 
					System.out.println("First and last nodes not the same"); 
					return false;
				}
			}	
			
		}
 		
		System.out.println("Valid Hamiltonian Cycle");
		return true;
	}
	
	
	
	public static void main(String[] args) {
		Graph ug = GraphBuilder.buildUndirectedGraph("graph_builder_test.txt");
		Graph dg = GraphBuilder.buildDirectedGraph("graph_builder_test2.txt");
		
		//System.out.println(GraphUtils.minDistance(ug, "0", "6"));
		//System.out.println(GraphUtils.nodesWithinDistance(ug, "1", 1));
		
		
		//List<String> input = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "A"));
	List<String> input = new ArrayList<>(Arrays.asList("A", "B", "A"));
		
		System.out.println(GraphUtils.isHamiltonianCycle(dg, input));
	}
	
}
