package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90子集II {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> listSubsets = new ArrayList<Integer>();
    /**
     * 包含重复元素，但不包含重复解集。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //输入：nums = [1,2,2]
        //输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
        // TODO 方法一：永远记住有个暴力的Set去重
        //作为单独元素回溯时，同一个元素不能出现两次
        Arrays.sort(nums);
        backTrack(nums,0);  //想一下终止条件是啥？不像前面还有分隔逗号判断，这个只有长度判断
        return result;
    }

    /**
     *
     * @param nums
     * @param startUsedIndex
     */
    private void backTrack(int[] nums, int startUsedIndex) {
        //这道题空集也算，部分也算，所以直接添加
        result.add(new ArrayList<>(listSubsets));
//        if (startUsedIndex == nums.length - 1) {
//            return;
//        }
        //里面就得采取剪枝
        for (int i = startUsedIndex;i< nums.length;i++){
            // 跳过当前树层使用过的、相同的元素
            //如果这里不加判断则直接使用了
            if (i>startUsedIndex && nums[i-1] == nums[i]){
                continue;
            }
            listSubsets.add(nums[i]);
            backTrack(nums,i+1);
            listSubsets.remove(listSubsets.size()-1);
        }
    }
}
