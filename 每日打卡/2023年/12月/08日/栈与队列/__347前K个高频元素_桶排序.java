package 代码随想录.栈与队列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class __347前K个高频元素_桶排序 {
    /**
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k){
        HashMap<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList();
            }
            list[i].add(key);
        }
        // 倒序遍历数组获取出现顺序从大到小的排列
        int [] res = new int[k];
        int count =  0;
        for (int i = list.length;i>=0;i--){
            if (list[i]!= null){continue;}
            List<Integer> listSon = list[i];
            for (int j = 0;j<listSon.size();j++){
                int key = listSon.get(j);
                if (count < k) {
                    res[count++] = key;
                }
            }
        }
        return res;
    }
}
