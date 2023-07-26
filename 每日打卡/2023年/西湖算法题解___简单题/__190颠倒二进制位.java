package 西湖算法题解___简单题;

public class __190颠倒二进制位 {
	public static void main(String[] args) {
		String n = "00000010100101000001111010011100";
		reverseBits(n);
	}

	public static  int reverseBits(String n) {
//		String str = n+"";  //先转成String类
//		StringBuilder stringBuilder =  new StringBuilder(str);
//		//System.out.println(stringBuilder);
//		String reverseStr = stringBuilder.reverse().toString();
//		//System.out.println(reverseStr);
//
//		int res = Integer.parseInt(reverseStr,2);
//		System.out.println(res);
//		return res;
		int res = Integer.reverse(Integer.parseInt(n));
			System.out.println(res);
		return res;
	}
}
