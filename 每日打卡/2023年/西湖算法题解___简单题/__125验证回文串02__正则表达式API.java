package 西湖算法题解___简单题;

public class __125验证回文串02__正则表达式API {
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		isPalindrome(s);
	}

	public static  boolean isPalindrome(String s) {
		//构造一个StringBuilder类，因为它可以调用reverse方法
		s=s.replaceAll("[^0-9A-Za-z]","").toLowerCase();
		StringBuilder stringBuilder = new StringBuilder(s).reverse();
		//System.out.println("s等于：            |"+s);
		//System.out.println("stringBuilder等于：|"+stringBuilder);
		if (s.equals(stringBuilder.toString())){
			return  true;
		}else{
			return false;
		}
		//替换掉所有的非0-9，A-Z，a-z的东西，然后再将剩余的均采用toLowerCase()

	}
}
