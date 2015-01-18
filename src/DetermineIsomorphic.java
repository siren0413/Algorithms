import java.util.*;

public class DetermineIsomorphic {
	public static boolean isIsomorphic(String a, String b){
		Set<Character> set = new HashSet<>();
		int s1 = 0, s2 = 0;
		for(int i = 0; i < a.length(); i++){
			set.add(a.charAt(i));
		}
		s1 = set.size();
		set.clear();
		for(int i = 0; i < b.length(); i++){
			set.add(b.charAt(i));
		}
		s2 = set.size();
		return s1 == s2;
	}
	
	public static void main(String[] args) {
		System.out.println(isIsomorphic("foo", "bar"));;
		System.out.println(isIsomorphic("foo", "app"));;
	}
}
