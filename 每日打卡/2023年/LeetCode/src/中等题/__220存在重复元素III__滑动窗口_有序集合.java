package 中等题;

import java.util.TreeSet;

public class __220存在重复元素III__滑动窗口_有序集合 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff){
        int n = nums.length;
        //-109 <= nums[i] <= 109
        TreeSet<Long> sequenceSet = new TreeSet<Long>();
        for (int i=0;i<n;i++){
            Long ceiling = sequenceSet.ceiling((long) (nums[i] - (long)valueDiff));
            if (ceiling != null && ceiling <= (long) nums[i] + (long)valueDiff){
                return true;
            }
            sequenceSet.add((long) nums[i]);
            if ( i >= indexDiff){
                sequenceSet.remove((long)nums[i-indexDiff]);
            }
        }
        return false;
    }
}
