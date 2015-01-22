import java.util.*;

public class CheatDetection {
	public static boolean isCheat(String a, String b, int n){
		Set<String> set = new HashSet<>();
		for(int i = 0; i+n <= a.length(); i++){
			set.add(a.substring(i, i+n));
		}
		for(int i = 0; i+n <= b.length(); i++){
			if(set.contains(b.substring(i, i+n))){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isCheat("hahnihao", "niha", 3));
	}
}
