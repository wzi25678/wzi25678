package 西湖算法题解___中等题;

public class __24两两交换链表中的节点__递归解法 {
	public static void main(String[] args) {

	}
	 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null){
			return head;
		}
		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}


}
