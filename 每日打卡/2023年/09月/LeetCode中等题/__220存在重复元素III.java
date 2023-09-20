package LeetCode中等题;

public class __220存在重复元素III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int n = nums.length;
        if (nums.length == 0){
            return false;
        }
        //------------------------------------------------
        for (int i=0;i<n;i++){
            for (int j=i;j<=indexDiff;j++){  //要求在indexDiff范围内
                //在上述参数j的范围内，判断是否有重复元素
                /**
                 * 上述方法虽然可行，但是时间复杂度太高了。
                 */
                //for ()+for() 双重遍历来确定最后有无重复元素



            }
        }


        return false;
    }
}
