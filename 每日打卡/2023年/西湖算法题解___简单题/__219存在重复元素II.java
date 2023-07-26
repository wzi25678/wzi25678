package 西湖算法题解___简单题;

public class __219存在重复元素II {
	public static void main(String[] args) {
		int nums []= new int[]{1,2,3,1,2,3};
		int k=2;
		containsNearbyDuplicate(nums,k);
	}

	public static  boolean containsNearbyDuplicate(int[] nums, int k){
		for (int i=0;i< nums.length;i++){
			for (int j=i+1;j< nums.length;j++){
				if (nums[i] == nums[j] && Math.abs(j-i)<=k){
					System.out.println(true);
					return true;
				}
			}
		}
		System.out.println(false);
		return  false;
	}
}
