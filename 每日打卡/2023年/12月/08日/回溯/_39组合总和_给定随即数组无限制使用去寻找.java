package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _39组合总和_给定随即数组无限制使用去寻找 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> tempList = new ArrayList<Integer>();
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
     * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //先将数组排好序，这样可以实现便捷寻找
        Arrays.sort(candidates);
        backTrack(candidates,target,0,0);
        return result;
    }


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
                backTrack(candidates,target,i,sum+candidates[i]);
                tempList.remove(tempList.size() - 1);
            }
        }
        return;
    }

}
