package 西湖算法题解___中等题;

public class __5最长回文子串__暴力法 {
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

		//开始枚举所有长度严格大于1的子串，charArray[i..j]
		for (int i=0;i<s.length()-1;i++){      //这里就是多一个，少一个的问题，不影响
			for (int j = i+1;j<s.length();j++){
				if (j-i+1 >maxLen && isPalindrome(charArray_s,i,j)){
					maxLen = j-i+1;
					begin = i;
				}
			}
		}
		return s.substring(begin,begin+maxLen);

	}//public String longestPalindrome(String s)

	/**
	 *
	 * @param charArray_s
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean isPalindrome(char[] charArray_s, int left, int right) {
		while (left <= right){
			if (charArray_s[left] != charArray_s[right]){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}//private boolean isPalindrome(char[] charArray_s, int i, int j)

}// __5最长回文子串__暴力法
