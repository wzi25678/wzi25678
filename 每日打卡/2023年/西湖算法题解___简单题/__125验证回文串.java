package 西湖算法题解___简单题;

public class __125验证回文串 {
	public static void main(String[] args) {
		String s = "OP";
		isPalindrome(s);
	}

	/**
	 *
	 * @param s
	 * @return
	 *
	 *
	 * 解题思路：
	 * 1.去除掉所有的非字母数字字符,然后所有的字母字符，大写转小写
	 *      本人采用笨办法：   ASCII码值判别字符是不是字母
	 *
	 *
	 * 2.进行回文判断
	 *      收尾元素进行判断即可
	 *
	 */
	public static boolean isPalindrome(String s) {
		String str = "";
		for (int i=0;i<s.length();i++){
			if ((int)s.charAt(i) >= 65 && (int)s.charAt(i) <= 90){
				//在这个区间，则说明它是大写字母
				char zifu = (char)((int)s.charAt(i) + 32);
				str +=zifu;
			}
			//判断如果是数字
			if ((int)s.charAt(i) >= 48 && (int)s.charAt(i) <= 57){
				char zifu = (char)((int)s.charAt(i) + 32);
				str +=zifu;
			}
			if ((int)s.charAt(i) >= 97 && (int)s.charAt(i) <= 122){
				//如果是小写字符就直接加仅这个str数组
				str +=  s.charAt(i);
			}
			//如果是其他情况，则不做考虑
		}
		System.out.println(str);
		//对新生成的str进行是否是回文的判断
		for (int i=0;i<str.length()/2;i++){
			System.out.printf("本次的对比数据为：%s 和 %s。\n",str.charAt(i),str.charAt(str.length()-i-1));
			if (str.charAt(i) != str.charAt(str.length()-i-1)){
				//有一个不等，则直接判定为false
				System.out.println("输出了false");
				return false;
			}
		}
		//如果全等，则判定为true
		System.out.println("输出了true");
		return true;

	}//public boolean isPalindrome(String s)

}//public class __125验证回文串
