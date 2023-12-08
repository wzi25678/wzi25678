package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _77组合_未剪枝优化 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    LinkedList<Integer> list = new LinkedList<Integer>();   //子节点上来就要继承LinkedList
    //Deque<Integer> list = new LinkedList<Integer>();
    /**
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        backTrack(n, k,1);
        return result;
    }
    /**
     *
     * @param n
     * @param k
     * @param curNum
     */
    private void backTrack(int n, int k, int curNum) {
        if (list.size() == k){
            result.add(new ArrayList<>(list));
            //result.add(list);
            return;
        }
        for (int i =curNum;i<=n;i++) {
            list.add(i);
            backTrack(n,k,i+1);
            list.removeLast();
        }
    }
}
