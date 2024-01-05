package 代码随想录.贪心算法;

public class _134加油站 {
    /**
     * 题目很明确，直接准点遍历就行
     * 因为每次都是走到下一个节点，而已；
     * 所以只要逐点去尝试作为起始点，然后进行剩余油量和下一站所花费油量的相减即可
     * 然后用 % 就可以模拟出一个环路。
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        1 <= n <= 10^5
        0 <= gas[i], cost[i] <= 10^4
        双重for在穷举时，会产生超时现象。
        就需要考虑剪枝优化。
         */
        int n = gas.length;
        int i = 0;
        while (i < n){  //逐点作为起始点，去遍历尝试
            int sumOfGas = 0,sumOfCost = 0;
            int count = 0;
            while (count < n){
                int j = (i+count) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfGas < sumOfCost){
                    break;
                }
                count++;
            }
            if (count ==  n){
                return i;
            }else {     //TODO 【优化】： 跳过部分区间
                i = i+count+1;      //检测到在count处，走不通，那必然是count处才遇到走不通的情况，且从[i]到[count-1]的累积均不能对其有所缓解
            }
        }
        return -1;
    }
}
