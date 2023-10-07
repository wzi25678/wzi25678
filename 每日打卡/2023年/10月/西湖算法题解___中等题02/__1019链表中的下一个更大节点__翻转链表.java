package 西湖算法题解___中等题02;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class __1019链表中的下一个更大节点__翻转链表 {

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}


	private int n;
	/**
	 *
	 * @param head
	 * @return
	 */
	public int[] nextLargerNodes(ListNode head) {
		head = reverseList(head);
		int [] ans = new int[n];
		Deque<Integer> monotonicStack = new ArrayDeque<Integer>();
		for (ListNode curNode = head;curNode != null;curNode = curNode.next){
			while (!monotonicStack.isEmpty() && monotonicStack.peek() <= curNode.val){
				monotonicStack.pop();   //弹出无用的数据
			}
			ans[--n] = (monotonicStack.isEmpty() ? 0:monotonicStack.peek());
			monotonicStack.push(curNode.val);
		}
		return ans;
	}

	/**
	 * 反转链表
	 * @param head
	 * @return
	 */
	private ListNode reverseList(ListNode head) {
		ListNode pre = null,cur = head;
		while (cur != null){
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
			n++;
		}
		return pre;
	}

}
