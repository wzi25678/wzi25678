package 西湖算法题解___中等题;

public class __900RLE迭代器 {

	class RLEIterator {
		//int next(int n) 以这种方式耗尽后 n 个元素并返回最后一个耗尽的元素。如果没有剩余的元素要耗尽，则返回 -1 。
		//输入分两个，一个是操作命令
		//          下面对应的则是操作的数组，已经跨越的个数
		//          然后每次返回跨越的最后一个数组元素值，并且返回-1
		/**
		 *
		 * @param encoding
		 */
		int encoding [];
		int index,queue;

		public RLEIterator(int[] encoding) {    //构造器
			this.encoding = encoding;
			index = queue = 0;
		}

		public int next(int n) {
			while (index < encoding.length){
				if (queue + n > encoding[index]){
					n -= encoding[index] - queue;
					queue = 0;
					index += 2;
				}else {
					queue += n;
					return encoding[index+1];
				}
			}
			return -1;
		}
	}
}
