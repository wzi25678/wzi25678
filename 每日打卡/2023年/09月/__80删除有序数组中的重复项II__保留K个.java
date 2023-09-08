package 西湖算法题解___中等题;

public class __80删除有序数组中的重复项II__保留K个 {
	public static void main(String[] args) {

	}

	public int removeDuplicates(int[] nums) {
		return processRemindK(nums,2);
	}

	/**
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	private int processRemindK(int[] nums, int k) {
		int u = 0;
		for (int x: nums){
			if (u<k || nums[u-k] != x){
				nums[u++] =x;
			}
		}
		return u;
	}

}
