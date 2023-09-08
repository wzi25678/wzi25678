package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class __39组合总和__每个数字可以重复使用 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		//这一题规定了无重复元素
		int[] candidates = new int[]{2,3,5,2,3};

	}

	/**
	 *
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();      //记录下最终答案
		List<Integer> everyCombine = new ArrayList<>();
		DFS(candidates,target,res,everyCombine,0);
		return res;

	}

	/**
	 *
	 * @param candidates    需要被遍历寻找target的数组
	 * @param target        目标值
	 * @param res           最后的List集
	 * @param everyCombine  每一个单独的子集中的List集
	 * @param index         当前访问位置
	 */
	private void DFS(int[] candidates, int target, List<List<Integer>> res, List<Integer> everyCombine, int index) {
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
			DFS(candidates,target-candidates[index],res,everyCombine,index);    //如果当前everyCombine找不到满足条件的List集，
			//则，return不出去，就会来到这里执行这个everyCombine.removeeveryCombine.remove，去选择移出自生。
			everyCombine.remove(everyCombine.size()-1);
		}

		//没找到则跳过,这里是选择从后往前找
		DFS(candidates,target,res,everyCombine,index+1);    //++和+1最本质的区别而就是，，，，
		//                          ++值后验操作，即如果有赋值，调用等等操作，那么会先执行赋值，调用，等一切都结束了，在会有调用++
		//                          而+1则是当场就执行+1的操作


	}
}
