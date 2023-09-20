package LeetCode中等题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class __229多数元素II__进阶__哈希统计{
    /*
       普通耗时的方法：
            可以Arrays.sort()排序，然后定义n = length/3，
            然后去判断
     */
    //进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
    //要满足上述条件，也就是一遍遍历，同时构造常数的辅助空间。
    public List<Integer> majorityElement(int[] nums) {
        /*
            用HashMap，KV键值对去操作。
         */
        HashMap<Integer,Integer> count = new HashMap<>();
        int n = nums.length;
        for (int i=0;i<n;i++){
            if (count.containsKey(nums[i])){
                count.put(nums[i],count.get(nums[i]) + 1);
            }else {
                count.put(nums[i],1 );
            }
        }
        //上面已经映射完了，接下来去获取满足条件的答案有哪些
        List<Integer> res = new ArrayList<>();
        for (int x : count.keySet()){
            if (count.get(x) > n/3){
                res.add(x);
            }
        }
        return res;
    }
}
