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
//public class __24两两交换链表中的节点_从后往前的跳节点交换 {
//	/**
//	 *
//	 * @param head
//	 * @return
//	 */
//	public ListNode swapPairs(ListNode head){
//		ListNode dummyHead = new ListNode(0);
//		dummyHead.next = head;
//		ListNode curNode = dummyHead;
//		ListNode temp;
//		ListNode firstNode;
//		ListNode secondNode;
//		while (curNode.next != null && curNode.next.next != null){
//			temp = curNode.next.next.next;
//			firstNode = curNode.next;
//			secondNode = curNode.next.next;
//			curNode.next = secondNode;  //步骤一
//			secondNode.next = firstNode;    ////步骤二
//			firstNode.next = temp;  ////步骤三
//			curNode = firstNode;    //cur移动，准备下一轮的交换
//		}
//		return dummyHead.next;
//	}
//}
