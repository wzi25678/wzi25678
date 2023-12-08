package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _216组合总和III_组合枚举II {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> lists = new ArrayList<Integer>();
    /**
     *
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrack(1,9,k, n);
        return result;
    }

    private void backTrack(int startIndex, int n, int k, int sum) {
        if (lists.size() + (n - startIndex + 1) < k || lists.size() > k){
            return;
        }
        if (lists.size() == k) {
            int tempSum = 0;
            for (int num:lists){
                tempSum += num;
            }
            if (tempSum == sum){
                result.add(new ArrayList<Integer>(lists));
                return;
            }
        }
        lists.add(startIndex);
        backTrack(startIndex+1,n,k,sum);
        lists.remove(lists.size() - 1);
        backTrack(startIndex+1,n,k,sum);
    }
}
