package 代码随想录.动态规划.小总结240411;

public class _474一和零_三维dp {
    /**
     *
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int length= strs.length;
        int [][][] dp = new int[length+1][m+1][n+1];
        for (int i=1; i<=length; i++){
            int [] zerosAndOnes= getNumsOfZerosAndOnes(strs[i-1]);
            int zeros = zerosAndOnes[0],ones = zerosAndOnes[1];
            for (int j = 0;j<=m;j++){
                for (int k = 0;k<=n;k++){
                    dp[i][j][k] = dp[i-1][j][k];
                    if (j >=zeros &&  k>=ones){
                        dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j - zeros][k-ones]+1);
                    }
                }
            }
        }
        return dp[length][m][n];
    }

    private int[] getNumsOfZerosAndOnes(String str) {
        int [] zerosOnes = new  int[2];
        int  length = str.length();
        for (int i = 0;i<length;i++){
            zerosOnes[str.charAt(i)  - '0']++;
        }
        return zerosOnes;
    }

}
