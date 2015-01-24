
public class KPalindrome {
	public boolean isKPalindrome(String s, int k){
		return helper(s, k, 0, s.length()-1);
	}
	
	private boolean helper(String s, int k, int i, int j){
		if(k < 0){
			return false;
		}
		if(i == j){
			return true;
		}
		if(s.charAt(i) == s.charAt(j)){
			return helper(s, k, i+1, j-1);
		}else{
			if(helper(s, k-1, i+1, j)) return true;
			if(helper(s, k-1, i, j-1)) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		KPalindrome solution = new KPalindrome();
		System.out.println(solution.isKPalindrome("abxa", 1));
		System.out.println(solution.isKPalindrome("abdxa", 1));
	}
}
