package 西湖算法题解___中等题;

public class __5最长回文子串 {
	public static void main(String[] args) {
		String s = "babad";
		System.out.println(longestPalindrome(s));

	}

	public  static String longestPalindrome(String s) {
		String res = "";
		for (int i =0;i<s.length();i++){
			for (int j=s.length()-1;j>=0;j--){
				System.out.printf("longestPalindrome：   i=%d,j=%d\n",i,j);
				if (isRecurNum(s,i,j)==true){
					//那么res就等于从i到j的这些字符的组合
					for (int k=i;k<=j;k++){
						res+=s.charAt(k);
					}
				}
			}
		}
		return res;
	}

	private static boolean isRecurNum(String s, int i, int j) {
		System.out.printf("isRecurNum中：   i=%d,j=%d\n",i,j);
		while (i<=j){
			if (s.charAt(i)!=s.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}


}
