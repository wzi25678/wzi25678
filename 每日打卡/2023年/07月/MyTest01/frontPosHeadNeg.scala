package MyTest01

import scala.io.StdIn
import scala.util.Random


object frontPosHeadNeg {

  def generateRandomPosAndNegArray(x1: Int, x2: Int, x3: Int):Array[Int] = {
    val random = new Random()
    val array = new Array[Int](x3)
    for( i <- 0 until(x3)){
      array(i) = (random.nextInt(x2-x1)+x1)
    }
    array
  }

  def main(args: Array[String]): Unit = {
    val x1:Int = StdIn.readInt();
    val x2:Int = StdIn.readInt();
    val x3:Int = StdIn.readInt();
    //随机生成一个[-100~200)的大小为10个的数组
    val array = generateRandomPosAndNegArray(x1,x2,x3)
    println(array.mkString(","))
  }

}
