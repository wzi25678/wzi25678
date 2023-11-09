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
//public class __19删除链表的倒数第N个结点 {
//	/**
//	 *它要删除倒数第n个。
//	 *
//	 * @param head
//	 * @param n
//	 * @return
//	 */
//	public ListNode removeNthFromEnd(ListNode head, int n) {
//		ListNode dummyNode = new ListNode(0);
//		dummyNode.next = head;
//
//		ListNode fastIndex = dummyNode;
//		ListNode slowIndex = dummyNode;
//
//		//只要快慢指针相差n个结点即可。
//		for (int i=0;i<n;i++){
//			fastIndex = fastIndex.next;
//		}
//
//		while (fastIndex.next != null){
//			fastIndex = fastIndex.next;
//			slowIndex = slowIndex.next;
//		}
//
//		//此时，slowIndex的位置就是待删除元素的前一个位置。
//		slowIndex.next = slowIndex.next.next;
//		return dummyNode.next;
//	}
//
//}
