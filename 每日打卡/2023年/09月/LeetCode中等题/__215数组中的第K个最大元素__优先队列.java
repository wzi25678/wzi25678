package LeetCode中等题;

import java.util.Comparator;
import java.util.PriorityQueue;

public class __215数组中的第K个最大元素__优先队列 {
   //维护一个有 K 个元素的最小堆
   public int findKthLargest(int[] nums, int k) {
       int len = nums.length;
       //使用一个含有 k 个元素的最小堆，PriorityQueue 底层是动态数组，为了防止数组扩容产生消耗，可以先指定数组的长度
       /**
        *   PriorityQueue？
        *   Comparator.comparingInt(a -> a)的含义
        *
        */
       PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));
       for (int i=0;i<k;i++){       //开局先直接放k个进去
           minHeap.offer(nums[i]);
       }

       for (int i=k;i<len;i++){     //从第K+1个开始进行操作
           Integer topElement = minHeap.peek();
           //只要当前遍历的元素比堆顶元素大，队顶弹出，遍历的元素进去
           if (nums[i] > topElement){
               minHeap.poll();
               minHeap.offer(nums[i]);
           }
       }
       return minHeap.peek();
   }

}
