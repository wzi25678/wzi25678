package 代码随想录.栈与队列;


import java.util.*;

public class __239滑动窗口最大值 {
    /**
     *  数据范围：
     *      提示：
     * 1 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * 1 <= k <= nums.length
     *
     *      题目分析：
     *      通过时间复杂度可以看出 ，不能上升到O（n^2）
     *      即，最好一次遍历
     *      难点在于，如果最左边的值是当前的max的话，移动的时候，会直接刷掉原本的最大值，此时需要去寻找“新的最大值”
     *      而这个最大值，又恰好是，原来窗口内的第二大值
     *      也就是我们每次都需要知道当前窗口的最大值，第二大值，，，同时去判断一下移除去的元素，是我们当前窗口最值的哪一个？
     *      而在数据结构中，堆heap就满足我们想要的结构
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int res [] = new int [nums.length-k+1];
        //在java中，我们用优先队列(PriorityQueue<int []>)去实现堆
            //Deque<Integer> deque = new ArrayDeque<Integer>();
            //模仿Deque结构，()里面传入比较方法
        PriorityQueue<int []> myHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {    //前后顺序相减，则是默认从小到大顺序
                return o1[0]!= o2[0]? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        for (int i = 0;i<k;i++) {       //先放入k个元素
            myHeap.offer(new int[]{nums[i],i});
        }
        res[0] = myHeap.peek()[0];
        for (int i = k;i<nums.length;i++) {
            myHeap.offer(new int[]{nums[i],i});
            while (myHeap.peek()[1] <= i - k){
                myHeap.poll();
            }
            res[i-k+1] = myHeap.peek()[0];
        }
        return res;
    }
}
