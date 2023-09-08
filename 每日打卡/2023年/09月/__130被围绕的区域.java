package 西湖算法题解___中等题;

public class __130被围绕的区域 {
	public static void main(String[] args) {

	}

	private int n_col,m_row;
	public void solve(char[][] board) {
		n_col = board.length;
		m_row = board[0].length;
		if (n_col==0 || m_row==0){
			return;
		}
		//--------------------------------------------------------
		//只要边上有元素，那么就一定不会被包围，我们就要去检查一下边上的关联了多少个 'X'
		for (int i=0;i<n_col;i++){
			dfs(board,i,0);
			dfs(board,i,m_row-1);
		}
		for (int i=1;i<m_row-1;i++){
			dfs(board,0,i);
			dfs(board,n_col-1,i);
		}

		//--------------------------------------------------------
		//再全部重新遍历里面的情况
		for (int i=0;i<n_col;i++){
			for (int j=0;j<m_row;j++){
				if (board[i][j] == 'A'){
					//说明当前位置是0，且不会被包裹
					board[i][j] = 'O';
				} else if (board[i][j] == 'O'){
					//说明这些是中间被包裹了的0，要被转化成   'X'
					board[i][j] = 'X';
				}
			}
		}
	}

	/**
	 *
	 * @param board
	 * @param x
	 * @param y
	 */
	private void dfs(char[][] board, int x, int y) {
		if (x<0||x>=n_col||y<0||y>=m_row||board[x][y] != 'O'){
			return;
		}
		//如果当前点在区域里面，且等于0
		board[x][y] = 'A';  //如果等于0，那么就做个标记
		//往四个方向去遍历
		dfs(board,x+1,y);
		dfs(board,x-1,y);
		dfs(board,x,y+1);
		dfs(board,x,y-1);
	}
}
