package 西湖算法题解___中等题02;

import java.util.ArrayDeque;
import java.util.Deque;

public class __1019链表中的下一个更大节点__用每个数更新其它数的下一个更大元素__优化 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	/**
	 *
	 * @param head
	 * @return
	 */
	public int[] nextLargerNodes(ListNode head) {
		int n = 0;
		for (ListNode curNode = head;curNode != null ;curNode = curNode.next){
			n++;    //确定返回值的长度
		}
		int ans [] = new int[n];
		Deque<Integer> monotonicStack = new ArrayDeque<Integer>();      //Integer类型，Deque结构。
		int index = 0;
		for (ListNode curNode = head;curNode != null ;curNode = curNode.next){
			while (!monotonicStack.isEmpty() && ans[monotonicStack.peek()] < curNode.val){
				ans[monotonicStack.pop()] = curNode.val;
			}
			monotonicStack.push(index);
			ans[index++] = curNode.val;
		}
		for (int idx : monotonicStack){
			ans[idx] = 0;
		}
		return ans;
	}
}
