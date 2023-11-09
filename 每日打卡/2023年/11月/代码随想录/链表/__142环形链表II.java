package 日常Java程序测试.代码随想录.链表;

import java.util.List;

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class __142环形链表II {
	/**
	 * 一个链表从某一个结点开始，可能会出现直到结尾出现成环现象，问成环的起始位置是哪个？NULL
	 *
	 * 1.如果有环的存在，设置两个fast，slow快慢指针，那么它们一定会相遇。
	 *
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast){      //有环
				ListNode index1 = fast;
				ListNode index2 = head;
				//两个指针，从头结点和相遇节点，各走一步，直到相遇，相遇点即为环入口。
				while (index1 != index2){
					index1 = index1.next;
					index2 = index2.next;
				}
				return index1;
			}
		}
		return null;
	}
}
