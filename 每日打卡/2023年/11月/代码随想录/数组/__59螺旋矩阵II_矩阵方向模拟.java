//package 日常Java程序测试.代码随想录.数组;
//
//public class __59螺旋矩阵II_矩阵方向模拟 {
//	/**
//	 *
//	 * @param n
//	 * @return
//	 */
//	public int[][] generateMatrix(int n) {
//		int maxNum = n * n;
//		int curNum = 1;
//		int matrix [][] = new int[n][n];
//		int rows = 0,columns = 0;
//		int [][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};    //模拟正常行进路线：右下左上
//		int dirIndex = 0;   //为当前位置附一个值
//		while (curNum <= maxNum){
//			matrix[rows][columns] = curNum;
//			curNum++;
//			int nextRow = rows + dirs[dirIndex][0],nextCol = columns + dirs[dirIndex][1];
//		}
//
//
//	}
//}
