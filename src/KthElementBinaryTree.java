
public class KthElementBinaryTree {
	
	private int kthNum = 0, count = 0;
	
	public int kthElement(TreeNode root, int k){
		helper(root, k);
		return kthNum;
	}
	
	private void helper(TreeNode root, int k){
		if(root == null) {
			return;
		}
		helper(root.left, k);
		count++;
		if(count == k){
			kthNum = root.val;
			return;
		}
		helper(root.right, k);
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(4);
		n1.left = n2;
		n1.right = n3;
		n2.left= n4;
		n2.right = n5;
		KthElementBinaryTree solution = new KthElementBinaryTree();
		System.out.println(solution.kthElement(n1, 4));

	}
}
