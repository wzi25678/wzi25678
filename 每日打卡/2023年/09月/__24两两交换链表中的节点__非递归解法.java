package 西湖算法题解___中等题;

public class __24两两交换链表中的节点__非递归解法 {
	public static void main(String[] args) {

	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val,ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode swapPairs(ListNode head){
		ListNode pre = new ListNode(0);
		pre.next = head;
		ListNode temp = pre;
		while (temp.next != null && temp.next.next!=null){
			ListNode start = temp.next;
			ListNode end = temp.next.next;
			temp.next = end;
			start.next =end.next;
			end.next = start;
			temp = start;
		}
		return pre.next;
	}

}
