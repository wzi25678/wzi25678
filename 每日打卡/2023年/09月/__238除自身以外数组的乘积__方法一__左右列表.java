package 西湖算法题解___中等题;

public class __238除自身以外数组的乘积__方法一__左右列表 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param nums
	 * @return
	 *
	 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
	 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
	 *      因为用除法的话，就直接所有数相乘，O(n)复杂度读，然后遍历除以每个元素，O(n)复杂度，最后就是2*O(n)复杂度。
	 * 你可以在 O(1) 的额外空间复杂度内完成这个题目吗？
	 *
	 */
	public int[] productExceptSelf(int[] nums) {
		int n_length = nums.length;
		//L和R分别代表左右两侧的乘积列表
		int left [] = new int[n_length];
		int right [] = new int[n_length];
		//答案res数组
		int res[] = new int[n_length];

		//L[i]为索引i左侧所有元素的乘积
			//对于索引为 '0' 的元素，因为左侧没有元素，所以L[0] = 1
		left[0] = 1;
		for (int i=1;i<n_length;i++){
			left[i]= nums[i-1] * left[i-1];
		}

		//R[i]为索引i右侧所有元素的乘积
		//对于索引为 '0' 的元素，因为右侧没有元素，所以R[length-1] = 1
		right[n_length-1] = 1;
		for (int i=n_length - 2;i>=0;i--){
			right[i]= nums[i+1] * right[i+1];
		}

		//对于索引i，除nums[i]之外，其余各元素的乘积就是左侧所有元素乘积*右侧所有元素乘积
		for (int i=0;i<n_length;i++){
			res[i] = left[i] + right[i];
		}
		return res;
	}
}
