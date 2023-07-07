package MyTest01

object listRemoveZero01 {
  def main(args: Array[String]): Unit = {
    val list = List(0, 1, 2, 3, 0, 0, 5, 4, 6)
    val listFilterZero = list.filterNot(_ == 0)
    println(listFilterZero)
  }
}
