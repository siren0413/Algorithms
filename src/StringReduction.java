
public class StringReduction {
	public int reduce(String s){
		if(s == null || s.isEmpty()) return 0;
		StringBuilder sb = new StringBuilder(s);
		int i = 0, sum = 'a' + 'b' +'c';
		while(i < sb.length()){
			if(i-1 >=0 && sb.charAt(i-1)!=sb.charAt(i)){
				helper(sb, i-1, i, sum);
			}else if(i+1 < sb.length() && sb.charAt(i)!=sb.charAt(i+1)){
				helper(sb, i, i+1, sum);
			}else{
				i++;
			}
		}
		return sb.length();
	}
	
	private void helper(StringBuilder sb, int i, int j, int sum){
		char a = sb.charAt(i);
		char b = sb.charAt(j);
		sb.deleteCharAt(i);
		sb.deleteCharAt(i);
		sb.insert(i, (char)(sum-a-b));
	}
	
	public static void main(String[] args) {
		StringReduction solution = new StringReduction();
		System.out.println(solution.reduce("cab"));
		System.out.println(solution.reduce("bcab"));
		System.out.println(solution.reduce("ccccc"));
	}
}
