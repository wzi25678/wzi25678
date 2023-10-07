package 西湖算法题解___中等题02;

import java.util.HashMap;
import java.util.Map;

public class __947移除最多的同行或同列石头 {
	/**
	 每个坐标点上最多只能有一块石头。
	 如果一块石头的【同行或者同列】上有其他石头存在，那么就可以移除这块石头。(以自身为参考，有满足要求的话，则删除自身)

	 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。
	 ->-> 怎么去移出里面的元素，才能使移出的元素最多呢？

	 * @param stones
	 * @return
	 */
	public int removeStones(int[][] stones) {
		//最多可以移除的石头的个数 = 所有石头的个数 - 连通分量的个数。
		//需要连通分量的个数
		UnionComponentFind unionComponentFind = new UnionComponentFind();
		for (int [] stone : stones){    //每一个两元素数组代表着一个坐标
			//下面这三种写法任选其一
			unionComponentFind.union(~stone[0],stone[1]);
//			unionComponentFind.union(stone[0] - 10001,stone[1]);
//			unionComponentFind.union(stone[0] + 10001,stone[1]);
		}
		return stones.length - unionComponentFind.getCount();
	}

	/**
	 *
	 */
	private class UnionComponentFind{
		private Map<Integer,Integer> parent;
		private int count;

		public UnionComponentFind() {
			this.parent = new HashMap<>();
			this.count = 0;
		}

		public Map<Integer, Integer> getParent() {
			return parent;
		}

		public void setParent(Map<Integer, Integer> parent) {
			this.parent = parent;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		/**
		 *
		 * @param x
		 * @return
		 */
		public int find(int x){
			if (!parent.containsKey(x)){
				parent.put(x,x);        //添加进来的首个节点。
				// 并查集中新加入一个结点，结点的父亲结点是它自己，所以连通分量的总数 +1
				count++;
			}
			if (x != parent.get(x)){
				parent.put(x,find(parent.get(x)));
			}
			return parent.get(x);
		}

		/**
		 *
		 * @param x
		 * @param y
		 */
		public void union(int x,int y){
			int rootX = find(x);
			int rootY = find(y);
			if (rootX == rootY){
				return;
			}
			parent.put(rootX,rootY);
			//两个连通分量合并成为一个，连通分量的总数 - 1
			count--;
		}
	}
}
