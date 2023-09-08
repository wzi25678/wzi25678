package 西湖算法题解___中等题;

public class __91解码方法 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param s
	 * @return
	 */
	public int numDecodings(String s){
		int n = s.length();
		int f_dp[] = new int[n+1];  //每个数默认是0
		f_dp[0] = 1;
		for (int i=1;i<=n;i++){
			if (s.charAt(i-1) != '0'){  //只针对当前一位进行判断
				f_dp[i] += f_dp[i-1];
			}
			if (i>1 && s.charAt(i-2)!='0' &&((s.charAt(i-2) - '0')*10+(s.charAt(i-1) -'0') <= 26)){
				//如果有两位，并且可以凑出来两位，那么针对当前两位进行判断
				f_dp[i]+=f_dp[i-2];
			}
		}
		return f_dp[n];
	}
}
