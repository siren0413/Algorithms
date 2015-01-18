
public class NextIncreasingInteger {
	public static int getNext(int n){
		n++;
		int div = 1;
		while(n / div > 0){
			div *= 10;
		}
		div /= 10;
		int[] x = new int[1];
		x[0] = n;
		if(!helper(x, div, 0)){
			x[0] = div * 10;
			helper(x, div * 10, 0);
		}
		return x[0];
	}
	
	private static boolean helper(int[] n, int div, int prev){
		if(div == 0) return true;
		int digit = (n[0] % (div*10))/ div;
		if(prev == 9 || digit == 9) return false;
		if(digit <= prev){
			int newDigit = prev + 1;
			n[0] = ((n[0] +(newDigit-digit) * div) / div) * div;
		}
		digit = (n[0] % (div*10))/ div;
		while(!helper(n, div/10, digit)){
			if(digit == 9){
				return false;
			}
			n[0] = ((n[0] + div) / div) * div;
			digit = (n[0] % (div*10))/ div;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(getNext(199));
		System.out.println(getNext(789));
		System.out.println(getNext(213874));
		System.out.println(getNext(999));
		System.out.println(getNext(0));
		System.out.println(getNext(9));
		System.out.println(getNext(99));
		System.out.println(getNext(189));
		System.out.println(getNext(315));
		System.out.println(getNext(779));
	}
}
