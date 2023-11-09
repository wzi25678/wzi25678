package 日常Java程序测试.代码随想录.数组;

public class __59螺旋矩阵II_直接构造 {
	/**
	 * 输入一个数，构造它的平方矩阵，按螺旋方向生成。
	 * 题目很直白，就是考察边界情况的考量
	 *
	 *
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix(int n) {
		int res [][] = new int[n][n];
		int sum = 1;    //用于记录当前应该给哪个数
		int rows = res.length - 1,column = res[0].length-1;
		int right = 0,left = 0;
		while (sum <= n*n){
			//上,判断
			for (int i = left;i<=column - left;i++ ){
				res[right][i] = sum;
				sum++;
			}
			if (sum > n*n){
				break;
			}
			//右，判断
			for (int i = right + 1;i<=rows - right;i++){
				res[i][column - left] = sum;
				sum++;
			}
			if (sum > n*n){
				break;
			}
			//下，判断
			for (int i = column - 1 - left;i>=left;i--){
				res[rows - right][i] = sum;
				sum++;
			}
			if (sum > n*n){
				break;
			}
			//左，判断
			for (int i = rows - 1 - right;i>=right + 1;i--){
				res[i][left] = sum;
				sum++;
			}
			if (sum > n*n){
				break;
			}
			right++;
			left++;
		}
		return res;
	}
}
