package 西湖算法题解___简单题;

import java.util.Stack;

public class __232用栈实现队列 {
	public static void main(String[] args) {

	}
	class MyQueue {
		private Stack<Integer> a_input_stack;       //输入栈
		private Stack<Integer> b_output_stack;      //输出栈

		public MyQueue() {      //第一个初始化栈
			a_input_stack = new Stack<Integer>();
			b_output_stack = new Stack<Integer>();
		}

		public void push(int x) {   //push，入栈操作
			a_input_stack.push(x);
		}

		/**
		 * 【后进先出】，改成【先进先出】，核心要点就在于出的时候，有一个记录，记录了进来的情况
		 * ，即把a的输入，输出到B中，则b就会转变成先进先出
		 * @return
		 */
		public int pop() {  //出栈操作
			if (b_output_stack.isEmpty()){
				while (!a_input_stack.isEmpty()){
					b_output_stack.push(a_input_stack.pop());
				}
			}
			return b_output_stack.pop();

		}

		public int peek() {
			if (b_output_stack.isEmpty()){
				while (!a_input_stack.isEmpty()){
					b_output_stack.push(a_input_stack.pop());
				}
			}
			return b_output_stack.peek();

		}

		public boolean empty() {
			return a_input_stack.isEmpty() && b_output_stack.isEmpty();

		}
	}
}
