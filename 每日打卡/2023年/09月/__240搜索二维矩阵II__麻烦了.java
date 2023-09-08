package 西湖算法题解___中等题;

public class __240搜索二维矩阵II__麻烦了 {
	public boolean searchMatrix(int[][] matrix, int target) {
		/*
		解题思路：
			先找每一行第一个元素，如果第一个元素比target小，则进入下一行元素；
							  如果第一个元素比target大，则返回上一行元素，并从第二个开始检测
		 */
		int col = matrix.length;
		int row = matrix[0].length;
		int start_col = 0;
		int start_row = 0;
		int end_col = col;
		int end_row = row;
		while (true){
			for (int  i=start_col;i<end_col;i++){
				if (matrix[i][start_row] <target){
					if (i==end_col-1){
						start_row++;
						break;
					}
					continue;
				} else if (matrix[i][start_row] == target) {
					return true;
				}else {
					end_col = i-1;
					start_row++;
				}
			}
			for (int j=start_row;j<end_row;j++){
				if (matrix[start_col][j] < target){
					if (j == end_row -1){
						start_col++;
						break;
					}
					continue;
				} else if (matrix[start_col][j] == target) {
					return true;
				}else{
					end_row  = j-1;
					start_col++;
				}
			}
			if (start_col == end_col &&start_row == end_row){
				return false;
			}
		}

	}
}
