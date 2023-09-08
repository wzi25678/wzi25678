package 西湖算法题解___中等题;

public class __147对链表进行插入排序 {

	public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

	public ListNode insertionSortList(ListNode head) {
		//
		ListNode  dummy=  new ListNode(0),pre;      //将生成的dummy结点，用pre去指向。
		dummy.next = head;

		while (head != null && head.next != null){
			//从头结点开始，按插入排序比大小排列
			if (head.val <= head.next.val){
				//满足条件，不用管，向后移
				head = head.next;
				continue;
			}else {
				//没有比自己后面的大
				pre = dummy;
				while (pre.next.val < head.next.val){
					//上一个while循环，只保证了当前head比head.next小，却没有关注，整个范围内的元素大小关系
					pre = pre.next;
				}
				/*
				四部实现链表交换：
				比常规的temp、A、B 三步骤，多了一步，就是确保原本的指针next指向关系，要修改一下。
				 */
				ListNode curr = head.next;
				head.next = curr.next;
				curr.next = pre.next;
				pre.next =  curr;
			}
		}
		return  dummy.next;
	}




}
