package 日常Java程序测试.代码随想录.栈与队列.栈与队列相互转换;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ___232用栈实现队列 {
	public static void main(String[] args) {
		Deque stackDeque = new ArrayDeque();    //顺序Deque
		Deque stackDeque1 = new LinkedList();   //链式Deque
 		//目前最主流，高效的方式，就是使用Deque stackDeque 去构造双端队列，来模拟栈
	}
	class MyQueue {
		//定义出属性，对象
		//这个就是构造双端队列去模拟栈啊？？？？
		Deque<Integer> inStack;
		Deque<Integer> outStack;

		public MyQueue() {
			inStack = new ArrayDeque<Integer>();
			outStack = new ArrayDeque<Integer>();
		}
		//void push(int x) 将元素 x 推到队列的末尾
		public void push(int x) {
			inStack.push(x);
		}

		//int pop() 从队列的开头移除并返回元素
		public int pop() {
			if (outStack.isEmpty()){
				//没有元素可以pop，考虑一下inStack 传值给 outStack
				inStack_To_outStack();
			}
			return outStack.pop();
		}

		/**
		 *
		 */
		private void inStack_To_outStack() {
			//把入栈元素放到出栈元素中
			while (!inStack.isEmpty()){
				outStack.push(inStack.poll());
			}

		}
		//int peek() 返回队列开头的元素
		public int peek() {
			if (outStack.isEmpty()){
				//没有元素可以pop，考虑一下inStack 传值给 outStack
				inStack_To_outStack();
			}
			return outStack.peek();

		}
		//boolean empty() 如果队列为空，返回 true ；否则，返回 false
		public boolean empty() {
			return inStack.isEmpty() && outStack.isEmpty();
		}
	}
}
