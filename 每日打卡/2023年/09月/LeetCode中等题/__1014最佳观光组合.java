package LeetCode中等题;

public class __1014最佳观光组合 {
    /**
     *
     * @param values
     * @return
     */
    public int maxScoreSightseeingPair(int[] values) {
        int res = 0,max = values[0] + 0;
        for (int j=1;j< values.length;j++){
            res = Math.max(res,max + values[j] - j);
            //边遍历，边维护
            max = Math.max(max,values[j]+j);
        }
        return res;
    }
}
