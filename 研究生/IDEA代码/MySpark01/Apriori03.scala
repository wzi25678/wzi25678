import scala.collection.mutable
import scala.collection.mutable.Set

object Apriori03 {

  // 生成候选项集的所有非空子集
  def powerset(s: mutable.Set[Int]): mutable.Set[mutable.Set[Int]] =
    s.subsets.map(subset => mutable.Set(subset.toSeq: _*)).filter(_.nonEmpty).to[mutable.Set]

  // 计算支持度
  def calculateSupport(itemset: Set[Int], transactions: Array[Set[Int]]): Double =
    transactions.count(transaction => itemset.subsetOf(transaction)).toDouble / transactions.length

  // Apriori算法
  def apriori(transactions: Array[Set[Int]], minSupport: Double, minConfidence: Double): (Set[Set[Int]], Array[(Set[Int], Set[Int], Double)]) = {
    // 初始化频繁项集和关联规则列表
    var frequentItemsets = Set.empty[Set[Int]]
    var associationRules = Array.empty[(Set[Int], Set[Int], Double)]

    // 找出单项频繁项集
    val singletons = transactions.flatten.map(item => Set(item)).toSet
    val frequentSingletons = singletons.filter(itemset => calculateSupport(itemset, transactions) >= minSupport)
    frequentItemsets ++= frequentSingletons

    // 迭代找出所有其他频繁项集
    var prevFrequentItemsets = frequentSingletons
    while (prevFrequentItemsets.nonEmpty) {
      print("哎哟！！！")
      // 生成新的候选项集
      val candidates = for {
        itemset1 <- prevFrequentItemsets
        itemset2 <- prevFrequentItemsets
        if itemset1.size + itemset2.size == itemset1.union(itemset2).size + 1
      } yield itemset1.union(itemset2)

      // 计算支持度并筛选
      val newFrequentItemsets = candidates.filter(itemset => calculateSupport(itemset, transactions) >= minSupport)
      frequentItemsets ++= newFrequentItemsets

      // 生成关联规则
      for {
        itemset <- newFrequentItemsets
        subset <- powerset(itemset)
        diff = itemset.diff(subset)
        if diff.nonEmpty
      } {
        val confidence = calculateSupport(itemset, transactions) / calculateSupport(subset, transactions)
        if (confidence >= minConfidence) {
          associationRules :+= (subset, diff, confidence)
        }
      }

      prevFrequentItemsets = newFrequentItemsets
    }

    (frequentItemsets, associationRules)
  }

  def main(args: Array[String]): Unit = {
    // 假设有如下的事务数据集
    val transactions = Array(
      Set(1, 2, 3),
      Set(1, 2, 4),
      Set(1, 3, 4),
      Set(2, 3, 4),
      Set(1, 2),
      Set(1, 3),
      Set(2, 3),
      Set(3, 4)
    )
    print("干嘛啊！！！")
    val minSupport = 0.2
    val minConfidence = 0.5
    val (frequentItemsets, associationRules) = apriori(transactions, minSupport, minConfidence)
    print("干嘛啊！！！")
    // 打印结果
    println("频繁项集： " + frequentItemsets)
    println("关联规则： " + associationRules)
  }
}
