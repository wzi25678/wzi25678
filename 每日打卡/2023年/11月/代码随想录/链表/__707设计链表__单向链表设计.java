package 日常Java程序测试.代码随想录.链表;

public class __707设计链表__单向链表设计 {
	class MyLinkedList {
		//我们首先需要自己定义属性出来
		int val;
		MyLinkedList next;
		int size;   //记录链表大小

		//MyLinkedList() 初始化 MyLinkedList 对象。
		public MyLinkedList() {
			size = 0;
			val = 0;
			next = new MyLinkedList(0);
		}

		public MyLinkedList(int val) {
			this.val = val;
		}

		//int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
		public int get(int index) {
			if (index < 0||index >= size){
				return -1;
			}
			MyLinkedList curNode = next;
			for (int i=0;i<=index;i++){
				curNode = curNode.next;
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
			if (index > size){
				return;
			}
			if (index < 0){ //负值也认为插在了首位
				index = 0;
			}
			size++;
			MyLinkedList pred = next;
			for (int i=0;i<index;i++){
				pred = pred.next;   //得有哨位结点
			}
			MyLinkedList toAdd = new MyLinkedList(val);
			toAdd.next = pred.next;
			pred.next = toAdd;
		}

		//void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
		public void deleteAtIndex(int index) {
			if (index < 0 || index >= size){
				return;
			}
			size--;
			if (index < 0){ //负值认为在了首位
				index = 0;
			}
			if (index == 0){
				next = next.next;
				return;
			}
			MyLinkedList pred = next;
			for (int i=0;i<index;i++){
				pred = pred.next;
			}
			pred.next = pred.next.next;
		}
	}
}
