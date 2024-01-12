package 代码随想录.动态规划.小总结240411;

public class _474一和零_dp {
    /**
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int [][] dp  = new int[m+1][n+1];
        int length = strs.length;
        for (int i = 0; i < length; i++) {
            int [] zerosAndOnes = getNumsOfZerosAndOnes(strs[i]);
            int zeros = zerosAndOnes[0],ones = zerosAndOnes[1];
            for (int j = m; j >= zeros; j--) {
                for (int k = n; k >= ones; k--){
                    dp[j][k] = Math.max(dp[j][k],dp[j-zeros][k-ones]+1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] getNumsOfZerosAndOnes(String str) {
        int [] zerosOnes = new int[2];
        int length = str.length();
        for (int i = 0;i<length;i++){
            zerosOnes[str.charAt(i) - '0']++;
        }
        return zerosOnes;
    }

}
