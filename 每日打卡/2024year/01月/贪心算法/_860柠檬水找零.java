package 代码随想录.贪心算法;

import java.util.Arrays;

public class _860柠檬水找零 {
    /**
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        // 可以构造一个2个大小的数组，分别用于表示你的5元，10元的数量
        int count [] = new int [2];
//        Arrays.sort(bills);
        for (int i = 0;i< bills.length;i++) {
            if (bills[i] == 5){
                count[0]++;
            } else if (bills[i] == 10) {
                if (count[0] <= 0){
                    return false;
                }
                count[0]--;
                count[1]++;
            }else { //支付的是20块
                if (count[1] > 0){
                    count[1]--;
                    if (count[0] <= 0){
                        return false;
                    }
                    count[0]--;
                }else {
                    if (count[0] <= 2){
                        return false;
                    }
                    count[0] -=3;
                }
            }
        }
        return true;
    }
}
