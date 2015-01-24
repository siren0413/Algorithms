import beans.TreeNode;

public class SinkZeroBinaryTree {
	public static void sink(TreeNode root){
		if(root == null) return;
		if(root.val == 0){
			int temp = root.val;
			if(root.left!=null){
				root.val = root.left.val;
				root.left.val = temp;
			}else if(root.right!=null){
				root.val = root.right.val;
				root.right.val = temp;
			}
		}
		sink(root.left);
		sink(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(0);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		sink(n1);
		inorder(n1);
	}
	
	private static void inorder(TreeNode node){
		if(node == null) return;
		inorder(node.left);
		System.out.println(node.val);
		inorder(node.right);
	}
}
