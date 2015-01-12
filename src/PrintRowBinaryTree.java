import java.util.*;
import beans.*;

public class PrintRowBinaryTree {
	public static void printRows(TreeNode root){
		if(root == null) return;
		TreeNode s = new TreeNode(0);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		queue.add(s);
		while(!queue.isEmpty()){
			TreeNode node = queue.poll();
			if(node == s){
				if(queue.isEmpty()){
					return;
				}
				System.out.println("");
				queue.add(s);
				continue;
			}
			System.out.print(node.val+" ");
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		printRows(n1);
	}
}
