package 西湖算法题解___中等题;

public class __978最长湍流子数组__滑动窗口01 {
	public int maxTurbulenceSize(int[] arr) {
		if (arr.length <1){
			return 0;
		}
		int res = 1;
		int dp_maxTurbulenceSize [][] = new int[arr.length][2];
		dp_maxTurbulenceSize[0][0] = dp_maxTurbulenceSize[0][1] = 1;
		dp_maxTurbulenceSize[0][0] = dp_maxTurbulenceSize[0][1] = 1;
		for (int i=1;i< arr.length;i++){
			

		}


		return res;
	}
}
