package 西湖算法题解___简单题;

public class __1332删除回文子序列 {
	public static void main(String[] args) {

	}

	public int removePalindromeSub(String s) {
		int res = 0;
		for (int i=0;i<s.length();i++){
			if (s.charAt(i)==s.charAt(s.length()-i-1)){
				res = 1;
			}else {
				return res = 2;
			}
		}
		return res =1;
	}
}
