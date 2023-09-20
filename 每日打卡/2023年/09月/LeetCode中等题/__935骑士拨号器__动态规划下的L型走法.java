package LeetCode中等题;

import java.util.Arrays;

public class __935骑士拨号器__动态规划下的L型走法 {
    /**
     *
     * @param n
     * @return
     */
    public int knightDialer(int n) {
        int mod = 1000000007;
        int [][] moves = new int[][]{
            {4,6},{6,8},{7,9},{4,8},{3,9,0},
            {},{1,7,0},{2,6},{1,3},{2,4}};
        int dp_knightDialer [][] = new int[2][10];
        Arrays.fill(dp_knightDialer[0],1);
        for (int hopes = 0;hopes < n-1;hopes++){
            Arrays.fill(dp_knightDialer[~hopes & 1],0);
            for (int node = 0;node < 10;node++){
                for (int nei:moves[node]){
                    dp_knightDialer[~hopes & 1][nei] += dp_knightDialer[hopes & 1][node];
                    dp_knightDialer[~hopes & 1][nei] %= mod;
                }
            }
        }
        long res = 0;
        for (int x:dp_knightDialer[~n & 1]){
            res += x;
        }
        return (int)(res % mod);
    }
}
