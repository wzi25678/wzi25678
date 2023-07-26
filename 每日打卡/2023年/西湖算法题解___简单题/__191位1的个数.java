package 西湖算法题解___简单题;

public class __191位1的个数 {
	public static void main(String[] args) {

	}

	public int hammingWeight(int n) {
		String str = Integer.toBinaryString(n)+"";
		int res = 0;
		for (int i=0;i<str.length();i++){
			if (str.charAt(i)=='1'){
				res++;
			}
		}
		return res;
	}
}
