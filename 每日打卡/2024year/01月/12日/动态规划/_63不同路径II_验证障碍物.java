package 代码随想录.动态规划;

public class _63不同路径II_验证障碍物 {
    /**
     * 1.确定dp数组（dp table）以及下标的含义
     * 2.确定递推公式
     * 3.dp数组如何初始化
     * 4.确定遍历顺序
     * 5.举例推导dp数组
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
         * 1.确定dp数组（dp table）以及下标的含义
         * dp[][]即模拟整个行走地图， 下标则为当前走到的位置,当前位置的值代表走到这里需要多少步
         *
         * 2.确定递推公式
         * 每次可以选择向下走一步，当然也可以选择向右走一步
         * 第一行，第一列的所有dp[][]值均为1
         * dp[i][j] = dp[i-1][j] + dp[i][j-1];
         *
         * 3.dp数组如何初始化
         * 起始坐标1111111111，，，列也为11111111
         * 还得考虑障碍物，如果当前遍历过程中，遇到了障碍物，则无法通行，即不能算作一条有效路径。
         *
         * 4.确定遍历顺序
         * 向左，向下，，，但是要注意边界
         *
         * 5.举例推导dp数组
         *
         */
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int dp[][] = new int[row][col];

        //如果在起点或者终点出现了障碍物，则直接pass掉这个
        if (obstacleGrid[row-1][col-1] == 1 || obstacleGrid[0][0] == 1){
            return 0;
        }
        //对第一行，第一列进行初始化
        for (int i = 0;i<row && obstacleGrid[i][0] == 0;i++){
            dp[i][0] = 1;
        }
        for (int j = 0;j<col && obstacleGrid[0][j] == 0;j++){
            dp[0][j] = 1;
        }
        //然后往中间的元素，进行累加迭代，同时去判断是否某个路径中的元素等于0
        for (int i = 1;i<row;i++){
            for (int j = 1;j<col;j++){
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i-1][j]+dp[i][j-1] : 0;
            }
        }
        return dp[row-1][col-1];
    }
}
