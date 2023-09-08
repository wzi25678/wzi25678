package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __90子集II__重复数返回所有子集 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param nums
	 * @return
	 */
	List<Integer> temp = new ArrayList<Integer>();
	List<List<Integer>>  res = new ArrayList<List<Integer>>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		dfs(false,0,nums);
		//dfs为了 避免，在函数中还要调用自身，故将其声明为全局变量
		return res;
	}

	/**
	 *
	 * @param choosePre
	 * @param cur
	 * @param nums
	 */
	private void dfs(boolean choosePre, int cur, int[] nums) {
		if (cur == nums.length){
			res.add(new ArrayList<Integer>(temp));
			return;
		}
		dfs(false,cur+1,nums);
		if (!choosePre  && cur > 0 && nums[cur-1] == nums[cur]){    //如果当前值被匹配过，并且和他前一个值相等
			return;
		}
		temp.add(nums[cur]);
		dfs(true,cur+1,nums);
		temp.remove(temp.size()-1);
	}
}
