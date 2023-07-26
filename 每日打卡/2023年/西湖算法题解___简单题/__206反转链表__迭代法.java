package 西湖算法题解___简单题;

public class __206反转链表__迭代法 {
	public static void main(String[] args) {

	}

	//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

	  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode cur =  head;
		while (cur != null){
			ListNode next = cur.next;
			//cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

}
