
public class FindPath {
	public boolean isExist(char[][] board, int i, int j){
		boolean[][] visit = new boolean[board.length][board[0].length];
		return helper(board, i, j, visit);
	}
	
	private boolean helper(char[][] board, int i, int j, boolean[][] visit){
		if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || visit[i][j] || board[i][j]=='w'){
			return false;
		}
		if(board[i][j] =='X'){
			return true;
		}
		visit[i][j] = true;
		if(helper(board,i+1,j,visit)) return true;
		if(helper(board,i-1,j,visit)) return true;
		if(helper(board,i,j+1,visit)) return true;
		if(helper(board,i,j-1,visit)) return true;
		return false;
	}
	
	public static void main(String[] args) {
		char[][] board = {
				{'.','.','.','.'},
				{'.','O','w','.'},
				{'.','w','w','.'},
				{'.','w','.','X'}
		};
		FindPath solution = new FindPath();
		System.out.println(solution.isExist(board, 1, 1));
	}
}
