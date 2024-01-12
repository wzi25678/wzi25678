package 代码随想录.动态规划;

public class _62不同路径 {
    /**
     *
     * 1.确定dp数组（dp table）以及下标的含义
     * 2.确定递推公式
     * 3.dp数组如何初始化
     * 4.确定遍历顺序
     * 5.举例推导dp数组
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        /*
         * 1.确定dp数组（dp table）以及下标的含义
         * dp[][]即模拟整个行走地图， 下标则为当前走到的位置,当前位置的值代表走到这里需要多少步
         *
         * 2.确定递推公式
         * 每次可以选择向下走一步，当然也可以选择向右走一步
         *
         * 3.dp数组如何初始化
         * 起始坐标00
         *
         * 4.确定遍历顺序
         * 向左，向下，，，但是要注意边界
         *
         * 5.举例推导dp数组
         * 0 1 1 1 1 1 1
         * 1
         * 1
         *
         * 走到每个位置的路径情况：
         * 0 1 1 1  1   1   1
         * 1 2 3 4  5   6   7
         * 1 3 6 10 15  21  28
         */
        int dp[][] = new int[m][n];
        //初始化
        for (int i = 0;i<m;i++){
            dp[i][0] = 1;
        }
        for (int i = 0;i<n;i++){
            dp[0][i] = 1;
        }
        for (int i = 1;i<m;i++){
            for (int j = 1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
