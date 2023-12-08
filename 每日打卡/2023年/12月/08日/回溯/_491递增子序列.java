package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _491递增子序列 {
    public static void main(String[] args) {
        int nums[] = new int[]{4,4,3,2,1};
        findSubsequences(nums);
    }
    static List<List<Integer>> result = new ArrayList<List<Integer>>();
    static List<Integer> listSubset = new ArrayList<Integer>();
    /**
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> findSubsequences(int[] nums) {
        //给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，
        //递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
        //数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
        backTrack(nums,0);  //想一下终止条件是啥？不像前面还有分隔逗号判断，这个只有长度判断
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>(result);
        result.clear();
        result.addAll(resultSet);
        return result;
    }
    /**
     *
     * @param nums
     * @param startUsedIndex
     */
    private static void backTrack(int[] nums, int startUsedIndex) {
        //也是每一个子集都需要返回，但是得满足最小长度大于2
        if (listSubset.size() >1){
            result.add(new ArrayList<>(listSubset));
        }
        for (int i = startUsedIndex;i< nums.length;i++){
            if ( i>startUsedIndex && nums[i] < nums[i-1]){
                continue;
            }
            listSubset.add(nums[i]);
            backTrack(nums,i+1);
            listSubset.remove(listSubset.size()-1);
        }
    }
}
