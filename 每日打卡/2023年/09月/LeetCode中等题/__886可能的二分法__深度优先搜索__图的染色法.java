package LeetCode中等题;

import java.util.ArrayList;
import java.util.List;

public class __886可能的二分法__深度优先搜索__图的染色法 {
    /**
     输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
     n代表n个人，dislike中数组表示指定两个不能配在一起。

     问：：能否找到满足条件的情况？

     * @param n
     * @param dislikes
     * @return
     */
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int color [] = new int[n+1];
        List<Integer> [] g_dyeing = new List[n+1];
        for (int i=0;i<=n;i++){
            g_dyeing[i] = new ArrayList<Integer>();
        }
        for (int p[] :dislikes){
            g_dyeing[p[0]].add(p[1]);
            g_dyeing[p[1]].add(p[0]);
        }
        for (int i=1;i<=n;i++){
            if (color[i] == 0 && !dfs_possibleBipartition(i,1,color,g_dyeing)){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param curNode
     * @param nowColor
     * @param color
     * @param g_dyeing
     * @return
     */
    private boolean dfs_possibleBipartition(int curNode, int nowColor, int[] color, List<Integer>[] g_dyeing) {
        color[curNode] = nowColor;
        for (int nextNode : g_dyeing[curNode]){
            if (color[nextNode] != 0 && color[nextNode] == color[curNode]){
                return false;
            }
            if (color[nextNode] == 0 && !dfs_possibleBipartition(nextNode,3^nowColor,color,g_dyeing)){
                return false;
            }
        }
        return true;
    }
}
