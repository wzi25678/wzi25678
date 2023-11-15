package 代码随想录.字符串;

public class __541反转字符串II {
    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
     * -如果剩余字符少于 k 个，则将剩余字符全部反转。
     * -如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * 题解：
     * --这道题的本质上，其实就是解决两个问题
     * 1.区分好不同的位置
     * 2.指定位置进行字符串翻转
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        char [] chars = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {    //每2k个字符转一次
            //如果剩余字符少于 k 个，则将剩余字符全部反转。
            //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
                                    //不管是不是有2k个字符，只要多余字符少于等于k个，就反转前k个
            myReverse(chars, i, Math.min(i + k, n) -1); //因为下标从0开始
        }
        return new String(chars);
    }

    /**
     *
     * @param chars
     * @param left
     * @param right
     */
    private void myReverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
