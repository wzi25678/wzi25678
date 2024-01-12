package 代码随想录.动态规划;

public class 背包问题03 {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        int [] weight = {1,3,4};
        int [] value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight, value, bagSize);
    }

    /**
     *
     * @param weight
     * @param value
     * @param bagSize
     */
    private static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        int weightLen = weight.length;
        //定义dp数组；dp[j]表示背包内容为j时，能获得的最大价值。
        int [] dp = new int[bagSize + 1];
        //遍历顺序： 先遍历物品，再遍历背包容量
        for (int i = 0;i<weightLen;i++){
            for (int j = bagSize;j>=weight[i];j--){
                dp[j] = Math.max(dp[j],dp[j-weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0;j<=bagSize;j++){
            System.out.print(dp[j] + " ");
        }
        System.out.println();
    }

}
