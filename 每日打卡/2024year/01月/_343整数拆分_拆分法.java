package 代码随想录.动态规划;

public class _343整数拆分_拆分法 {
    public int integerBreak(int n) {
        //2 <= n <= 58
        //只要前一个结果，跟后一个结果有关系的题目 ，基本上都可以使用到dp
        int dp_splitMaxArea [] = new int[n+1];
        //2 <= n <= 58
        /**
         解题思路：
         如何使面积最大呢？  -> 毫无疑问，肯定是正方形
         那么每次我就尝试以均等切分，保存当前的合，
         然后迭代求和最大值和最小值，产生一个新的均值

         举例：
         10
         5*5  ->25
         5*3*2 ->30
         【5和2合并再均分】
         4*3*3  ->36
         【4和3合并再均分】，与前面【5和2合并再均分】产生的合相同，故结束。
         Max算计算过得哪个值最大。
         */
        for (int i=2;i<=n;i++){
            int curMax = 0;
            for (int j=1;j<i;j++){
                curMax = Math.max(curMax,Math.max(j*(i-j),j * dp_splitMaxArea[i-j]));
            }
            dp_splitMaxArea[i] = curMax;
        }
        return dp_splitMaxArea[n];
    }
}
