package sanke赛克;
/*


 */

import java.util.Arrays;
import java.util.Scanner;

public class Main02结构体 {
    private int n,k;

    private class Flower{
        private int losstime;
        private int gold;

        private int ifTake;

        public Flower(int losstime, int gold) {
            this.losstime = losstime;
            this.gold = gold;
        }

        public int getLosstime() {
            return losstime;
        }

        public void setLosstime(int losstime) {
            this.losstime = losstime;
        }

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getIfTake() {
            return ifTake;
        }

        public void setIfTake(int ifTake) {
            this.ifTake = ifTake;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int time = n;
        int k = scanner.nextInt();
        Flower[] flowers  = new Flower[n];
        int [ ] curgold = new int[n];
        for (int i=0;i<n;i++){
            flowers[i].losstime = scanner.nextInt();
        }
        for (int i=0;i<n;i++){
            flowers[i].gold = scanner.nextInt();
        }

        int cur_take_多少 = 0;
        for (int i=0;i<time;i++){
            if (cur_take_多少 < k) {
                //说明此时可以拿,此时从n个里面挑一个可以拿的
                int max = Integer.MIN_VALUE;
                int index = 0;
                for (int j=0;j<n;j++){
                    if (flowers[i].losstime >=0 && flowers[i].ifTake == 0){
                        //说明没有被拿，并且可以拿
                        if (flowers[i].gold >= max){
                            max = flowers[i].gold;
                            index = i;
                        }
                    }
                }//for (int j=0;j<n;j++)

        //java设计一个算法，判断所有自然数能否被指定的几个数的任意倍数的加减求和，得出来,如果能，则输出你用的的是具体哪几个数。
            }
        }
    }
}
