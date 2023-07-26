package 西湖算法题解___简单题;

public class _21_合并两个有序链表 {

	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
	public static void main(String[] args) {

	}

	//从小到大排序
	private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode new_List = new ListNode();
		ListNode pre = new_List;    //用一个pre来记录new_List的首元素

		while (list1 != null && list2!=null){
			if (list1.val <=list2.val){
				pre.next = list1;
				list1 = list1.next;
				pre =pre.next;
			}else {
				//插入list2
				pre.next = list2;
				list2 = list2.next;
				pre =pre.next;
			}
		}
		//这是肯定有一个为空，另一个为剩余有序
		if (list1 == null){
			pre.next = list2;
		}else {
			pre.next = list1;
		}

		return new_List.next;

	}
}
