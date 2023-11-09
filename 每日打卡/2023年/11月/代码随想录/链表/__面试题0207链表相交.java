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
//public class __面试题0207链表相交 {
//	int i = 1;
//	public static void main(String[] args) {
//		int[] values = {4, 1, 8, 4, 5};
//		int[] valuess = {5,0,1,8,4,5};
//		ListNode headA = createLinkedList(values);
//		printLinkedList(headA);
//		ListNode headB = createLinkedList(valuess);
//		printLinkedList(headB);
//		ListNode newNode = getIntersectionNode(headA,headB);
//		printLinkedList(newNode);
//
//	}
//
//	// 打印链表
//	private static void printLinkedList(ListNode head) {
//		ListNode current = head;
//		while (current != null) {
//			System.out.print(current.val + " ");
//			current = current.next;
//		}
//
//		System.out.println();
//	}
//
//	private static ListNode createLinkedList(int[] values) {
//		if (values == null || values.length == 0) {
//			return null;
//		}
//
//		ListNode dummy = new ListNode(0);
//		ListNode current = dummy;
//
//		for (int val : values) {
//			current.next = new ListNode(val);
//			current = current.next;
//		}
//		return dummy.next;
//	}
//
//	/**
//	 * 这道题目有点傻逼，需要深入理解一下
//	 * 你可以认为初始有三个链表  a  b   c
//	 * 然后ac构成一个链表A，，，bc构成一个链表B
//	 *
//	 * 然后你就要通过已知的链表A和链表B去，找出链表c的初始节点值
//	 *
//	 * @param headA
//	 * @param headB
//	 * @return
//	 */
//
//	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//		ListNode curNodeA = headA;
//		ListNode curNodeB = headB;
//
//		int lenA = 0,lenB = 0;
//		while (curNodeA != null){   //求链表A的长度
//			lenA++;
//			curNodeA = curNodeA.next;
//		}
//		while (curNodeB != null){   //求链表B的长度
//			lenB++;
//			curNodeB = curNodeB.next;
//		}
//		//统计完长度后，回到头部
//		curNodeA = headA;
//		curNodeB = headB;
//		//让curA为最长链表的头，lenA为其长度
//		if (lenB > lenA){   //此处认为B比A长
//			int tempLen = lenA;
//			lenA = lenB;
//			lenB = tempLen;
//			ListNode tempNode = curNodeA;
//			curNodeA = curNodeB;
//			curNodeB = tempNode;
//		}
//		//实现A长B短，如果相反，则调整记录长度，调整哨位结点的记录
//		int gap = lenA - lenB;
//		while (gap-- > 0){
//			curNodeA = curNodeA.next;
//		}
//		//对剩余相同长度部分，遍历从哪个开始相同
//		while (curNodeA!=null){
//			if (curNodeA == curNodeB){
//				System.out.println("2");
//				return curNodeA;
//			}
//			curNodeA = curNodeA.next;
//			curNodeB = curNodeB.next;
//		}
//		System.out.println("1");
//		return null;
//	}
//}
