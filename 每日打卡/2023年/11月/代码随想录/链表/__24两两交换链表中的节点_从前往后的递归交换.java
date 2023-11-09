//package 日常Java程序测试.代码随想录.链表;
//
//class ListNode {
//	int val;
//	ListNode next;
//	ListNode() {}
//	ListNode(int val) { this.val = val; }
//	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
//
//public class __24两两交换链表中的节点_从前往后的递归交换 {
//	public ListNode swapPairs(ListNode head) {
//		//和之前的206题类似，想要操作链表，那么无非是从前往后的递归交换，
//		//或者从后往前的跳节点交换
//		if (head == null || head.next == null){
//			return head;
//		}
//		ListNode nextNode = head.next;
//		ListNode newNode = swapPairs(nextNode.next);
//		nextNode.next = head;
//		head.next = newNode;
//		return nextNode;
//	}
//}
