package 西湖算法题解___中等题02;

import java.util.ArrayDeque;
import java.util.Deque;

public class __1019链表中的下一个更大节点__遍历 {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	/**
	 给定一个长度为 n 的链表 head
	 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
	 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。

	 就是说，每个节点都去返回后面比它大，且最大的节点的值。
	 如果不存在这样一个节点，那么则返回0

	 * @param head
	 * @return
	 */
	private int[] ans;
	private final Deque<Integer> monotonicStack = new ArrayDeque<>();   //单调栈（节点）
	public int[] nextLargerNodes(ListNode head) {
		findStack(head,0);
		return ans;
	}

	private void findStack(ListNode node,int i){
		if (node == null){
			ans = new int[i];   // i 就是链表长度
			return;
		}
		findStack(node.next,i+1);
		while (!monotonicStack.isEmpty() && monotonicStack.peek() <= node.val){
			monotonicStack.pop();   // 弹出无用数据
		}
		if (!monotonicStack.isEmpty()){
			ans[i] = monotonicStack.peek(); //栈顶就是第i个节点的下一个更大的元素
		}
		monotonicStack.push(node.val);
	}
}
