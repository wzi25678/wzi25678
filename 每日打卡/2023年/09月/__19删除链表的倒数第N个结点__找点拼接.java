package 西湖算法题解___中等题;

public class __19删除链表的倒数第N个结点__找点拼接 {
	public static void main(String[] args) {

	}
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) {
			this.val = val; this.next = next;
		}
	}

	public ListNode removeNthFromEnd(ListNode head, int n){
		//链表的头结点是head
		ListNode pre = new ListNode(0,head);
		pre.next = head;
		ListNode  node = pre;
		ListNode end = pre;
		//找到需要删除的位置
		while ( n != 0){
			node = node.next;
			n--;
		}
		while (node.next != null){
			node = node.next;
			end =  end.next;
		}
		end.next = end.next.next;
		return pre.next;
	}//public ListNode removeNthFromEnd

}
