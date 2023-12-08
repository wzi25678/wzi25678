package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _216组合总和III {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    //List<Integer> lists = new ArrayList<Integer>();
    LinkedList<Integer> lists = new LinkedList<Integer>();
    /**
     *  找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     只使用数字1到9
     每个数字 最多使用一次
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(n,k,1,0);
        return result;
    }


    /**
     *
     * @param targetSum
     * @param k     需要有k个数
     * @param startIndex
     * @param curSum
     */
    private void backTrack(int targetSum, int k, int startIndex, int curSum) {
        //剪枝
        if (curSum > targetSum){
            return;
        }
        if (lists.size() == k){
            if (curSum == targetSum) {
                result.add(new ArrayList<>(lists));

            }
            return;
        }
        //剪枝优化掉，9 - (k - path.size()) + 1
        for (int i = startIndex; i<=9 - (k - lists.size())+ 1;i++){
            lists.add(i);
            curSum += i;
            backTrack(targetSum,k,i+1,curSum);
            //回溯参数和对应的值
            lists.remove(lists.size() - 1);
            // lists.removeLast();  //LinkedList<Integer>才能继承该方法。
            curSum-=i;
        }
    }
}
