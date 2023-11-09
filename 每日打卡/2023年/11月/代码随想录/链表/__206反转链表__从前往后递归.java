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
//public class __206反转链表__从前往后递归 {
//	public ListNode reverseList(ListNode head) {
//		return myReverse(null,head);
//	}
//
//	/**
//	 *
//	 * @param prev
//	 * @param curHead
//	 * @return
//	 */
//	private ListNode myReverse(ListNode prev, ListNode curHead) {
//		if (curHead == null){
//			return prev;
//		}
//		ListNode temp = null;
//		temp = curHead.next;    //先保存下一个节点
//		curHead.next = prev;    //反转
//		//更新prev,curHead位置
//		//  prev = cur;
//		//  cur = temp;
//		return myReverse(curHead,temp);
//	}
//}
