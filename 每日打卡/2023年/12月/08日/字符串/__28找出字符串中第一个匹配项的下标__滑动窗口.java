package 代码随想录.字符串;

public class __28找出字符串中第一个匹配项的下标__滑动窗口 {
    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
     * 如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        //在字符串haystack中找出needle字符串的第一个匹配项的下标
        //模拟匹配算法？
        /**
         * 基于窗口滑动的算法
         * <p>
         * 时间复杂度：O(m*n)
         * 空间复杂度：O(1)
         * 注：n为haystack的长度，m为needle的长度
         */
        int m = needle.length();
        if (m == 0) {
            return 0;   //空串是任意字符串的0匹配子串
        }
        int n = haystack.length();
        if (n<m){   //如果haystack的长度小于needle的长度，直接返回-1
            return -1;
        }
        int i = 0;
        int j = 0;
        //最多找到这个位置为止
        while (i<n-m+1){
            //找出第一个匹配的位置
            while (i<n-m+1 && haystack.charAt(i) != needle.charAt(j)){
                i++;
            }
            if (i>=n-m+1){   //检查i是否还合理
                return -1;
            }
            //遍历后续字符，判断是否相等
            while (i<n && j<m && haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;    //j指向下一个匹配的字符
            }
            if (j==m){  //说明完全匹配
                return i-j;
            }else{
                //并不能完全匹配
                i-=j-1; //跳过当前j-1get匹配的字符   //因为这道题没有说明时间限制，因此这里采用的是逐个遍历
                j = 0;
            }
        }
        return -1;
    }
}
