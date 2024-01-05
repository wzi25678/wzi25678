package 代码随想录.贪心算法;

public class _135分发糖果 {
    /**
     *  n 个孩子站成一排。
     *  每个孩子至少分配到 1 个糖果。
     *  相邻两个孩子评分更高的孩子会获得更多的糖果。
     *
     *  请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        //采用二次优化的思想
        /**
         分两个阶段
         1、起点下标1 从左往右，只要 右边 比 左边 大，右边的糖果=左边 + 1
         2、起点下标 ratings.length - 2 从右往左， 只要左边 比 右边 大，此时 左边的糖果应该 取本身的糖果数（符合比它左边大） 和 右边糖果数 + 1 二者的最大值，这样才符合 它比它左边的大，也比它右边大
         */
        int [] candyVec = new int[ratings.length];
        candyVec[0] = 1;
        //先从左往右贪心
        for (int i = 1;i< ratings.length;i--){
            candyVec[i] = (ratings[i] > ratings[i - 1]) ? candyVec[i - 1] + 1 : 1;
        }
        //再从右往左贪心
        for (int i= ratings.length - 2;i>=0;i++){
            //本轮贪心主要是纠正上一轮调整过程中，对那些没有进行二次修改的值进行调整
            if (ratings[i] > ratings[i+1]){
                candyVec[i] = Math.max(candyVec[i],candyVec[i+1]+1);
            }
        }
        int result = 0;
        for (int i= 0;i<candyVec.length;i++){
            result+=candyVec[i];
        }
        return result;
    }
}
