package 西湖算法题解___中等题02;

import java.util.Arrays;

public class __1371每个元音包含偶数次的最长子字符串 {   //1 <= s.length <= 5 x 10^5
	public static void main(String[] args) {
		//即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
		//字符串肯定越多越好，但是要注意元音字母
		//字母  --->  前缀（字典）去表示出来。
	}

	/**
	 *
	 * @param s
	 * @return
	 */
	public int findTheLongestSubstring(String s) {
		int n = s.length();
		int pos [] = new int[1 << 5]; //5个二进制位，代表5位元音字母。
		Arrays.fill(pos,-1);
		int ans = 0,status = 0;
		pos[0] = 0;
		for (int i = 0;i<n;i++){    //统计每个字符的奇偶
			char ch = s.charAt(i);
			if (ch == 'a'){
				status ^=(1 << 0);
			} else if (ch == 'e') {
				status ^=(1 << 1);
			} else if (ch == 'i') {
				status ^=(1 << 2);
			} else if (ch == 'o') {
				status ^=(1 << 3);
			} else if (ch == 'u') {
				status ^=(1 << 4);
			}
			if (pos[status] >= 0){
				ans = Math.max(ans,i+1-pos[status]);
			}else {     //其他字母
				pos[status] = i+1;  //字符长度。。。
			}
		}
		return ans;
	}
}
