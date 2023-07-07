package MyTest01

import scala.util.Random

object createRandom {

  def generateRandomArray(n: Int):Array[Int] = {
      val random = new Random()
      val array = new Array[Int](n)
      for(i <- 0 until  n){
        array(i) = random.nextInt(101)
      }
      array
  }

  def main(args: Array[String]): Unit = {
      val n: Int = 100   //想生成的数组长度
      val a = generateRandomArray(n); //创建一个a，去接收生成的东西
      println(a.mkString(","))
  }

}
