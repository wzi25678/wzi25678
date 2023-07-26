//package 西湖算法题解;
//
//public class __206反转链表__递归法 {
//	public static void main(String[] args) {
//
//	}
//
//
//	//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
//	public class ListNode {
//		int val;
//		__206反转链表__迭代法.ListNode next;
//		ListNode() {}
//		ListNode(int val) { this.val = val; }
//		ListNode(int val, __206反转链表__迭代法.ListNode next) { this.val = val; this.next = next; }
//	}
//
//	public ListNode reverseList(ListNode head){
//		ListNode prev = null;
//		ListNode cur = head;
//
//		if (head == null || cur.next ==null){
//			return cur;
//		}
//		ListNode newHead = reverseList(cur.next);
//		cur.next.next = cur;
//		cur.next = null;
//		return newHead;
//
//	}
//}
