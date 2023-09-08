package 西湖算法题解___中等题;

public class __200岛屿数量 {

	/**
	 *
	 * @param grid
	 * @return
	 */
	public int numIslands(char[][] grid) {
		//类似走迷宫，主要就是【边界之内】，去【上下左右】，然后用一个visited[]去判断是否是否被遍历过，或者是否满足条件
		if (grid == null || grid.length == 0){
			return 0;
		}
		int col = grid[0].length;
		int row = grid.length;
		int num_islands = 0;
		for (int i = 0;i<col;i++){
			for (int j= 0;j<row;j++){
				if (grid[i][j] == '1'){
					num_islands++;  //岛与岛不能通，所以接下来从这个为1的点，向四周走去，同时又让它们四周为1的点转而为0
					dfs(grid,i,j);
				}
			}
		}
		return num_islands;
	}

	/**
	 *
	 * @param grid
	 * @param i_col
	 * @param j_row
	 */
	private void dfs(char[][] grid, int i_col, int j_row) {
		if (i_col<0 || j_row<0 || i_col>= grid.length || j_row >= grid[0].length || grid[i_col][j_row] == '0'){
			return;
		}
		//走到这里，说明等于1
		grid[i_col][j_row] = '0';
		dfs(grid,i_col-1,j_row);
		dfs(grid,i_col+1,j_row);
		dfs(grid,i_col,j_row-1);
		dfs(grid,i_col,j_row+1);
	}
}
