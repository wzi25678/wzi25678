package 日常Java程序测试.代码随想录.栈与队列.栈与队列相互转换;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class __225用队列实现栈 {
	class MyStack {
		Deque<Integer> queue1;
		Deque<Integer> queue2;
		public MyStack() {
			queue1 = new LinkedList<Integer>();
			queue2 = new LinkedList<Integer>();
		}
		//void push(int x) 将元素 x 压入栈顶。
		public void push(int x) {
			queue2.offer(x);
			while (!queue1.isEmpty()){
				queue2.offer(queue1.poll());
			}
			Deque<Integer> temp = queue1;
			queue1 = queue2;
			queue2 = temp;
		}
		//int pop() 移除并返回栈顶元素。
		public int pop() {
			return queue1.poll();

		}
		//int top() 返回栈顶元素。
		public int top() {
			return queue1.peek();

		}
		//boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
		public boolean empty() {
			return queue1.isEmpty();
		}
	}
}
