package 西湖算法题解___简单题;

public class __169多数元素 {
	public static void main(String[] args) {

	}
	public int majorityElement(int[] nums) {
		int res = 0;
		int daan  = 0;
		for (int  i=0;i<nums.length;i++){
			if (res == 0){
				res++;
				daan = nums[i];
			}else { // res != 0
				if (nums[i]==daan){
					res++;
				}else{
					res--;
				}
			}
		}
		return daan;
	}
}
