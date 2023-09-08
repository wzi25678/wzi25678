package 西湖算法题解___中等题;

public class __152乘积最大子数组 {

	public int maxProduct(int[] nums) {
		int length = nums.length;
		int [] maxF = new int [length];
		int [] minF = new int [length];     //正负正负，所以最小值也有可能是最大值。
		System.arraycopy(nums,0,maxF,0,length);
		System.arraycopy(nums,0,minF,0,length);
		for (int i=1;i<length;i++){
			maxF[i] = Math.max(maxF[i-1] * nums[i],Math.max(nums[i],minF[i-1] * nums[i] ));     //防止单数会产生最大
			minF[i] = Math.min(minF[i-1] * nums[i],Math.min(nums[i],maxF[i-1] * nums[i] ));     //防止单数会产生最小
		}
		int ans = maxF[0];
		for (int i=1;i<length;i++){
			ans = Math.max(ans,maxF[i]);
		}
		return ans;
	}
}
