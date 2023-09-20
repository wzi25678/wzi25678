package LeetCode中等题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class __229多数元素II__哈希统计 {
    public List<Integer> majorityElement(int[] nums) {
        /*
        1 <= nums.length <= 5 * 104
        -10^9 <= nums[i] <= 10^9
         */
        HashMap<Integer,Integer> count = new HashMap<Integer,Integer>();
        for (int i=0;i< nums.length;i++){
            if (count.containsKey(nums[i])){
                count.put(nums[i],count.get(nums[i] + 1));
            }else {
                count.put(nums[i],1 );
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int key : count.keySet()){
            if (count.get(key) >nums.length/3){
                res.add(key);
            }
        }
        return res;
    }
}
