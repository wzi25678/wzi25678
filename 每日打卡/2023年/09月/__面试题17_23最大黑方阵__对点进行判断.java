package 西湖算法题解___中等题;

public class __面试题17_23最大黑方阵__对点进行判断 {
	public static void main(String[] args) {

	}

	public int[] findSquare(int[][] matrix) {
		int n  = matrix.length;
		int [][][] dp = new int[n][n][2];
		int size = 0;
		int r = 0,c=0;
		//--------------------------------------------------------------
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				//对整个矩阵，所有元素进行检查
				if (matrix[i][j] == 0){
					dp[i][j][0] = 1 + (j > 0 ? dp[i][j-1][0] : 0);
					dp[i][j][1] = 1 + (i > 0 ? dp[i][j-1][1] : 0);
				}
			}
		}
		//-----------------------------------------------------------------
		for (int i=0;i<n;i++) {
			for (int j = 0; j < n; j++) {
				for (int side = Math.min(dp[i][j][0],dp[i][j][1]); side >= 1;side--){
					if (dp[i][j-side+1][1] >= side && dp[i-side+1][j][0] >= side){
						if (side > size){
							size = side;
							r = i -side +1;
							c = j - side + 1;
							break;
						}
					}
				}
			}
		}
		if (r == -1 && c==-1){
			return new int[0];
		}else {
			return new int[]{r,c,size};
		}
	}
}
