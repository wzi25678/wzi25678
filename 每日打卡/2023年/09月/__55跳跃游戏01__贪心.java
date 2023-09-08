package 西湖算法题解___中等题;

public class __55跳跃游戏01__贪心 {
	public boolean canJump(int[] nums){
		//从头到尾进行判断
		int jumpWhere = 0;
		for (int i=0;i< nums.length;i++){
			if (i<=jumpWhere){      //之前点走出来的最远可达
				jumpWhere = Math.max(jumpWhere,i+nums[i]);
				if (jumpWhere >= nums.length-1){
					return true;
				}
			}
		}
		return false;
	}
}
