package 代码随想录.栈与队列;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class __347前K个高频元素_堆排序 {
    /**
     * 1 <= nums.length <= 105
     * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
 /**       本质还是要你找一种算法，时刻能够返回前N个数
        毫无疑问，用到的结构就是堆Heap -> 用PriorityQueue去实现
  */
        //设置一个map集合,key存放数字,value存放出现次数
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //统计出现次数
        for (int num :nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //建立一个大根堆,用来存放key值,堆内元素按照key对应的value值从大到小排序
        PriorityQueue<Integer> myHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {      //大顶堆，从小到大往里插
                return map.get(o1) - map.get(o2);
            }
        });
        //将map中的数字,插入到大根堆中
        for (Integer key : map.keySet()){
            if (myHeap.size() < k){
                myHeap.add(key);
            } else if (map.get(key) > map.get(myHeap.peek())) {
                myHeap.poll();
                myHeap.add(key);
            }
        }
        //将大根堆中的k个数字放到数组中
        int [] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = myHeap.poll();
        }
        return res;
    }
}
