package 代码随想录.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class __239滑动窗口最大值_利用双端队列手动实现单调队列 {
    public int[] maxSlidingWindow(int[] nums, int k){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int [] res = new int[n - k + 1];
        int index = 0;
        for (int i = 0; i < n; i++){
            // 根据题意，i为nums下标，是要在[i - k + 1, i] 中选到最大值，只需要保证两点
            // 1.队列头结点需要在[i - k + 1, i]范围内，不符合则要弹出
            // 2.既然是单调，就要保证每次放进去的数字要比末尾的都大，否则也弹出
                //要求1：
            while (!deque.isEmpty() && deque.peek() < i - k +1){
                deque.poll();
            }
                //要求2：
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if (i >= k - 1){
                res[index++] = nums[deque.peek()];
            }
        }
        return res;
    }
}

class MyQueue {
    Deque<Integer> deque = new LinkedList<>();
    //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
    //同时判断队列当前是否为空
    void poll(int val) {
        if (!deque.isEmpty() && deque.peek() == val) {
            deque.poll();
        }
    }

    //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
    //保证队列元素单调递减
    //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
    void add(int val) {
        while (!deque.isEmpty() && deque.getLast() < val) {
            deque.removeLast();
        }
        deque.add(val);
    }

    //队列队顶元素始终为最大值
    int peek() {
        return deque.peek();
    }
}
