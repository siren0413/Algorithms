import java.util.*;

public class Decimal {
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(1, 333));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		Map<Integer, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		sb.append(numerator / denominator);
		numerator = numerator % denominator;
		if (numerator == 0) {
			return sb.toString();
		} else {
			sb.append('.');
		}
		while (numerator * 10 % denominator != 0
				&& !map.containsKey(numerator * 10 / denominator)) {
			map.put(numerator * 10 / denominator, sb.length());
			sb.append(numerator * 10 / denominator);
			numerator = numerator * 10 % denominator;
		}

		if (numerator * 10 % denominator == 0) {
			return sb.toString();
		}

		sb.insert(map.get(numerator * 10 / denominator), "(");
		sb.append(")");
		return sb.toString();
	}
}
