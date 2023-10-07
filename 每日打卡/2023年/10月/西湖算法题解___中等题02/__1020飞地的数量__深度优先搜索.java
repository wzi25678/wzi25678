package 西湖算法题解___中等题02;

public class __1020飞地的数量__深度优先搜索 {
	/**
	 输入：    输入的是，矩阵各个点的位置情况
	 输出：
	    1.先找到是否有在边界上的点，或者里面的点到边界的距离
	    2.得有一个dfs，去判断当前位置是否满足条件，即（上、下、左、右）
	    3.每个点自带坐标，可以直接知道它距离最近的边界的距离，因此我需要对这个【距离最近的边界的距离】与【距离最近飞地距离】去判断。

	 通俗的说，这道题就是求没有与边界相邻的单元格数。

	 * @param grid
	 * @return
	 */

	private static int [][] directions = {
			{-1,0},{1,0},{0,-1},{0,1}
	};      //定义出上下左右移动的四个方向
	private int m,n;
	private boolean [][] visited;

	public int numEnclaves(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		visited = new boolean[m][n];
		//先把外面一圈给遍历一下
		for (int i=0;i<m;i++){
			dfs_numEnclaves(grid,i,0);
			dfs_numEnclaves(grid,i,n-1);
		}
		for (int j=1;j<n-1;j++){    //不能算重复了，因为dfs会记录是否访问过
			dfs_numEnclaves(grid,0,j);
			dfs_numEnclaves(grid,m-1,j);
		}
		//------------------------------------------------------------------------
		int ans = 0;
		//然后在对里面的每一个元素进行遍历
		for (int i=1;i<m-1;i++){
			for (int j=1;j<n-1;j++){
				if (grid[i][j] == 1 && !visited[i][j]){
					ans++;
				}
			}
		}
		return ans;
	}

	/**
	 *
	 * @param grid
	 * @param row
	 * @param col
	 */
	private void dfs_numEnclaves(int[][] grid, int row, int col) {
		if (row < 0 || row >= m || col < 0 ||col>=n || grid[row][col] == 0 || visited[row][col]){
			return;
		}
		//能走到这个，说明是内部点，且为1，没被访问
		visited[row][col] = true;
		for (int dir[]:directions){     //然后这个点想四周方向去遍历
			dfs_numEnclaves(grid,row+dir[0],col+dir[1]);
		}
	}
}
