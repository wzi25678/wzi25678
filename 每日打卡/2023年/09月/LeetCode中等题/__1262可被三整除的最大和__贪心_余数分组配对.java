package LeetCode中等题;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class __1262可被三整除的最大和__贪心_余数分组配对 {
    public static void main(String[] args) {
        int nums[] = {3,6,5,1,8};
        maxSumDivThree(nums);
    }
    /**
     *
     * @param nums
     * @return
     */
    public static int maxSumDivThree(int[] nums) {
        //用v_remind[i]来表示余数
        List<Integer> v_remind [] = new List[3];
        for (int i=0;i<3;i++){
            v_remind[i] = new ArrayList<Integer>();
        }
        //按余数值进行分组
        for (int num : nums){
            v_remind[num % 3].add(num);
        }
        Collections.sort(v_remind[1],(a,b)-> b-a);  //自定义Collecctions类的v_remind[1]排序规则
        Collections.sort(v_remind[2],(a,b)-> b-a);  //自定义Collecctions类的v_remind[2]排序规则
        int ans = 0;
        int lb = v_remind[1].size(),lc = v_remind[2].size();
        //每一个v_remind[1]和一个v_remind[2]，都可以进行匹配为一组
        //因此，我应该是放任所有的v_remind[0]不去管
        //然后大小排序好1,2.。。。。。。。
        //然后每一组1,2就从大到小区合并
        //同时不能让他们某一组多余值大于%3的余数，因为任何数得余数都一个除以3
        for(int countB = lb-2;countB <= lb;countB++){
            if (countB >= 0){
                for (int countC = lc-2;countC<= lc;countC++){
                    if (countC >=0 && (countB - countC)%3 == 0){
                        ans = Math.max(ans,getSum(v_remind[1],0,countB)+getSum(v_remind[2],0,countC));
                    }
                }
            }
        }
        return ans+getSum(v_remind[0],0,v_remind[0].size());
    }

    /**
     *
     * @param listRemind
     * @param start
     * @param end
     * @return
     */
    private static int getSum(List<Integer> listRemind, int start, int end) {
        int sum = 0;
        for (int i = start;i<end;i++){
            sum += listRemind.get(i);
        }
        return sum;
    }
}
