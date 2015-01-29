import beans.TreeNode;

public class ConvertBSTtoLinkedList {
	public TreeNode convert(TreeNode root){
		helper(root);
		return dummy.right;
	}
	
	private TreeNode dummy = new TreeNode(0), temp = dummy;
	
	private void helper(TreeNode root){
		if(root == null){
			return;
		}
		helper(root.left);
		temp.right = root;
		root.left = null;
		temp = temp.right;
		helper(root.right);
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
		ConvertBSTtoLinkedList solution = new ConvertBSTtoLinkedList();
		TreeNode root = solution.convert(n1);
		while(root!=null){
			System.out.println(root.val);
			root = root.right;
		}
	}
}
