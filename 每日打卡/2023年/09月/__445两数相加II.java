package 西湖算法题解___中等题;

import java.util.ArrayDeque;
import java.util.Deque;

public class __445两数相加II {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		//数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
		//就是两个数字链表，对应下来做加法

		//输入：l1 = [7,2,4,3], l2 = [5,6,4]
		//输出：[7,8,0,7]
		//用栈去实现“链式”的加法
		Deque<Integer> stack1 = new ArrayDeque<Integer>();
		Deque<Integer> stack2 = new ArrayDeque<Integer>();
		//l1、l2把数值都压进去
		while (l1 != null){
			stack1.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null){
			stack2.push(l2.val);
			l2 = l2.next;
		}
		int promotion = 0;      //进位
		ListNode res = null;
		while (!stack1.isEmpty() || !stack2.isEmpty() || promotion != 0){
			int a = stack1.isEmpty() ? 0 :stack1.pop();
			int b = stack2.isEmpty() ? 0 :stack2.pop();
			int cur = a+b+promotion;
			promotion = cur/10;     //继续保存进位
			cur %= 10;  //当前位的剩余值
			ListNode curNode = new ListNode(cur);
			/**
			 * 把res赋值给next，在把cur赋值给res；
			 */
			curNode.next = res;
			res = curNode;

		}
		return res;
	}
}

