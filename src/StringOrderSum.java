
public class StringOrderSum {
	public String reorder(String s){
		int[] A = new int[26];
		int sum = 0;
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(isDigit(c)){
				sum += c - '0';
			}else{
				A[c-'A'] += 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < A.length; i++){
			while(A[i]!=0){
				sb.append((char)(i+'A'));
				A[i]--;
			}
		}
		sb.append(sum);
		return sb.toString();
	}
	
	private boolean isDigit(char c){
		return c - '0' >= 0 && '9' - c >=0;
	}
	
	public static void main(String[] args) {
		StringOrderSum solution = new StringOrderSum();
		System.out.println(solution.reorder("CAE2W3A"));
	}
}
