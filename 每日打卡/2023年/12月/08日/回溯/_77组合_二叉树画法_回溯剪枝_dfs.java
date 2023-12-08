package 代码随想录.回溯;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class _77组合_二叉树画法_回溯剪枝_dfs {
    /**
     *
     * @param n :从1-n这n个数
     * @param k ：每次选取k个数
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k <= 0 || n < k) {
            return result;
        }
        Deque<Integer> paths = new ArrayDeque<Integer>();
        dfs(n,k,1,paths,result);
        return result;
    }

    /**
     *
     * @param n
     * @param k
     * @param curNum
     * @param paths
     * @param result
     */
    private void dfs(int n, int k,int curNum, Deque<Integer> paths, List<List<Integer>> result) {
        // TODO Auto-generated method stub
        //先判断终止条件
        if (paths.size() == k){
            result.add(new ArrayList<>(paths));
           // paths.remove();
            return;
        }
        //遍历所有可能得数字
        for (int i = curNum;i<=n;i++){
            //向路径变量里添加一个数
            paths.addLast(i);
            dfs(n,k,i++,paths,result);
            paths.removeLast();
        }
    }
}
