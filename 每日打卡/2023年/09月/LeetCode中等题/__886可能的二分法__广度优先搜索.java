package LeetCode中等题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class __886可能的二分法__广度优先搜索 {
    /**

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
            if (color[i] == 0){
                Queue<Integer> queue = new ArrayDeque<Integer>();
                queue.offer(i);
                color[i] = 1;
                while (!queue.isEmpty()){
                    int t = queue.poll();
                    for (int next:g_dyeing[t]){
                        if (color[next] > 0 && color[next] == color[t]){
                            return false;
                        }
                        if (color[next] == 0){
                            color[next] = 3^color[t];
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return true;
    }
}
