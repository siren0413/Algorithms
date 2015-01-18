import java.util.*;
import beans.*;

public class BinaryTreeSerialization {
	public static String serialize(TreeNode root){
		if(root == null) return "n";
		StringBuilder sb = new StringBuilder();
		List<String> list = new LinkedList<>();
		helper(root, list);
		for(int i = 0; i < list.size(); i++){
			sb.append(list.get(i));
			if(i != list.size()-1){
				sb.append(" ");
			}
		}
		return sb.toString();
	}
	
	private static void helper(TreeNode root, List<String> list){
		if(root == null){
			list.add("null");
			return;
		}
		list.add(String.valueOf(root.val));
		helper(root.left, list);
		helper(root.right, list);
	}
	
	public static TreeNode deserialize(String s){
		if(s == null || s.isEmpty()) return null;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		String[] split = s.split("\\s");
		for(int i = split.length-1; i >= 0; i--){
			if("null".equals(split[i])){
				stack.push(null);
			}else{
				TreeNode node = new TreeNode(Integer.valueOf(split[i]));
				node.left = stack.pop();
				node.right = stack.pop();
				stack.push(node);
			}
		}
		if(!stack.isEmpty()){
			return stack.pop();
		}
		return null;
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
		String s = serialize(n1);
		System.out.println(s);
		TreeNode root = deserialize(s);
		inorder(root);
	}
	private static void inorder(TreeNode root){
		if(root == null) return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
}
