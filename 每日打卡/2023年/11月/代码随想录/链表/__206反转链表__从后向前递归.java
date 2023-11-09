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
//public class __206反转链表__从后向前递归 {
//	public ListNode reverseList(ListNode head) {
//		//边缘条件判断
//		if (head == null){
//			return null;
//		}
//		if (head.next == null){
//			return head;
//		}
//		//递归调用，翻转第二个节点开始往后的链表
//		ListNode last = reverseList(head.next);
//		//翻转头结点与第二个节点的指向
//		head.next.next = head;  //奇偶互换
//		// 此时的 head 节点为尾节点，next 需要指向 NULL
//		head.next = null;
//		return last;
//	}
//}
