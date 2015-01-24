import java.util.*;
import beans.GraphNode;

public class PrintPathInGraph {
	public void printPath(GraphNode src, GraphNode dest){
		List<GraphNode> path = new LinkedList<>();
		Set<GraphNode> visit = new HashSet<>();
		path.add(src);
		helper(src, dest, path, visit);
	}
	
	private void helper(GraphNode src, GraphNode dest, List<GraphNode> path, Set<GraphNode> visit){
		if(visit.contains(src)){
			return;
		}
		if(src == dest){
			for(GraphNode node: path){
				System.out.print(node.val+" ");
			}
			System.out.println();
		}
		visit.add(src);
		for(GraphNode node: src.adjacents){
			path.add(node);
			helper(node, dest, path, visit);
			path.remove(path.size()-1);
		}
		visit.remove(src);
	}
	
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
		GraphNode n2 = new GraphNode(2);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(4);
		GraphNode n5 = new GraphNode(5);
		GraphNode n6 = new GraphNode(6);
		n1.adjacents.add(n2);
		n1.adjacents.add(n3);
		n2.adjacents.add(n4);
		n2.adjacents.add(n6);
		n3.adjacents.add(n6);
		
		PrintPathInGraph solution = new PrintPathInGraph();
		solution.printPath(n1, n6);
	}
}
