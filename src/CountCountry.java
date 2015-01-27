
public class CountCountry {
	public int count(int[][] matrix){
		boolean[][] visit = new boolean[matrix.length][matrix[0].length];
		int count = 0;
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				if(!visit[i][j]){
					helper(matrix, i, j, matrix[i][j], visit);
					count++;
				}
			}
		}
		return count;
	}
	
	private void helper(int[][] matrix, int i, int j, int country, boolean[][] visit){
		if(i < 0 || i >matrix.length-1 || j < 0 || j >matrix[0].length-1 || matrix[i][j]!=country || visit[i][j]){
			return;
		}
		visit[i][j] = true;
		helper(matrix, i+1, j, country, visit);
		helper(matrix, i-1, j, country, visit);
		helper(matrix, i, j+1, country, visit);
		helper(matrix, i, j-1, country, visit);
	}
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,1,1,1},
				{0,0,0,0},
				{1,0,0,1}
		};
		CountCountry solution = new CountCountry();
		System.out.println(solution.count(matrix));
	}
}
