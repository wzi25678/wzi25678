package 西湖算法题解___中等题;

public class __19删除链表的倒数第N个结点 {
	public static void main(String[] args) {

	}

	/**
	 *
	 */
    public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

	/**
	 *
	 * @param head
	 * @param n
	 * @return
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode node_dummy = new ListNode(0,head);
		int length = getLength(head);
		ListNode cur = node_dummy;
		for (int i=1;i<length-n+1;i++){
			cur = cur.next;
		}
		cur.next = cur.next.next;
		ListNode res = node_dummy.next;
		return res;
	}

	private int getLength(ListNode head) {
		int length = 0;
		while (head != null){
			length++;
			head = head.next;
		}
		return length;
	}
}
