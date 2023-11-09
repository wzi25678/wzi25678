package 日常Java程序测试.代码随想录.链表;

//class ListNode{
//	int val;
//	ListNode next;
//	ListNode() {}
//	ListNode(int val) { this.val = val; }
//	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}

public class __203移除链表元素_递归遍历链表 {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null){
			return head;
		}
		head.next = removeElements(head.next,val);  //尾部遍历
		return head.val == val? head.next :head;
	}
}
