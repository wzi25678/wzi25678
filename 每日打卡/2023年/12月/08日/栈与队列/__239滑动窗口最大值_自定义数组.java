package 代码随想录.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class __239滑动窗口最大值_自定义数组 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        //存放结果元素的数组
        int [] res = new int[nums.length - k + 1];
        int num = 0;
        //自定义队列
        MyQueue myQueue = new MyQueue();
        //先将前K的元素放入队列
        for (int i = 0; i < k;i++){
            myQueue.add(nums[i]);
        }
        res[num++] = myQueue.peek();
        for (int i = k; i < nums.length; i++) {
            //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
            myQueue.poll(nums[i - k]);
            //滑动窗口加入最后面的元素
            myQueue.add(nums[i]);
            //记录对应的最大值
            res[num++] = myQueue.peek();
        }
        return res;
    }
}
//class MyQueue {
//    Deque<Integer> deque = new LinkedList<>();
//    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
//    //同时判断队列当前是否为空
//    void poll(int val) {
//        if (!deque.isEmpty() && deque.peek() == val) {
//            deque.poll();
//        }
//    }
//
//    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
//    //保证队列元素单调递减
//    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
//    void add(int val) {
//        while (!deque.isEmpty() && deque.getLast() < val) {
//            deque.removeLast();
//        }
//        deque.add(val);
//    }
//
//    //队列队顶元素始终为最大值
//    int peek() {
//        return deque.peek();
//    }
//}
