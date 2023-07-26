package 西湖算法题解___简单题;

public class __283移动零 {
	public static void main(String[] args) {

	}
	public void moveZeroes(int[] nums) {
		int helper[] = new int[nums.length];
		int begin = 0,end = nums.length-1;
		for (int i=0;i< nums.length;i++){
			if (nums[i]==0){
				helper[end] = nums[i];
				end--;
			}else{
				helper[begin] = nums[i];
				begin++;
			}
		}
		for (int i=0;i< nums.length;i++){
			nums[i] = helper[i];
		}

	}
}
