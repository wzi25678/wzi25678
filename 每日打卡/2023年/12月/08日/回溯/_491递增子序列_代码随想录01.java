package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _491递增子序列_代码随想录01 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> listSubset = new ArrayList<Integer>();
    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTrack(nums,0);
        return result;
    }
    /**
     *
     * @param nums
     * @param startUsedIndex
     */
    private void backTrack(int[] nums, int startUsedIndex){
        if (listSubset.size() >= 2){
            result.add(new ArrayList<>(listSubset));
        }
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = startUsedIndex;i< nums.length;i++){
            if (!listSubset.isEmpty() && listSubset.get(listSubset.size() - 1) > nums[i] || hashSet.contains(nums[i])) {
                continue;
            }
            hashSet.add(nums[i]);
            listSubset.add(nums[i]);
            backTrack(nums, i+1);
            listSubset.remove(listSubset.size()-1);
        }
    }

}
