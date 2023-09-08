package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __90子集II__有重复元素找不重复子集 {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
	List<Integer> subsets = new ArrayList<>();
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		backTrack(0,nums);
		return res;
	}

	/**
	 *
	 * @param startIndex
	 * @param nums
	 */
	private void backTrack(int startIndex, int[] nums) {
		res.add(new ArrayList<>(subsets));  //一开始就加入，刚好加入空集，
		//然后接下来在for循环中，往subsets里添加元素，同时还要注意，每一次递归完了之后，又要remove掉
		for (int i=startIndex;i< nums.length;i++){
			//首先进行去重判断,
			// 每个元素作为头，去进行一次startIndex
			if (i > startIndex && nums[i] == nums[i-1]){
				//此时说明重复了，则直接跳过
				continue;
			}else {
				//走到这么说明没重复
				subsets.add(nums[i]);
				backTrack(i+1,nums);
				//如果这里还能继续往下走 ，说明当前元素 已经拼接了所有其对应的子集
				subsets.remove(subsets.size()-1);   //就跟递归调用栈一样，每个拼接完结束的子集都会存储在最后一个位置上
			}
		}
	}
}
