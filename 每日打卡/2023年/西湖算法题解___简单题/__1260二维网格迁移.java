package 西湖算法题解___简单题;

import java.util.ArrayList;
import java.util.List;

public class __1260二维网格迁移 {

	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int col = grid.length;  //行
		int row = grid[0].length;   //列
		int mat[][] = new int[col][row];
		List<List<Integer>> helper = new ArrayList<List<Integer>>();
		//既然是平移，那么就直接考虑平移K次的情形
			for (int i=0;i<row;i++) {
				int tcol = (i + k) % row, trow = ((i + k) / row) % col, index = 0;
				while (index != col) {
					mat[(trow++) % col][tcol] = grid[index++][i];
				}
			}
			for (int i=0;i<col;i++){
				List<Integer> alist = new ArrayList<>();
				for (int j=0;j<row;j++){
					alist.add(mat[i][j]);
					helper.add(alist);
				}
			}
		return helper;
		}


}
