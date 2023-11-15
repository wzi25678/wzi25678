package 代码随想录.字符串;

public class __344反转字符串01 {
    /**
     *
     *
     * @param s
     */
    public void reverseString(char[] s) {
        //不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
