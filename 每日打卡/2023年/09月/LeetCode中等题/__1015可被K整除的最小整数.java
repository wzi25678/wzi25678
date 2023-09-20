package LeetCode中等题;

import java.util.HashSet;
import java.util.Set;

public class __1015可被K整除的最小整数 {
    /**
     全部由1构成的数组，然后要求能整除k
     然后求得是最小的 长度。

     * @param k
     * @return
     */
    public int smallestRepunitDivByK(int k) {
        int reSid = 1%k ,len = 1;   //reSid为余数，len为数字长度，初始值为1
        Set<Integer> set = new HashSet<Integer>();  //创建一个无序集合，用于存储余数
        set.add(reSid); //插入余数1
        while (reSid != 0){
            reSid = (reSid * 10 + 1) % k;
            len++;
            if (set.contains(reSid)){
                return -1;
            }
            set.add(reSid);
        }
        return len;
    }
}
