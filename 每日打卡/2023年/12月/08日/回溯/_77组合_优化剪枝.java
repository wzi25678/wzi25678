package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _77组合_优化剪枝 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();   //子节点上来就要继承LinkedList
    //Deque<Integer> list = new LinkedList<Integer>();
    /**
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        backTrackYH(n, k,1);
        return result;
    }

    /**
     *
     * @param n
     * @param k
     * @param curNum
     */
    private void backTrackYH(int n, int k, int curNum) {
        if (list.size() == k){
            result.add(new ArrayList<>(list));
            //result.add(list);
            return;
        }
        for (int i =curNum;i<=n-(k - list.size()) + 1;i++){
            list.add(i);
            backTrackYH(n,k,i+1);
            list.removeLast();
        }
    }
}
