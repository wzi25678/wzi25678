package MyTest01

import MyTest01.createRandom.generateRandomArray

object returnMaxAndMin {

  def returnMaxAndMinPar(array: Array[Int]):(Int,Int) = {
    val maxValue = array.max
    val minValue = array.min
    (maxValue,minValue)
  }

  def main(args: Array[String]): Unit = {
    val array: Array[Int] = generateRandomArray(10);
    println("生成的随机数组为：")
    println(array.mkString(","))
    val res = returnMaxAndMinPar(array)
    println(res)
  }

}
