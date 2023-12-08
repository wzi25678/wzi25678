package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _216组合总和III_组合枚举 {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();   //子节点上来就要继承LinkedList
    /**
     找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     - 只使用数字1到9
     - 每个数字 最多使用一次
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(1,9,k,n);
        return result;
    }

    /**
     *
     * @param cur
     * @param n
     * @param k
     * @param sum
     */
    private void backTrack(int cur, int n, int k, int sum) {
        if (list.size() + (n - cur + 1) < k || list.size() > k) {
            return;
        }
        if (list.size() == k) {
            int tempSum = 0;
            for (int num : list) {
                tempSum += num;
            }
            if (tempSum == sum) {
                result.add(new ArrayList<Integer>(list));
                return;
            }
        }
        list.add(cur);
        backTrack(cur + 1, n, k, sum);
        //list.removeLast();
        list.remove(list.size() - 1);
        backTrack(cur + 1, n, k, sum);
    }
}
