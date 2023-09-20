package LeetCode中等题;

import java.util.HashMap;
import java.util.Map;

public class __525连续数组 {
    public int findMaxLength(int[] nums) {
        //即要有相同个数的【0，1】字符串。
        /*

        1 <= nums.length <= 105
        nums[i] 不是 0 就是 1

         */
        int maxLength = 0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int counter = 0;
        map.put(counter,-1);
        int n = nums.length;
        for (int i = 0;i<n;i++){
            int num = nums[i];
            if (num == 1){
                counter++;
            }else{
                counter--;
            }
            if (map.containsKey(counter)){
                int prevIndex = map.get(counter);
                maxLength = Math.max(maxLength,i-prevIndex);
            }else {
                map.put(counter,i);
            }
        }
        return maxLength;
    }
}
