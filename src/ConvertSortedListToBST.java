import beans.ListNode;
import beans.TreeNode;

public class ConvertSortedListToBST {
	
	private ListNode head;
	public TreeNode convert(ListNode head){
		if(head == null) return null;
		this.head = head;
		int len = 0;
		while(head!=null){
			head = head.next;
			len++;
		}
		return buildBST(0, len-1);
	}
	
	private TreeNode buildBST(int start, int end){
		if(start > end){
			return null;
		}
		int mid = start +(end - start)/2;
		TreeNode left = buildBST(start, mid-1);
		TreeNode root = new TreeNode(head.val);
		head = head.next;
		TreeNode right = buildBST(mid+1, end);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		ConvertSortedListToBST solution = new ConvertSortedListToBST();
		TreeNode root = solution.convert(l1);
		solution.inorder(root);
	}
	
	private void inorder(TreeNode root){
		if(root == null)return;
		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);
	}
}
