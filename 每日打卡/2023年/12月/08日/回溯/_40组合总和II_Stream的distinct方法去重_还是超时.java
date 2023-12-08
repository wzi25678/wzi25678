package 代码随想录.回溯;

import java.util.*;
import java.util.stream.Collectors;

public class _40组合总和II_Stream的distinct方法去重_还是超时 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> tempList = new ArrayList<Integer>();

    /**
     * 给定一个候选人编号的集合 candidates 和一个目标数 target ,
     * 找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用 一次 。
     * 解集不能包含重复的组合。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,target,0,0);
        List<List<Integer>> distinctList = result.stream().distinct().collect(Collectors.toList());
        return distinctList;
    }

    /**
     *
     * @param candidates
     * @param target
     * @param startUseIndex
     * @param sum
     */
    private void backTrack(int[] candidates, int target, int startUseIndex, int sum) {
        if (sum > target){
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(tempList));
            return;
        }else {
            //开始添加当前元素进入，然后同时进行递归
            for (int i = startUseIndex;i< candidates.length;i++){   //尝试使用所有元素
                if (sum + candidates[i] > target) {
                    break;
                }
                tempList.add(candidates[i]);
                backTrack(candidates,target,i+1,sum+candidates[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
        return;
    }
}
