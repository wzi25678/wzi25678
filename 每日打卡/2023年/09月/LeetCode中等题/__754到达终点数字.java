package LeetCode中等题;

public class __754到达终点数字 {
    public int reachNumber(int target) {
        /*
        第 i 次移动（从  i == 1 开始，到 i == numMoves ），在选择的方向上走 i 步。
            数学规律？？？dp推进。
            每次只能走固定的累积步骤，然后其实可能不区分正负。
         */
                /*
        到达target，则至少有s需要考虑。
        需要考虑的就是凑数，，，


        */
        target = Math.abs(target);
        int k = 0;
        while (target > 0){
            //target为当前目前走向的剩余值，k为当前走的步数
            k++;
            target-=k;
        }
        /*
        //此时出来，无非两种情况：
            1.target为0，刚好是1,2,3,4,5，，，，k这么多步的累计和，并不需要往回走
            2. <0,  即需要往回走的情况
         */
        //  判断是不是偶数？
        return target % 2 == 0? k:k+1+k%2;
    }
}
