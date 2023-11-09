package 日常Java程序测试.代码随想录.链表;

public class __707设计链表__双链表设计 {
	class ListNode{
		int val;
		ListNode next,prev;

		public ListNode() {}

		public ListNode(int val) {
			this.val = val;
		}
	}
	class MyLinkedList {
		int size;
		ListNode head_dummyNode,tailNode;
		//MyLinkedList() 初始化 MyLinkedList 对象。
		public MyLinkedList() {
			this.size = 0;
			this.head_dummyNode = new ListNode(0);
			this.tailNode =  new ListNode(0);
			head_dummyNode.next = tailNode;
			tailNode.prev = head_dummyNode;
		}
		//int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
		public int get(int index) {
			if (index < 0||index >= size){
				return -1;
			}
			ListNode curNode = head_dummyNode;
			if (index >= size / 2){     //找近的地方插入
				curNode = tailNode; //从后往前找对应差额个数
				for (int i=0;i<size - index;i++){
					curNode = curNode.prev;
				}
			}else {
				for (int i=0;i<=index;i++){
					curNode = curNode.next;
				}
			}
			return curNode.val;
		}
		//void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
		public void addAtHead(int val) {
			addAtIndex(0,val);
		}

		//void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
		public void addAtTail(int val) {
			addAtIndex(size,val);
		}

		//void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。
		//如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。
		//如果 index 比长度更大，该节点将 不会插入 到链表中。
		public void addAtIndex(int index, int val) {
			if (index>size){
				return;
			}
			if (index < 0){ //负值也认为插在了首位
				index = 0;
			}
			size++;
			//只要找到插入位置结点的原前驱节点即可。
			ListNode prev = this.head_dummyNode;
			for (int i=0;i<index;i++){
				prev = prev.next;
			}
			//双向链表指定位置插入节点
			ListNode newNode = new ListNode(val);
			newNode.next = prev.next;
			prev.next.prev = newNode;
			newNode.prev = prev;
			prev.next = newNode;
		}

		public void deleteAtIndex(int index) {
			if (index < 0 || index >= size){
				return;
			}
			size--;
			ListNode prev = head_dummyNode;
			for (int i=0;i<index;i++){
				prev = prev.next;
			}
//			prev.next = prev.next.next;
//			prev = prev.next.prev;
			prev.next.next.prev = prev;
			prev.next = prev.next.next;
		}
	}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
