package LeetCode中等题;

public class __1186删除一次得到子数组最大和 {
    /**
    题目要求：
        1.至少选一个
        2.一定要连续，然后可以删除其中的某个元素（注意最多只能删除一个哟）
        3.然后求这样最多删除一个的子数组的最大和

     *
     * @param arr
     * @return
     */
    public int maximumSum(int[] arr) {
        //肯定是dp题了
        int dp0 = arr[0],dp1 = 0,res = arr[0];
        for (int i=1;i< arr.length;i++){
            dp1 = Math.max(dp0,dp1+arr[i]);
            dp0 = Math.max(dp0,0)+arr[i];
            res = Math.max(res,Math.max(dp0,dp1));
        }
        return res;
    }
}
