import java.util.Arrays;
import java.util.*;
import beans.*;

public class ConstructBSTUsingPreorder {
	public static TreeNode construct(int[] preorder){
		if(preorder == null || preorder.length == 0){
			return null;
		}
		int[] inorder = Arrays.copyOf(preorder, preorder.length);
		Arrays.sort(inorder);
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < inorder.length; i++){
			map.put(inorder[i],i);
		}
		return helper(preorder, inorder, 0, preorder.length-1, 0, map);
	}
	
	private static TreeNode helper(int[] preorder, int[] inorder, int i, int j, int k, Map<Integer,Integer> map){
		if(i > j){
			return null;
		}
		int val = preorder[k];
		int index = map.get(val);
		TreeNode root = new TreeNode(val);
		root.left = helper(preorder, inorder, i, index-1, k+1, map);
		root.right = helper(preorder, inorder, index+1, j, k + (index-i+1), map);
		return root;
	}
	
	public static void main(String[] args) {
		//int[] preorder = {5,3,1,4,7};
		int[] preorder = {5,3,9};
		TreeNode root = construct(preorder);
		inorder(root);
	}
	
	private static void inorder(TreeNode root){
		if(root == null) return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
}
