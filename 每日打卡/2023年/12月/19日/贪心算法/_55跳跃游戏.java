package 代码随想录.贪心算法;

public class _55跳跃游戏 {
    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i=0;i<=coverRange;i++){
            coverRange = Math.max(coverRange,i+nums[i]);    //i+num[i]表示能探索到的最远的位置
            //coverRange则是老老实实的每一个都去探索，同时在扩展能够探索到的最远的位置
            if (coverRange == nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
