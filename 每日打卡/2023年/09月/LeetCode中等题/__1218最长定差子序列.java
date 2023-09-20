package LeetCode中等题;

import java.util.HashMap;

public class __1218最长定差子序列 {
    /**
     * difference 是等差数列的差额
     * 然后我要输出最长的满足条件的等差数列的长度
     *
     * @param arr
     * @param difference
     * @return
     */
    public int longestSubsequence(int[] arr, int difference) {
        //这也是一种常见的题目吧，就是找满足条件的数，然后怎么在一轮时间内就可以完成
        //啊，看来长得一样，但是结题思路完全不一样啊，这道题居然用的是动态规划dp
        //贪心思想。。。。。
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {   //一次遍历
            Integer val = map.get(arr[i] - difference);
            if (val != null) {
                map.put(arr[i], val + 1);
                max = max >= val + 1 ? max : val + 1;
            } else {
                map.put(arr[i], 1);
            }
        }
        return max;
    }
}
