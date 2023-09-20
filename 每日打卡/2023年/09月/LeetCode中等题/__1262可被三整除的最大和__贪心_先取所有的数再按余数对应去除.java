package LeetCode中等题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class __1262可被三整除的最大和__贪心_先取所有的数再按余数对应去除 {
    /**

     *
     * @param nums
     * @return
     */
    public int maxSumDivThree(int[] nums) {
        //用v_remind[i]来表示余数
        // 使用 v[0], v[1], v[2] 分别表示 a, b, c
        List<Integer> v_remind[] = new List[3];
        for (int i=0;i<3;i++){
            v_remind[i] = new ArrayList<Integer>();
        }
        //按余数值进行分组
        for (int num : nums){
            v_remind[num % 3].add(num);
        }
        Collections.sort(v_remind[1],(a, b)-> b-a);  //自定义Collecctions类的v_remind[1]排序规则
        Collections.sort(v_remind[2],(a,b)-> b-a);  //自定义Collecctions类的v_remind[2]排序规则
        int total = Arrays.stream(nums).sum();
        int remove = Integer.MAX_VALUE;

        if (total % 3 == 0){
            remove = 0;
        } else if (total % 3 == 1) {
            if (v_remind[1].size() >= 1){
                remove = Math.min(remove,v_remind[1].get(v_remind[1].size() - 1));
            }
            if (v_remind[2].size() >= 2){
                remove = Math.min(remove,v_remind[2].get(v_remind[2].size() - 2) + v_remind[2].get(v_remind[2].size() - 1) );
            }
        }else {
            if (v_remind[1].size() >= 2){
                remove = Math.min(remove,v_remind[1].get(v_remind[1].size() - 2)+v_remind[1].get(v_remind[1].size() - 1));
            }
            if (v_remind[2].size() >= 1){
                remove = Math.min(remove,v_remind[2].get(v_remind[2].size() - 1));
            }
        }
        return total - remove;
    }
}
