package 代码随想录.贪心算法;

import java.util.Arrays;

public class _455分发饼干 {
    /**
     *
     * @param g 各个小孩的胃的大小
     * @param s 各个饼干的大小
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        // 问有多少个小孩能够吃到满足条件的蛋糕
        //每个孩子最多只能给一块饼干。
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int g_i =0,s_i = 0;
        while (s_i < s.length && g_i < g.length) {
            if (g[g_i] <= s[s_i]){  //孩子的胃小于饼干尺寸
                s_i++;
                g_i++;
                result++;
            }else{
                s_i++;
            }
        }
        return result;
    }
}
