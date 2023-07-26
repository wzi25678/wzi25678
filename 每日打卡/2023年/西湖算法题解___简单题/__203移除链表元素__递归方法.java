package 西湖算法题解___简单题;

/**
 * 链表的定义具有递归的性质，因此链表题目常可以用递归的方法求解。这道题要求删除链表中所有节点值等于特定值的节点，可以用递归实现。
 * 
 */
public class __203移除链表元素__递归方法 {
	public static void main(String[] args) {

	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null){
			return null;
		}

		ListNode node = head.next;
		removeElements(node,val);
		if (head.val == val){
			//如果等于，那么当前的node结点则得不到返回
			return head.next;
		}else {
			return head;
		}
	}

	public class ListNode {
		int val;    //val表示当前node结点的值
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
}

