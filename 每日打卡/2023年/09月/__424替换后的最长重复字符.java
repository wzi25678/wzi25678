package 西湖算法题解___中等题;

public class __424替换后的最长重复字符 {
	public static void main(String[] args) {
		System.out.println(characterReplacement("AAAA",2));
	}

	public static int characterReplacement(String s, int k) {
		//在执行上述操作后，返回包含相同字母的最长子字符串的长度。
		/*
		双重for循环，每次都从i开始，往后遍历，去看最大的子字符串长度
		 */

		/**
		 * 上述代码解决不了，这个情况：
		 "ABBB"  2

		 通过率：   34 / 39 个通过的测试用例
		 */
		int n = s.length();
		int res = 0;
		for (int i=0;i<n;i++){      //以 i作为参考起点去尝试
			char flag = s.charAt(i);
			int temp = k;
			int cnt = 1;
			//向右寻找
			for (int j=i+1;j<n;j++){
				if (flag == s.charAt(j)){
					cnt++;
					if (j==n-1){
						res = Math.max(res,cnt);
					}
					continue;
				}
				//如果不相等
				if (temp==0){
					res = Math.max(res,cnt);
					break;
				}
				//走到这里说明还可以容忍不相等
				temp--;
				cnt++;
				if (j==n-1){
					res = Math.max(res,cnt);
				}
			}
			//向左寻找
			for (int j=i-1;j>-1;j--){
				if (flag == s.charAt(j)){
					cnt++;
					if (j==0){
						res = Math.max(res,cnt);
					}
					continue;
				}
				//如果不相等
				if (temp==0){
					res = Math.max(res,cnt);
					break;
				}
				//走到这里说明还可以容忍不相等
				temp--;
				cnt++;
				if (j==0){
					res = Math.max(res,cnt);
				}
			}
		}
		return res;
	}

}
