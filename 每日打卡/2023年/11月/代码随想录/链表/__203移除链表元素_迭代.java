package 日常Java程序测试.代码随想录.链表;

public class __203移除链表元素_迭代 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummyHead = new ListNode(0);   //从头遍历找不到头的替换位置
		dummyHead.next = head;  //哨位结点
		//不另外构造一个temp的话，虽然遍历了一遍链表，但dummyHead就会无法把ListNode串联起来。
		ListNode temp = dummyHead;
		while (temp.next != null){
			if (temp.next.val == val){
				temp.next = temp.next.next;
			}else {
				temp = temp.next;
			}
		}
		return dummyHead.next;
	}
//	public ListNode removeElements(ListNode head, int val) {
//		ListNode dummyHead = new ListNode(0);   //从头遍历找不到头的替换位置
//		dummyHead.next = head;  //哨位结点
//		//ListNode temp = dummyHead;
//		while (dummyHead.next != null){
//			if (dummyHead.next.val == val){
//				dummyHead.next = dummyHead.next.next;
//			}else {
//				dummyHead = dummyHead.next;
//			}
//		}
//		return dummyHead.next;
//	}
}
