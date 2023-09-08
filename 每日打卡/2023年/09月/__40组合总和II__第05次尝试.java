package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class __40组合总和II__第05次尝试 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param candidates
	 * @param target
	 * @return
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> everyComb = new ArrayList<>();
		backTrack(candidates,target,everyComb,res,0);
		return res;
	}

	/**
	 *
	 * @param candidates
	 * @param target
	 * @param everyComb
	 * @param res
	 * @param index
	 */
	private void backTrack(int[] candidates, int target, List<Integer> everyComb, List<List<Integer>> res, int index) {
		if (target == 0){
			res.add(new ArrayList<Integer>(everyComb));  //避免everyCombine累计
			return;
		}
		if (target<0){
			return;
		}
		for (int  i = index;i< candidates.length;i++){
			if (i > index && candidates[i] == candidates[i-1]){
				continue;
			}
			everyComb.add(candidates[index]);
			backTrack(candidates,target-candidates[index],everyComb,res,index+1);    //如果当前everyCombine找不到满足条件的List集，
			//则，return不出去，就会来到这里执行这个everyCombine.removeeveryCombine.remove，去选择移出自生。
			everyComb.remove(everyComb.size()-1);
		}
	}
}
