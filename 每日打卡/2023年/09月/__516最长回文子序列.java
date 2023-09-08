package 西湖算法题解___中等题;

public class __516最长回文子序列 {
	/*
	输入：s = "bbbab"
	输出：4
	解释：一个可能的最长回文子序列为 "bbbb" 。
	 */
	//如上述题例，找【最长，长度】的【可以不连续，但是要顺序】的回文子串序列
	public int longestPalindromeSubseq(String s) {
		int sLength  = s.length();
		int [][] dp_longestPalindromeSubseq = new int[sLength][sLength];
		for (int i = sLength-1;i>=0;i--){
			dp_longestPalindromeSubseq[i][i] = 1;
			char ch1 = s.charAt(i);
			for (int j = i+1;j<sLength;j++){
				char ch2 = s.charAt(j);
				if (ch1 == ch2){
					dp_longestPalindromeSubseq[i][j] = dp_longestPalindromeSubseq[i+1][j-1] + 2;
				}else {
					dp_longestPalindromeSubseq[i][j] = Math.max(dp_longestPalindromeSubseq[i+1][j],dp_longestPalindromeSubseq[i][j-1]);
				}
			}
		}
		return dp_longestPalindromeSubseq[0][sLength-1];
	}
}
