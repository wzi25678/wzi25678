package LeetCode中等题;

import java.util.HashMap;
import java.util.Map;

public class __932漂亮数组__发现规律_进行分治 {
    /**
     nums 是由范围 [1, n] 的整数组成的一个排列。
     对于每个 0 <= i < j < n ，均不存在下标 k（i < k < j）使得 2 * nums[k] == nums[i] + nums[j] 。

     题目解释：
     【输入】   -> 输入一个n，n即长度，用到的数字，则是1-n这n数字
     【输出】   输出，由1-n这n数字组成的一个数组，然后数组要满足一下的条件，即不存在：
                对于每个 0 <= i < j < n ，均不存在下标 k（i < k < j）使得 2 * nums[k] == nums[i] + nums[j] 。

     解题思路：
        个人感觉肯定需要用到的是dp，即因为需要找到一个满足上要求的数组，则至少要保证在，之前的长度中，他其实就需要满足长度需求。
        即，在原本已经满足题目要求的完美数组中，我又重新插入一个新的数组，然后这个数组我又去找到一个合适的插入位置，使它满足要求。


     * @param n
     * @return
     */
    Map<Integer,int []> memo = new HashMap<Integer,int []>();
    public int[] beautifulArray(int n) {
        return partition_findRule(n);
    }

    /**
     *
     * @param n
     * @return
     */
    private int[] partition_findRule(int n) {
        if (memo.containsKey(n)){
            return memo.get(n);
        }
        int res [] = new int[n];
        if (n == 1){
            res[0] = 1;
        }else{
            int temp = 0;
            for (int x:partition_findRule((n+1)/2)){    //取所有的偶数odds
                res[temp++] = 2 * x - 1;
            }
            for (int x:partition_findRule(n/2)){    //取所有的奇数evens
                res[temp++] = 2 * x;
            }
        }
        memo.put(n,res);
        return res;
    }
}
