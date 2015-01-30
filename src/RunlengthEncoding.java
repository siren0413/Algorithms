
public class RunlengthEncoding {
	public String encode(String s){
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while(i < s.length()){
			int j = i+1;
			while(j < s.length() && s.charAt(i)==s.charAt(j)){
				j++;
			}
			sb.append(s.charAt(i));
			if(j-i>1){
				sb.append(j-i);
			}
			i = j;
		}
		return sb.toString();
	}
	
	public String decode(String s){
		int i = 0;
		StringBuilder sb = new StringBuilder();
		while(i < s.length()){
			int j = i+1;
			while(j < s.length() && isDigit(s.charAt(j))){
				j++;
			}
			sb.append(s.charAt(i));
			if(j-i > 1){
				int n = Integer.valueOf(s.substring(i+1, j))-1;
				while(n > 0){
					sb.append(s.charAt(i));
					n--;
				}
			}
			i = j;
		}
		return sb.toString();
	}
	
	private boolean isDigit(char c){
		return c-'0'>=0 && '9'-c >= 0;
	}
	
	public static void main(String[] args) {
		RunlengthEncoding solution = new RunlengthEncoding();
		String en = solution.encode("abcdefghijklmn");
		System.out.println(en);
		String de = solution.decode(en);
		System.out.println(de);
	}
}
