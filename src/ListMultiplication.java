import beans.Node;

public class ListMultiplication {
	public static String multiply(Node h1, Node h2){
		int len1 = 0, len2 = 0;
		Node temp = h1;
		while(temp!=null){
			temp = temp.next;
			len1++;
		}
		temp = h2;
		while(temp!=null){
			temp = temp.next;
			len2++;
		}
		int[] digit = new int[len1+len2];
		len1--;
		len2--;
		temp = h2;
		int t_len2 = len2;
		while(len1 >= 0){
			int left = h1.val;
			h2 = temp;
			len2 = t_len2;
			while(len2 >= 0){
				int right = h2.val;
				digit[len1+len2] += left * right;
				len2--;
				h2 = h2.next;
			}
			len1--;
			h1 = h1.next;
		}
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < digit.length; i++){
			int num = carry + digit[i];
			sb.insert(0,num % 10);
			carry = num / 10;
		}
		while(sb.length()!=0 && sb.charAt(0)=='0'){
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Node n1 = new Node(3);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		
		Node m1 = new Node(2);
		Node m2 = new Node(3);
		
		n1.next = n2;
		n2.next = n3;
		
		m1.next = m2;
		
		System.out.println(multiply(n1, m1));
	}
}
