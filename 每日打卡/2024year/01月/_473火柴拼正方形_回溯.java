package 代码随想录.动态规划;

import java.util.Arrays;

public class _473火柴拼正方形_回溯 {
    /**
     *
     * @param matchsticks
     * @return
     */
    public boolean makesquare(int[] matchsticks) {
        int allSum = Arrays.stream(matchsticks).sum();
        if (allSum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        for (int i = 0,j = matchsticks.length-1; i < j; i++,j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }
        int [] edges = new int[4];
        return dfs(0,matchsticks, edges,allSum / 4);
    }
    /**
     *
     * @param index
     * @param matchsticks
     * @param edges
     * @param average
     * @return
     */
    private boolean dfs(int index, int[] matchsticks, int[] edges, int average) {
        if (index == matchsticks.length){
            return true;
        }
        for (int i = 0;i<edges.length;i++){
            edges[i] += matchsticks[index];
            if (edges[i] <= average && dfs(index + 1 ,matchsticks,edges,average)){
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
