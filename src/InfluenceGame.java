
public class InfluenceGame {
	public static boolean exist(int[][] A){
		if(A == null || A.length ==0) return false;
		for(int j = 0; j < A[0].length; j++){
			boolean notInfluenced = true;
			for(int i = 0; i < A.length; i++){
				if(A[i][j] == 1){
					notInfluenced = false;
					break;
				}
			}
			if(notInfluenced){
				boolean influence = true;
				for(int m = 0; m < A[0].length; m++){
					if(m == j) continue;
					if(A[j][m] == 0){
						influence = false;
					}
				}
				if(influence) return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[][] A = {
				{0,0,0,1},
				{1,1,0,1},
				{1,1,0,1},
				{0,0,0,1}
		};
		System.out.println(exist(A));
		
	}
}
