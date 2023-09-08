package 西湖算法题解___中等题;

public class __86分隔链表 {
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
	 * @param x
	 * @return
	 */
	public ListNode partition(ListNode head, int x) {
		ListNode first =  new ListNode();
		ListNode firstHead = first;
		ListNode second =  new ListNode();
		ListNode secondHead = second;
		//int i=1;
		while (head.next != null){
			if (head.val >= x){
				first.next = head;
				first=  first.next;
			}else{
				second.next = head;
				second  = second.next;
			}
			//每判断一个，head就要移一个位置
			head = head.next;
		}
		//first.next = null;
		second.next  = firstHead.next;
		return secondHead.next;
	}
}
