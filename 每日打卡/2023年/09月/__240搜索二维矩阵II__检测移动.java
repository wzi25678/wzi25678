package 西湖算法题解___中等题;

public class __240搜索二维矩阵II__检测移动 {
	public boolean searchMatrix(int[][] matrix, int target) {
		/*
		从第一行最右边开始可以最快的锁定是否应该在哪一行
		 */
		int col  = matrix.length;
		int row = matrix[0].length;
		int x = 0,y=row-1;
		while (x<col && y>= 0){     //一个监控上下，一个监控左右
			if (matrix[x][y] == target){
				return true;
			}
			if (matrix[x][y] > target){
				y--;
			}else {
				x++;
			}
		}
		return false;
	}
}
