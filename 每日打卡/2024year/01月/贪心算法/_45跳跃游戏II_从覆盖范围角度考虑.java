package 代码随想录.贪心算法;

public class _45跳跃游戏II_从覆盖范围角度考虑 {
    /**
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     * 返回到达 nums[n - 1] 的最小跳跃次数。
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        //每次去寻找当前能跳到范围内的下一次能跳的最远的位置
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃次数，即为答案
        int result_jumpTime = 0;
        //记录当前位置所能覆盖的最大区域
        int curCoverRange = 0;
        //记录当前节点所有能选择的位置，所产生的最远位置
        int maxCoverRange = 0;
        for (int i = 0;i< nums.length;i++){
            //在可覆盖区域内更新最大的覆盖区域
            //不考虑我到底跳在了哪个位置，只考虑我能跳到多远！！！
            maxCoverRange = Math.max(maxCoverRange,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxCoverRange >= nums.length - 1){
                result_jumpTime++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i==curCoverRange){
                curCoverRange = maxCoverRange;
                result_jumpTime++;
            }
        }
        return result_jumpTime;
    }
}
