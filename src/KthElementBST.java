public class KthElementBST {
	public TreeNode findKthNode(TreeNode root, int k){
		if(root == null) return null;
		int left = root.left==null?0:root.left.size+1;
		if(left == k-1){
			return root;
		}else if(left < k-1){
			return findKthNode(root.right, k-left-1);
		}else{
			return findKthNode(root.left, k);
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
		n1.size = 4;
		n2.size = 2;
		n3.size = 0;
		n4.size = 0;
		n5.size = 0;
		System.out.println(new KthElementBST().findKthNode(n1, 1).val);
		System.out.println(new KthElementBST().findKthNode(n1, 2).val);
		System.out.println(new KthElementBST().findKthNode(n1, 3).val);
		System.out.println(new KthElementBST().findKthNode(n1, 4).val);
		System.out.println(new KthElementBST().findKthNode(n1, 5).val);
		System.out.println(new KthElementBST().findKthNode(n1, 6));
	}
}

class TreeNode {
	TreeNode left, right;
	int size, val;

	public TreeNode(int val) {
		this.val = val;
		this.size = 0;
		left = null;
		right = null;
	}
}