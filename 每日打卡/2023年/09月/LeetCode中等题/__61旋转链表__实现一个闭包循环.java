package LeetCode中等题;

public class __61旋转链表__实现一个闭包循环 {
    public static void main(String[] args) {

    }

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
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        //K代表右移多少位
        if(k==0 || head == null || head.next == null){
            return head;
        }
        int n = 1;
        ListNode iter = head;
        while (iter.next != null){
            iter = iter.next;
            n++;
        }
        //迭代到头了就出来，同时记录了跌代了多少次，那么   n就代表整个链表的长度
        int add = n- k%n;   //看是否迭代会超过一圈，将其控制在一圈之内
        if (add == n){
            return head;
        }
        iter.next = head;
        while (add-- > 0){
            iter = iter.next;       //如果能走完一圈则坚持走完
        }
        ListNode res = iter.next;
        iter.next = null;
        return res;
    }


}
