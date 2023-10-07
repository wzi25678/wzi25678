package 西湖算法题解___中等题02;

public class 设计一个支持对其元素进行增量操作的栈 {
	public static void main(String[] args) {
		//CustomStack(int maxSize)：用 maxSize 初始化对象，maxSize 是栈中最多能容纳的元素数量。
		//void push(int x)：如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
		//int pop()：弹出栈顶元素，并返回栈顶的值，或栈为空时返回 -1 。
		//void inc(int k, int val)：栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
	}

	/**
	 *
	 */
	class CustomStack {
		private int stack[];
		private int topSite;    //栈顶指针

		public CustomStack(int maxSize) {
			stack = new int[maxSize];
			topSite = -1;   //位置指针，我选择从0开始记录顶部
		}

		public void push(int x) {   //如果栈还未增长到 maxSize ，就将 x 添加到栈顶。
			if (topSite != stack.length - 1){
				++topSite;
				stack[topSite] = x;
			}
			//我们用一个辅助数组 add 记录每次 inc 操作。
		}

		public int pop() {  //出栈
			if (topSite == -1){
				return -1;
			}
			topSite--;
			return stack[topSite+1];

		}

		public void increment(int k, int val) {
			//(a <= b) ? a : b;
			//8算哪个呢？算k.
			//如果栈中元素总数小于 k
			int limit = Math.min(k,topSite+1);    //栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
			for (int i=0;i<limit;i++){
				stack[i] += val;
			}
		}

	}
}
