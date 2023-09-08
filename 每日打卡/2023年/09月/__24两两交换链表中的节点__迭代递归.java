package 西湖算法题解___中等题;

import java.util.Stack;

public class __24两两交换链表中的节点__迭代递归 {
	/**
	 *
	 * @param args
	 */
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
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		//为null  或   只有单个节点的情况
		if (head == null || head.next == null){
			return head;
		}
		//用stack保存每次迭代的两个节点
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode Post = new ListNode(-1);
		ListNode cur = head;
		//head指向新的p结点，函数结束时返回head.next即可。
		head = Post;
		while (cur != null && cur.next != null){
			//将两个节点放入stack中
			stack.add(cur);
			stack.add(cur.next);
			//当前结点往前走两步
			cur = cur.next.next;
			//从stack中弹出两个节点，然后用p节点指向新弹出的两个节点
			Post.next = stack.pop();
			Post = Post.next;
			Post.next = stack.pop();
			Post = Post.next;
		}
		//注意边界条件，当链表长度为奇数时，cur就不为空
		if (cur != null){
			Post.next = cur;
		}else {
			Post.next = null;
		}
		return head.next;
	}
}
