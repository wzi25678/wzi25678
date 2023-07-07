package MyTest01

import MyTest01.createRandom.generateRandomArray

import scala.util.Random

object adjacentElementExchange {

  def swapAdjacentElement(randomArray: Array[Int]):Array[Int] = {
      for(i <- 0 until randomArray.length by (2) ){
        if (i+1 < randomArray.length){
          val temp = randomArray(i)
          randomArray(i) = randomArray(i+1)
          randomArray(i+1) = temp
        }
      }
      randomArray
  }

  def main(args: Array[String]): Unit = {
    val n:Int = Random.nextInt(10)
    val randomArray = generateRandomArray(n)
    println("交换前：")
    println(randomArray.mkString(","))
    println("交换后：")
    val  res = swapAdjacentElement(randomArray)
    println(res.mkString(","))
  }

}
