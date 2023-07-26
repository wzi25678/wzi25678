package 西湖算法题解___简单题;

public class 题目地址26__删除排序数组中的重复项 {
	public static void main(String[] args) {
		int nums [] = {1,1,2};
		removeDuplicates(nums);
	}

	private static int removeDuplicates(int[] nums) {
		if (nums.length ==0 || nums.length ==1){
			return nums.length;
		}
		int new_length =1;

		int temp = nums[0];
		System.out.println("这个值会被显示："+temp);
		//如果大于/等于两个则正儿八经进行一下记录
		for (int i=1;i<nums.length;i++){
			//temp总是等于前一个
			//则temp数值已经被继续后导致的第二个
			if (temp == nums[i]){
				//相等则继续
				continue;
			}else{
				//不等则记录，并且重新复制
				temp = nums[i];
				new_length++;
				System.out.println("这个值会被显示："+temp);
			}
		}
		return new_length;
	}
}
