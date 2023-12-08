package 代码随想录.字符串;

public class __28找出字符串中第一个匹配项的下标__前缀表_前缀表_减1 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int[] next = new int[needle.length()];  //构造数组，进行模式匹配
        getNext(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j>=0 && haystack.charAt(i)!= needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    /**
     *
     * @param next
     * @param string
     */
    private void getNext(int[] next, String string) {
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < string.length(); i++) {
            while (j >= 0 && string.charAt(i)!= string.charAt(j + 1)) {
                j = next[j];
            }
            if (string.charAt(i) == string.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }
}
