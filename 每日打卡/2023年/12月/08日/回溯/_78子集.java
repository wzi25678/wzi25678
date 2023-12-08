package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

public class _78子集 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> listSubsets = new ArrayList<Integer>();
    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        //给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
        //解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
        //这样的话，筛选的时候就得执行过滤操作。
        backTrack(nums,0);  //想一下终止条件是啥？不像前面还有分隔逗号判断，这个只有长度判断
        return result;
    }

    private void backTrack(int[] nums, int startUsedIndex) {
        //这道题空集也算，部分也算，所以直接添加
        result.add(new ArrayList<>(listSubsets));
        if (startUsedIndex == nums.length - 1) {
            return;
        }
        for (int i = startUsedIndex;i< nums.length;i++){
            listSubsets.add(nums[i]);
            backTrack(nums,i+1);
            listSubsets.remove(listSubsets.size()-1);
        }
    }
}
