package 西湖算法题解___中等题;

public class __238除自身以外数组的乘积__方法二__空间复杂度优化 {
	public int[] productExceptSelf(int[] nums) {
		int  length = nums.length;
		int [] res =  new int[length];

		//因为[i]表示索引i的左侧所有元素的乘积
			//因为索引你为'0'的元素左侧没有元素，所以res[0] = 1
		res[0] = 1;
		for (int i =1;i<length;i++){
			res[i] = nums[i-1]*res[i-1];
		}
		int right = 1;
		for (int i =length-1;i>=0;i--){
			res[i] = res[i] *right;
			right *= nums[i];
		}
		return res;
	}
}
