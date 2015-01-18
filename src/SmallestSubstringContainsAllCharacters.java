import java.util.*;

public class SmallestSubstringContainsAllCharacters {
	public static String findWindow(String s) {
		if (s == null || s.isEmpty())
			return s;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), 0);
			}
			map.put(s.charAt(i), map.get(s.charAt(i))+1);
		}
		Map<Character, Integer> count = new HashMap<>();
		int i = 0, j = 0, min = s.length();
		String sub = s;
		while (j < s.length()) {
			if(!count.containsKey(s.charAt(j))){
				count.put(s.charAt(j), 0);
			}
			count.put(s.charAt(j), count.get(s.charAt(j))+1);
			j++;
			while (i < j && count.size() == map.size()) {
				if (count.get(s.charAt(i)) == 1) {
					if (j - i< min) {
						min = j - i;
						sub = s.substring(i, j);
					}
					count.remove(s.charAt(i));
					break;
				}
				count.put(s.charAt(i), count.get(s.charAt(i))-1);
				i++;
			}
		}
		return sub;
	}
	
	public static void main(String[] args) {
		System.out.println(findWindow("uuufdifouc"));
	}
}
