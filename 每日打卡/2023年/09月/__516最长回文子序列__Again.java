package 西湖算法题解___中等题;

public class __516最长回文子序列__Again {
	public int longestPalindromeSubseq(String s) {
		/*
		1 <= s.length <= 1000
		s 仅由小写英文字母组成
		 */
		//两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
		StringBuilder s_reverse = new StringBuilder(s);
		s_reverse.reverse();
		int res = longestCommonSubseq(s,s_reverse);
		return res;
	}

	/**
	 *
	 * @param s
	 * @param s_reverse
	 * @return
	 */
	private int longestCommonSubseq(String s, StringBuilder s_reverse) {
		int m = s.length(),n = s_reverse.length();
		int dp_longestPalindromeSubseq [][] = new int[m+1][n+1];
		for (int i = 1;i<=m;i++){
			char ch1_i = s.charAt(i-1);
			for (int j = 1;j<=n;j++){
				char ch2_j = s_reverse.charAt(j-1);
				if (ch1_i == ch2_j){
					dp_longestPalindromeSubseq[i][j] = dp_longestPalindromeSubseq[i-1][j-1] + 1;
				}else {
					dp_longestPalindromeSubseq[i][j] = Math.max(dp_longestPalindromeSubseq[i-1][j],dp_longestPalindromeSubseq[i][j-1]);
				}
			}
		}
		return dp_longestPalindromeSubseq[m][n];
	}
}
