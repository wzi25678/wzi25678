package 西湖算法题解___简单题;

public class __0665非递减数列 {
	public static void main(String[] args) {

	}

	public boolean checkPossibility(int[] nums) {
		int flag = 0;
		for (int i = 0;i< nums.length-1;i++){
			if (nums[i]-nums[i+1] > 0){
				flag++;
			}
		}
		if (flag>1){
			return false;
		}
		return true;
	}
}
