package MyTest01

object priceDiscounts {
  def main(args: Array[String]): Unit = {
    val discountsEquipment = Map(
      "sword" -> 100,
      "shield" -> 200
    )

    val discountedPrice = discountsEquipment.mapValues( _ * 0.9)

    println(discountedPrice.mkString(","))
  }
}
