package MyTest01

object listRemoveZero {

  /**
   *
   * @param head
   * @return
   */
  def removeZero(head: ListNode):ListNode = {
    var current = head
    var prev:ListNode = null
    while (current != null){
      if(current.value == 0){
        if(prev != null){
          prev.next = current.next
        }else{

        }
      }else{
        prev = current
      }
      current = current.next
    }
    head
  }

  class ListNode(var value:Int,var next:ListNode = null)

  /**
   *
   * @param args
   */
  def main(args: Array[String]): Unit = {
    val node1 = new ListNode(0)
    val node2 = new ListNode(1)
    val node3 = new ListNode(2)
    val node4 = new ListNode(3)
    val node5 = new ListNode(0)
    val node6 = new ListNode(0)
    val node7 = new ListNode(4)
    val node8 = new ListNode(5)
    val node9 = new ListNode(6)

    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node5
    node5.next = node6
    node6.next = node7
    node7.next = node8
    node8.next = node9

    val res = removeZero(node1)
    println(res)
  }

}
