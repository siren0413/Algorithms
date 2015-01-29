import beans.TreeNode;

public class BinaryTreeSubset {
	public boolean isSubset(TreeNode root, TreeNode node){
		if(root == null){
			return false;
		}
		if(root.val == node.val){
			if(helper(root, node)){
				return true;
			}
		}
		return isSubset(root.left, node) || isSubset(root.right, node);
	}
	
	private boolean helper(TreeNode root, TreeNode node){
		if(node == null){
			return true;
		}
		if(root == null || root.val != node.val){
			return false;
		}
		return helper(root.left, node.left) && helper(root.right, node.right);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		
		TreeNode m1 = new TreeNode(6);
		TreeNode m2 = new TreeNode(5);
		TreeNode m3 = new TreeNode(12);
		TreeNode m4 = new TreeNode(4);
		TreeNode m5 = new TreeNode(7);
		TreeNode m6 = new TreeNode(8);
		TreeNode m7 = new TreeNode(10);
		TreeNode m8 = new TreeNode(1);
		m1.left = m2;
		m1.right = m3;
		m2.left = m4;
		m2.right = m5;
		m3.left = m6;
		m3.right = m7;
		m4.left = m8;
		
		BinaryTreeSubset solution = new BinaryTreeSubset();
		System.out.println(solution.isSubset(m1, n1));
	}
	
}
