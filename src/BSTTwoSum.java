import beans.TreeNode;

public class BSTTwoSum {
	
	public boolean isExist(TreeNode root, int sum){
		return helper(root, root, sum);
	}
	
	private boolean helper(TreeNode root, TreeNode node, int sum){
		if(node == null){
			return false;
		}
		if(find(root, sum - node.val)){
			return true;
		}
		return isExist(node.left, sum) || isExist(node.right, sum);
	}
	
	private boolean find(TreeNode root, int n){
		if(root == null){
			return false;
		}
		if(n == root.val){
			return true;
		}
		if(n > root.val){
			return find(root.right, n);
		}else{
			return find(root.left,n);
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
		BSTTwoSum solution = new BSTTwoSum();
		System.out.println(solution.isExist(n1, 9));
	}
}
