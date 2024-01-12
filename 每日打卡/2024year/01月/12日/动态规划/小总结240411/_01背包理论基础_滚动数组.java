package 代码随想录.动态规划.小总结240411;

import java.util.Scanner;

public class _01背包理论基础_滚动数组 {
    public static void main(String[] args) {
        // TODO 假设物品种类为M,背包容量为N
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        //对物品赋予其对应该有的价值与重量
        int values [] = new int [M];
        int weights [] = new int [M];
        //给每一个重量与价值赋初始值
        for (int i = 0; i < M;i++){
            weights[i] = scanner.nextInt();
        }
        for (int i = 0;i<M;i++){
            values[i] = scanner.nextInt();
        }
        int dp [][] = new int[M][N+1];
        //初始化dp数组
        for (int i = weights[0];i<=N;i++){
            dp[0][i] = values[0];
        }
        //先遍历物品
        for (int i = 1;i<M;i++){
            //再遍历背包
            for (int j = 0;j<=N;j++){
                if (weights[i] > j){
                    dp[i][j] = dp[i-1][j];  //能背下，则考虑背上去的结果，存储到dp数组中。
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weights[i]] + values[i]);
                }
            }
        }
        System.out.println(dp[M-1][N]);
    }
}
