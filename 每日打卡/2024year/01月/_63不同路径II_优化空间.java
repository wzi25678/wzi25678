package 代码随想录.动态规划;

public class _63不同路径II_优化空间 {
    /**
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int dp [] = new int[col];
        for (int j = 0;j<col && obstacleGrid[0][j] == 0;j++){
            dp[j] = 1;
        }
        //只盯着边界情况看
        for (int i = 1;i<row;i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                } else if (j != 0) {
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[col-1];
    }
}
