package 西湖算法题解___中等题02;

import java.util.ArrayDeque;
import java.util.Deque;

public class __1019链表中的下一个更大节点__用每个数更新其它数的下一个更大元素 {
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
		for (ListNode curNode = head;curNode != null;curNode = curNode.next){
			n++;    //确定返回值的长度
		}
		int [] ans = new int[n];
		Deque<int []> monotonicStack = new ArrayDeque<int []>();    //单调栈（节点值、节点下标）
		int index = 0;
		for (ListNode curNode = head;curNode != null;curNode = curNode.next){
			while (!monotonicStack.isEmpty() && monotonicStack.peek()[0] < curNode.val){
				ans[monotonicStack.pop()[1]] = curNode.val;     //用当前节点值更新答案
			}
			monotonicStack.push(new int[]{curNode.val,index++});
		}
		return ans;
	}
}
