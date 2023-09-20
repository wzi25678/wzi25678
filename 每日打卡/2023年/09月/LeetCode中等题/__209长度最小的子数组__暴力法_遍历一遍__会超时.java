package LeetCode中等题;

public class __209长度最小的子数组__暴力法_遍历一遍__会超时 {
    //找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
    //                                  并返回其长度。


    /**
     * dp动态数组，去迭代？前一个的结果，需要保存，并且会影响后面的结果
     *
     *
     *
     *
     */

    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int res = Integer.MAX_VALUE;    //因为我是要找最下的min
        for (int i = 0;i<nums.length;i++){
            int sum = 0;
            for(int j=i;j<nums.length;j++){
                sum += nums[j];
                if(sum >= target){
                    //因为是要最短的长度，不在意打多少，而是要取最短的长度
                    res = Math.min(res,j-i+1);
                    break;
                }
            }
        }
        return res == Integer.MAX_VALUE ? 0:res;
    }



}
