
public class OneEditDistance {
	public static boolean oneEditDistance(String a, String b){
		if(a == null || b == null) return true;
		int i = 0, j = 0;
		while(i < a.length() && j < b.length()){
			char ci = a.charAt(i);
			char cj = b.charAt(j);
			if(ci != cj){
				boolean delete = a.substring(i+1, a.length()).equals(b.substring(j, b.length()));
				boolean insert = a.substring(i, a.length()).equals(b.substring(j+1, b.length()));
				boolean replace = a.substring(i+1, a.length()).equals(b.substring(j+1, b.length()));
				return delete | insert | replace;
			}
			i++;
			j++;
		}
		return Math.abs(a.length()-b.length()) <= 1;
	}
	
	public static void main(String[] args) {
		System.out.println(oneEditDistance("", "ab"));
	}
}
