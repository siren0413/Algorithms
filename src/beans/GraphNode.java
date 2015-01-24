package beans;

import java.util.*;

public class GraphNode {
	public int val;
	public List<GraphNode> adjacents;
	public GraphNode(int val){
		this.val = val;
		adjacents = new LinkedList<>();
	}
}
