package 西湖算法题解___中等题;

public class __5最长回文子串__动态规划 {
	public static void main(String[] args) {

	}//public static void main(String[] args)

	/**
	 *
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if (s.length() <= 1){
			return s;
		}
		//记录最长子串的长度，以及初始位置
		int maxLen = 1,begin = 0;
		//s.charAt(i)每次都会 检查数组下标越界，因此先转换成字符数组，这一步非必需
		char [] charArray_s = s.toCharArray();

		//dp[i][j]表示s[i][j]是否是回文串
		boolean dp[][] = new boolean[s.length()][s.length()];
		//先给对角线元素值全部赋值为true
		for (int i=0;i<s.length();i++){
			dp[i][i] = true;
		}
		//注意：从左下角先填，动态规划本质上就是一种用空间换时间的算法
		for (int j=1;j<s.length();j++){
			for (int i=0;i<j;i++){
				if (charArray_s[i] != charArray_s[j]){
					dp[i][j] = false;
				}else {
					//如果只剩两个元素
					if (j-i <3){
						dp[i][j] = true;
					}else {     ////如果还剩很多个元素
						dp[i][j] = dp[i+1][j-1];
					}
				}

				//只要dp[i][j] == true 成立，就表示子串s[i..j]是回文，此时记录回文长度和起始位置
				//dp[i][j] = dp[i+1][j-1];
				if (dp[i][j] && j-i+1 > maxLen){
					maxLen = j-i+1;
					begin = i;
				}
			}
		}
	return s.substring(begin,begin+maxLen);
	}

}
