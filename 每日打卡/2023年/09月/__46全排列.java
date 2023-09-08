package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class __46全排列 {
	public static void main(String[] args) {

	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();      //记录下最终答案
		List<Integer> everyCombine = new ArrayList<>();
		for (int num:nums){
			everyCombine.add(num);
		}
		//采用dfs+回溯的方法实现全排列
		backTrack(nums.length,everyCombine,res,0);
		return res;
	}

	/**
	 *
	 * @param n
	 * @param everyCombine
	 * @param res
	 * @param index
	 */
	private void backTrack(int n, List<Integer> everyCombine, List<List<Integer>> res, int index) {
		if (index == n){
			res.add(new ArrayList<>(everyCombine));
		}
		//没达到规定长度，则说明还需要进行全排列
		for (int i = index;i<n;i++){    //每一次接收到的index都是不同的，它代表当前已经达到的长度
			Collections.swap(everyCombine,index,i); //当前的i与每一个index交换一下位置
			backTrack(n,everyCombine,res,index+1);
			Collections.swap(everyCombine,index,i); //再把位置交换回来
		}
	}//private void backTrack(int length, List<Integer> everyCombine, List<List<Integer>> res, int index)
}
