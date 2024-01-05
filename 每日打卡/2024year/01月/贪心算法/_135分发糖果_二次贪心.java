package 代码随想录.贪心算法;

public class _135分发糖果_二次贪心 {
    /**
     *
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int [] candyVec = new int[ratings.length];
        candyVec[0] = 1;
        //先从左往右贪心
        for (int i = 1; i < ratings.length; i++) {
            candyVec[i] = (ratings[i] > ratings[i-1]) ?  candyVec[i-1] + 1 : 1;
        }
        //再从右往左贪心
        for (int i = ratings.length - 2;  i >=0;i--) {
            //本轮贪心主要是纠正上一轮调整过程中，对那些没有进行二次修改的值进行调整
            if (ratings[i] > ratings[i+1]){
                candyVec[i] = Math.max(candyVec[i],candyVec[i+1]+1);
            }
        }
        int result = 0;
        //累积求和
        for (int i = 0; i <candyVec.length; i++){
            result+=candyVec[i];
        }
        return result;
    }
}
