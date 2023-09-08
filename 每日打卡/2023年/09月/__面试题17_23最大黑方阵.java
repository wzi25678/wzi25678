package 西湖算法题解___中等题;

public class __面试题17_23最大黑方阵 {
	public static void main(String[] args) {

	}

	public int[] findSquare(int[][] matrix) {
		int n_row = matrix.length;  //题目有说，输入的是一个方阵
		int m_col = matrix[0].length;
		int left[][] = new int[n_row+1][n_row+1];
		int up[][] = new int[n_row+1][n_row+1];
		int r = 0,c=0,size = 0;

		for (int i=1;i<=n_row;i++){
			for (int j=1;j<=n_row;j++){
				if (matrix[i-1][j-1] == 0){
					left[i][j] = left[i][j-1]+1;
					up[i][j] = up[i-1][j]+1;
					int border = Math.min(left[i][j],up[i][j]);
					while (left[i-border+1][j] < border ||  up[i][j - border + 1] < border){
						border--;
					}
					if (border > size){
						r = j-border;
						c = j-border;
						size = border;
					}
				}
			}
		}
		return  size > 0 ? new int[]{r, c, size} : new int[0];

	}
}
