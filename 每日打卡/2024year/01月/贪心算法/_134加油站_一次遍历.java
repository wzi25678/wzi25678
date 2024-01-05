package 代码随想录.贪心算法;

public class _134加油站_一次遍历 {
    /**
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++){
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0){
                index = (i+1)%gas.length;
                curSum = 0;
            }
        }
        if (totalSum < 0){
            return  -1;
        }
        return index;
    }
}
