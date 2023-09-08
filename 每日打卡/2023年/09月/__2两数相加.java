package 西湖算法题解___中等题;

public class __2两数相加 {

	 // Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }


	public static void main(String[] args) {

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		/**
		 * 主要关注两个点：
		 *      1.ListNode对齐，位数少的，补0
		 *      2.考虑进位
		 */
		ListNode pre = new ListNode(0);
		ListNode cur = pre;
		int need_addBit = 0;
		while (l1 != null || l2 != null){
			int x = l1 == null? 0:l1.val;
			int y = l2 == null? 0:l2.val;
			int sum = x+y+need_addBit;

			need_addBit = sum/10;   //判断是否要进位
			sum%=10;    //保留过10的余数
			cur.next = new ListNode(sum);
			cur = cur.next;
			if (l1 != null){
				l1 = l1.next;
			}
			if (l2 != null){
				l2 = l2.next;
			}
			if (need_addBit == 1){
				cur.next = new ListNode(need_addBit);
			}
		}
		return pre.next;


	}//public ListNode addTwoNumbers(ListNode l1, ListNode l2)

}
