package 西湖算法题解___中等题;

import java.util.*;

public class __40组合总和II__每个数字只用一次__无法全部AC {
	/**
	 *
	 * @param args
	 */
	/*
	这一题没规定无重复，所以需要考虑去重的问题
	==> 无序数，不太方便去重，所以得转成有序数，才能防止出现重复

	 */

	/**
	 * 怎么避免重复？
	 * 1.本身就是没有重复元素
	 * 2.开始时，让数组有序
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		int[] candidates = new int[]{2,5,2,1,2};
		int target = 5;
		combinationSum2(candidates,target);
	}

	/**
	 *
	 * @param candidates
	 * @param target
	 * @return
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();      //记录下最终答案
		List<Integer> everyCombine = new ArrayList<>();
		Arrays.sort(candidates);
		DFS(candidates,target,res,everyCombine,0);
		Set<List<Integer>> set = new LinkedHashSet<List<Integer>>(res);
		List<List<Integer>> deduplicatedList = new ArrayList<List<Integer>>(set);
		return deduplicatedList;
	}//public List<List<Integer>> combinationSum2(int[] candidates, int target)

	/**
	 *
	 * @param candidates
	 * @param target
	 * @param res
	 * @param everyCombine
	 * @param index
	 */
	private static void DFS(int[] candidates, int target, List<List<Integer>> res, List<Integer> everyCombine, int index) {
		//这里就不能盲目的加了
		if (index == candidates.length){
			return;
		}
		if (target == 0){   //如果恰好找到满足条件的组合值
			res.add(new ArrayList<Integer>(everyCombine));  //避免everyCombine累计
			return;
		}

		//选择数，开始进行判断
		if (target - candidates[index] >= 0){
			everyCombine.add(candidates[index]);
			DFS(candidates,target-candidates[index],res,everyCombine,index+1);    //如果当前everyCombine找不到满足条件的List集，
			//则，return不出去，就会来到这里执行这个everyCombine.removeeveryCombine.remove，去选择移出自生。
			everyCombine.remove(everyCombine.size()-1);
		}

		//没找到则跳过,这里是选择从后往前找
		DFS(candidates,target,res,everyCombine,index+1);
	}//private void DFS(int[] candidates, int target, List<List<Integer>> res, List<Integer> everyCombine, int i)
}
