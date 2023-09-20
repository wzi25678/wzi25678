package LeetCode中等题;

public class __1015可被K整除的最小整数__优化 {
    /**


     * @param k
     * @return
     */
    public int smallestRepunitDivByK(int k) {
        //若 k 能被 2 或 5 整除，则无解，返回 -1
        if (k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        //初始化余数为1，表示一个数得最低位是1
        int reSid = 1 % k,len = 1;
        //若余数不为0，继续迭代
        while (reSid != 0){
            //计算下一个数的余数，下一个数在当前余数后加一个 1
            reSid = (reSid * 10 + 1) % k;
            len++;
        }
        //返回数字 1 的最小重复次数
        return len;
    }
}
