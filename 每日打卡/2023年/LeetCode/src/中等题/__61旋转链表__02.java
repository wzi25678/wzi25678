package 中等题;

public class __61旋转链表__02 {

    public class ListNode {
        int val;
       ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode rotateRight(ListNode head, int k){
        if (head == null || k == 0 ||head.next==null){
            return head;
        }
        int n = 0;//用于记录链表的长度
        ListNode tail = null    ;   //用于记录尾节点是哪个节点
        while (tail.next != null){
            tail = tail.next;
            n++;
        }
        k%=n;//看是否迭代会超过一圈，将其控制在一圈之内
        ListNode p = head;
        for (int i=0;i<n-k-1;i++){
            p = p.next;
        }
        tail.next = head;
        head = p.next;
        p.next = null;
        return head;
    }


}
