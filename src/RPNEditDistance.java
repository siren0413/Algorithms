public class RPNEditDistance {
	public static int distance(String s) {
		if (s == null || s.isEmpty())
			return 0;
		return helper(s, 0, 0);
	}

	private static int helper(String s, int i, int digit) {
		if (i == s.length()) {
			return (digit < 2) ? 0 : (digit - 1);
		}
		if (s.charAt(i) != '*') {
			return helper(s, i + 1, digit + 1);
		} else {
			if (digit < 2) {
				return helper(s, i + 1, digit) + 1;
			} else {
				return helper(s, i + 1, digit - 1);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(distance("xx*"));
		System.out.println(distance("x*x"));
		System.out.println(distance("*xx*"));
		System.out.println(distance("xxxx*"));
		System.out.println(distance("x*xxx"));
		//System.out.println(distance("***xx*xx*x*x******xxxx*xxxx*xxx***xxxx*x**xxx**xx*xxx***xxxx*xxx***xx***x**xxx*x*x*xxxxx**x**xxx"));
	}
}
