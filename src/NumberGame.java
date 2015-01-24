
public class NumberGame {
	public void solve(int n){
		String bin = toBinary(n);
		int zero = 0, moves = 0;
		for(int i = bin.length()-1; i >= 0; i--){
			if(bin.charAt(i) == '0'){
				zero++;
			}
			if(bin.charAt(i) =='1'){
				moves+= zero;
			}
		}
		if(moves % 2 == 0){
			System.out.println("A lose game");
		}else{
			System.out.println("B lose game");
		}
	}
	
	private String toBinary(int n){
		StringBuilder sb = new StringBuilder();
		while(n > 0){
			sb.insert(0, n % 2);
			n /= 2;
		}
		if(sb.length() == 0){
			return "0";
		}
		return sb.toString();
	}
	
	private String toBinary2(int n){
		StringBuilder sb = new StringBuilder();
		while(n > 0){
			sb.insert(0, (n&1)==1?1:0);
			n >>= 1;
		}
		if(sb.length() == 0){
			return "0";
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		NumberGame solution = new NumberGame();
		solution.solve(37);
	}
}
