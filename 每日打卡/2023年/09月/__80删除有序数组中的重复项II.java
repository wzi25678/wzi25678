package 西湖算法题解___中等题;

public class __80删除有序数组中的重复项II {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		//nums 已按升序排列
		int count = 1 ;
		int index_length =1 ;
		if (nums.length == 0 ){
			return 0;
		}
		for (int i=1;i< nums.length;i++){
			//和前一个进行比较
			if (nums[i] == nums[i-1]){
				if (count<2){
					count++;
					index_length++;
				}else{
					//当前count已经>=2了
					moveArray(nums,index_length-1);
				}
			}else {
				//如果nums[i] != nums[i-1]
				count = 1;      //重新开始计数
				index_length++;
			}
		}
		return index_length;
	}

	/**
	 *
	 * @param nums
	 * @param startIndex
	 */
	private void moveArray(int[] nums, int startIndex) {
		for (int i=startIndex+1;i< nums.length;i++){
			nums[i] = nums[i+1];
		}

	}
}
