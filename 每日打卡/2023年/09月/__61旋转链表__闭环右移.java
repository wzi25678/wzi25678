package 西湖算法题解___中等题;

public class __61旋转链表__闭环右移 {
	public static void main(String[] args) {

	}

	/**
	 *       int val;
	 *       ListNode next;
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
	 * @param k
	 * @return
	 */
	public ListNode rotateRight(ListNode head, int k) {
		if (k ==0 || head == null || head.next == null){
			return head;
		}
		int n=1;
		ListNode iterator = head;
		while (iterator.next != null){
			iterator = iterator.next;
			n++;
		}
		int add = n - k % n;
		if (add == n){
			return head;
		}
		iterator.next = head;
		while (add-- > 0){
			iterator = iterator.next;
		}
		ListNode res = iterator.next;
		iterator.next = null;
		return res;
	}
}
