package 西湖算法题解___中等题;

public class __92反转链表II__一趟扫描实现 {
	public static void main(String[] args) {

	}

	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
		  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || left == right){
			return head;
		}
		//虚拟结点，标记头结点的位置
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;

		//将prev移动到要反转的起始位置的前面
		for (int i=0;i<left-1;i++){
			prev = prev.next;
			//此时prev指向left的前一个元素
		}
		//current即为初始需要反转的指针
		ListNode current = prev.next;
		ListNode next = current.next;

		//从current开始，需要移动的元素个数为right-left
		for (int i=0;i<right-left;i++){
			current.next = next.next;
			next.next = prev.next;
			prev.next = next;
			next = current.next;
		}
		return dummy.next;
	}
}
