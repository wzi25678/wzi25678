package 西湖算法题解___简单题;

import java.util.Stack;

public class __155最小栈 {
	public static void main(String[] args) {

	}

	class MinStack {

		//数据栈
		private Stack<Integer> data;
		//辅助栈,帮助实现在常数时间内找到最小值的栈内元素
		private Stack<Integer> helper;


		//---------------------------------------------------------------------------
		//下面的都是有关一个栈的各种操作方法

		public MinStack() {
			//MinStack() 初始化堆栈对象。
			data = new Stack<>();
			helper = new Stack<>();
		}

		public void push(int val) {
			//void push(int val) 将元素val推入堆栈。
			data.add(val);
			if (helper.isEmpty() || helper.peek() >= val){
				helper.add(val);
			}
		}

		public void pop() {
			if (!data.isEmpty()){
				int top = data.pop();
				//如果这个pop的数，刚好也就是辅助数组中记录的最小数，则辅助数组helper[]也要出栈
				if (top == helper.peek()){
					helper.pop();
				}
			}
		}



		public int top() {
			if (!data.isEmpty()){
				return data.peek();
			}
			return  -1;
//			return data.peek();
		}

		public int getMin() {
			//int getMin() 获取堆栈中的最小元素。
			if (!helper.isEmpty()){
				return helper.peek();
			}
			return -1;
//			return helper.peek();
		}
	} //class MinStack
}
