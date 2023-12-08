package 代码随想录.链表;

public class _142环形链表II {
    //找出链表成环位置，其中起始位置设置为0
    /**
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null){
            //构成成环条件
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode){  //交汇了，说明成环
                ListNode index1 = fastNode;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2){
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
