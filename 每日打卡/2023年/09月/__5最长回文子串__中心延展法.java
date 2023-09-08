package 西湖算法题解___中等题;

public class __5最长回文子串__中心延展法 {
	public static void main(String[] args) {

	}//public static void main(String[] args)

	/**
	 *
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s){
		if (s.length() <= 1){
			return s;
		}
		//记录最长子串的长度，以及初始位置
		int maxLen = 1,begin = 0;
		//s.charAt(i)每次都会 检查数组下标越界，因此先转换成字符数组，这一步非必需
		char [] charArray_s = s.toCharArray();
		for (int i=0;i<s.length()-1;i++){
			//假设每个点为中心判断回文子串点
			int oddLen = expandAroundCenter(charArray_s,i,i);   //假设回文子串中心点为奇数
			int evebLen = expandAroundCenter(charArray_s,i,i+1);    //假设回文子串中心点为偶数

			int curMaxLen = Math.max(oddLen,evebLen);
			if (curMaxLen > maxLen){
				maxLen = curMaxLen;
				begin = i-(maxLen-1)/2;
			}
		}
		return s.substring(begin,begin+maxLen);

	}//public String longestPalindrome(String s)

	/**
	 *
	 * @param charArray_s
	 * @param left_center
	 * @param right_center
	 * @return
	 */
	private int expandAroundCenter(char[] charArray_s, int left_center, int right_center) {
		int i = left_center;
		int j = right_center;
		while (i>=0 && j<charArray_s.length){
			if (charArray_s[i] == charArray_s[j]){
				i++;
				j--;
			}else {
				break;
			}
		}
		//不管等不等，都会获取一个中心判断长度
		return j-i-1;
	}
}
