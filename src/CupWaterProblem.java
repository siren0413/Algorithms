import java.util.*;


public class CupWaterProblem {
	public int ithCup(int i, int C, int M){
		if(i == 1) return Math.min(C,M);
		List<Integer> up = new ArrayList<>();
		up.add(M);
		int n = 1;
		while(true){
			List<Integer> down = new ArrayList<>();
			for(int m = 0; m < up.size()+1; m++){
				if(m == 0){
					down.add((up.get(m)-C)/2);
				}else if(m == up.size()){
					down.add((up.get(up.size()-1)-C)/2);
				}else{
					down.add((up.get(m-1)-C)/2 + (up.get(m)-C)/2);
				}
				n++;
				if(n == i){
					return Math.min(C, down.get(m));
				}
			}
			up = down;
		}
	}
	
	public static void main(String[] args) {
		CupWaterProblem solution = new CupWaterProblem();
		System.out.println(solution.ithCup(1, 2, 10));
		System.out.println(solution.ithCup(2, 2, 10));
		System.out.println(solution.ithCup(3, 2, 10));
		System.out.println(solution.ithCup(4, 2, 10));
		System.out.println(solution.ithCup(5, 2, 10));
		System.out.println(solution.ithCup(6, 2, 10));
		System.out.println(solution.ithCup(7, 2, 10));
		System.out.println(solution.ithCup(8, 2, 10));
		System.out.println(solution.ithCup(9, 2, 10));
	}
}
