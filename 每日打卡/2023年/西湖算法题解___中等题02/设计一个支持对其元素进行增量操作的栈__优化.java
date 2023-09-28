package 西湖算法题解___中等题02;

public class 设计一个支持对其元素进行增量操作的栈__优化 {
	class CustomStack {
		private int [] stack;
		private int [] add; //			}
		//我们用一个辅助数组 add 记录每次 inc 操作。
		private int topSite;

		/**
		 *
		 * @param maxSize
		 */
		public CustomStack(int maxSize) {
			stack = new int[maxSize];
			topSite = -1;   //位置指针，我选择从0开始记录顶部
			add = new int[maxSize];
		}

		/**
		 *
		 * @param x
		 */
		public void push(int x) {
			if (topSite != stack.length - 1){
				++topSite;
				stack[topSite] = x;
			}
		}

		public int pop() {
			if (topSite == -1){
				return -1;
			}
			int res = stack[topSite] + add[topSite];
			if (topSite != 0){
				add[topSite - 1] += add[topSite];
			}
			add[topSite] = 0;
			topSite--;
			return res;
		}

		public void increment(int k, int val) {
			int limit = Math.min(k,topSite+1);    //栈底的 k 个元素的值都增加 val 。如果栈中元素总数小于 k ，则栈中的所有元素都增加 val 。
			//这里换一种表达就是Math.min(k-1,topSite)
			for (int i=0;i<limit;i++){
				stack[i] += val;
			}
		}
	}
}
