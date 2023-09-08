package 西湖算法题解___中等题;

import java.lang.reflect.Array;
import java.util.Arrays;

public class __611有效三角形的个数 {
	public int triangleNumber(int[] nums) {
		//给定一个包含非负整数的数组 nums ，返回其中可以组成三角形三条边的三元组个数。
		//1 <= nums.length <= 1000,最多只能双重for循环
		//怎么样才能组成三角形：   任意两边之和大于第三边，任意两边之差小于第三边
		//那就必须用两根指针，指向最大/最小，然后再开始移动
		if (nums.length < 3){
			return 0;
		}
		int res = 0;
		Arrays.sort(nums);
		for (int i=nums.length -1;i>=2;i--){
			int left = 0,right = i-1;
			while (left < right){
				if (nums[left] + nums[right] <= nums[i]){
					left++;     //说明数小了
				}else { //说明当前数已经满足了要求，即当前范围内的任意值，我都可以取
					res += right - left;
					//这里就需要更换数值，避免使用到重复位置
					res += right - left;
					//left++;
					// 并且只能使用right--;，因为你的上一个res += right - left;里面其实就已经包含了下一个left++的位置情况
				}
			}
		}
		return res;
	}
}
