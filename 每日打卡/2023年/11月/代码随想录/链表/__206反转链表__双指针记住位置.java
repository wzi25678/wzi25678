//package 日常Java程序测试.代码随想录.链表;
//
//class ListNode {
//	int val;
//	ListNode next;
//
//	ListNode() {
//	}
//
//	ListNode(int val) {
//		this.val = val;
//	}
//
//	ListNode(int val, ListNode next) {
//		this.val = val;
//		this.next = next;
//	}
//}
//
//public class __206反转链表__双指针记住位置 {
//	public ListNode reverseList(ListNode head) {
//		ListNode prev = null;
//		ListNode cur = head;
//		ListNode temp = null;
//		while (cur != null){
//			temp = cur.next;
//			cur.next = prev;
//			prev = cur;
//			cur = temp;
//		}
//		return prev;
//	}
//}
