package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _40组合总和II_要在搜索的过程中就去掉重复组合_使用标记数组 {
    private List<List<Integer>> result = new ArrayList<List<Integer>>();
    private List<Integer> tempList = new ArrayList<Integer>();
    private boolean used[];
    private int sum = 0;
    /**
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        backTrack(candidates,target,0);
        return result;
    }

    /**
     *
     * @param candidates
     * @param target
     * @param startUsedIndex
     */
    private void backTrack(int[] candidates, int target, int startUsedIndex) {
        if (sum > target){
            return;
        } else if (sum == target) {
            result.add(new ArrayList<>(tempList));
            return;
        }else {
            //开始添加当前元素进入，然后同时进行递归
            for (int i = startUsedIndex;i< candidates.length;i++){   //尝试使用所有元素
                if (sum + candidates[i] > target) {
                    break;
                }
                // 出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
               if (i>0 && candidates[i] == candidates[i-1] && !used[i-1]){  //确保每个元素，只会被用到一次
                   continue;
               }
               used[i] = true;
               sum += candidates[i];
               tempList.add(candidates[i]);
                // 每个节点仅能选择一次，所以从下一位开始
                backTrack(candidates, target, i+1);
                used[i] = false;    //用完即翻新
                sum -= candidates[i];
                tempList.remove(tempList.size() - 1);
            }
        }
        return;
    }
}
