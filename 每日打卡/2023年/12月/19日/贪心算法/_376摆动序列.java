package 代码随想录.贪心算法;

public class _376摆动序列 {
    /**
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        //就是贪心，上升的时候，选取上升数中的较大值
        //        下降的时候，选取下降数中的较小值
        //然后因为是摆荡数列嘛，就是要开局确认一下是先递增，还是先递减
        if (nums.length <= 1){
            return nums.length;
        }
//        //看增减顺序
//        boolean flag = true;    //true增 ，false减
        //当前差值
        int curDiff = 0;
        //上一个差值
        int prevDiff = 0;
//        int preA = nums[0];
//        int preB = nums[1];
//        if (preB - preA < 0){
//            //先减
//            flag = false;
//        }
//        int maxValue = preB;
//        for (int i=2;i< nums.length;i++){
//            if (flag = )
//
//        }
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            //得到当前差值
            curDiff = nums[i] - nums[i-1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && prevDiff <= 0) || (curDiff < 0 && prevDiff >= 0)){
                count++;
                prevDiff = curDiff;
            }
        }
        return count;
    }
}
