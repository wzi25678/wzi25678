package 西湖算法题解___中等题02;

public class __1558得到目标数组的最少函数调用次数 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		//操作符就两个：
		//1.要么指定一个数字位数+1
		//2.要么全部数字*2
		//返回操作次数

	}

	/**
	 *
	 * @param nums
	 * @return
	 */
	public int minOperations(int[] nums) {      //遇奇-1（每次都算操作一次），一轮过后，所有数除2
		int res = 0,maxN = 0;
		for (int num :nums){
			maxN = Math.max(maxN,num);
			while (num!=0){
				if ((num & 1) != 0){
					res++;
				}
				num>>=1;
			}
		}
		if (maxN != 0){
			while (maxN != 0){
				res++;
				maxN >>=1;
			}
			res--;
		}
		return res;
	}
}
