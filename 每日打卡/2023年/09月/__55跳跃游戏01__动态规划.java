package 西湖算法题解___中等题;

public class __55跳跃游戏01__动态规划 {
	public static void main(String[] args) {

	}

	public boolean canJump(int[] nums){
		if (nums.length == 1){
			return true;
		}
		/*
		输入：
		[0]
		输出：
		false
		预期结果：
		true
		 */
		if (nums[0] == 0){
			return false;
		}

		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		//单数组动态规划，单变量
		for (int i=1;i< nums.length-1;i++){
			dp[i] = Math.max(dp[i-1],nums[i]+1);
			//dp[i]表示最远能走到哪儿，，，，，，+1代表之前有一个数组占位了。
			if (dp[i] >= nums.length-1){
				return true;
			}
			//如果出现0或者原地踏步，则说明走不动了
			//因为dp[i] = Math.max(dp[i-1],nums[i]+1);
			//所以不管怎样，都会有+1操作
			if (dp[i] == i){    //说明原地踏步了
				return false;
			}
		}
		return true;
	}
}
