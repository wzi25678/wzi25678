package 代码随想录.动态规划;

public class 完全背包理论基础 {
    //完全背包和01背包问题唯一不同的地方就是，每种物品有无限件。
    public static void main(String[] args) {
        //先遍历物品，再遍历背包
        priorityItems();
        System.out.println();
        //先遍历背包，再遍历物品
        priorityBag();
    }

    /**
     * 先遍历背包，再遍历物品
     */
    private static void priorityBag() {
        int [] weights =  {1,3,4};
        int [] values = {15,20,30};
        int bagWeight = 4;
        int [] dp = new int[bagWeight + 1];
        for (int i = 1; i <= bagWeight;i++){    //遍历背包容量
            for (int j = 0;j<weights.length;j++){   //遍历物品
                if (i - weights[j] >= 0){
                    dp[i] = Math.max(dp[i],dp[i-weights[j]] + values[j]);
                }
            }
        }
        for (int maxValue : dp){
            System.out.print(maxValue + " ");
        }

    }

    /**
     * 先遍历物品，再遍历背包
     */
    private static void priorityItems() {
        int [] weights =  {1,3,4};
        int [] values = {15,20,30};
        int bagWeight = 4;
        int [] dp = new int[bagWeight + 1];
        for (int i = 0; i < weights.length;i++){    //遍历物品
            for (int j = weights[i];j<=bagWeight;j++){  //遍历背包容量
                dp[j] =  Math.max(dp[j],dp[j - weights[i]] + values[i]);
            }
        }
        for (int maxValue : dp){
            System.out.print(maxValue + " ");
        }
    }
}
