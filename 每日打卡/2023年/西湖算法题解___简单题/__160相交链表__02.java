package 西湖算法题解___简单题;

public class __160相交链表__02 {
	public static void main(String[] args) {

	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		//先判断，pass掉基本不可能的情况。
		if (headA == null || headB == null){
			return null;
		}
		ListNode preA = headA;
		ListNode preB = headB;
		while (preA != preB){   //不等于则一起继续探索,当然一起探索可能会遇到为空的情况
			if (preA == null){//如果等于null
				 preA = headB;
			}else {//如果不等于null，则继续
				preA = preA.next;
			}
			//---------------------------------------------------
			if (preB == null){//如果等于null
				preB = headA;
			}else {//如果不等于null，则继续
				preB = preB.next;
			}
		}
		return preA;
	}
}
