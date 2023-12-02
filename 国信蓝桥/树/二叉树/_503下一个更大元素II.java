package 代码随想录.树.二叉树;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class _503下一个更大元素II {
    /**
     * 每一个节点都去返回当前数组中比他大的下一个元素的值，如果没有的话，则返回-1
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        // TODO 一句话总结：凡是看到寻找下一个最大/小的这种题目，必选单调栈，然后会有许多变种，可以具体情形具体处理
        int n = nums.length;
        int [] res = new int[n];
        Arrays.fill(res,-1);
        Deque<Integer> myStack = new ArrayDeque<Integer>();
        for (int i = 0; i < n * 2 - 1; i++){
            while (!myStack.isEmpty() && nums[myStack.peek()] < nums[i % n]){
                res[myStack.pop()] = nums[i%n];
            }
            myStack.push(i%n);
        }
        return res;
    }
}
