package LeetCode中等题;

public class __518零钱兑换II {
    public int change(int amount, int[] coins) {
        /**
         任意单位的零钱转换，只能通过dp动态数组来实现。
         */
        int  dp_change[] = new int[amount+1];
        dp_change[0] = 1;
        for (int coin : coins){
            for (int i=coin;i<=amount;i++){
                dp_change[i] += dp_change[i - coin];
            }
        }
        return dp_change[amount];
    }
}
