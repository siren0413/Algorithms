
public class DetermineStringIsNumber {
	public static boolean isNumber(String s){
		if(s == null || s.length() == 0) return false;
		int i = 0;
		if(s.charAt(i)=='+' || s.charAt(i)=='-'){
			i++;
		}
		boolean dot = false;
		while(i < s.length()){
			if(s.charAt(i)=='.'){
				if(dot || i-1 < 0 || !isDigit(s.charAt(i-1))){
					return false;
				}
				dot = true;
			}else if(!isDigit(s.charAt(i))){
				return false;
			}
			i++;
		}
		return true;
	}
	
	private static boolean isDigit(char c){
		return c-'0' >= 0 && '9'-c >=0;
	}
	
	public static void main(String[] args) {
		System.out.println(isNumber("+1.134213"));
	}
}
