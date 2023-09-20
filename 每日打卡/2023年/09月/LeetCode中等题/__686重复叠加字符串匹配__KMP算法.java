package LeetCode中等题;

public class __686重复叠加字符串匹配__KMP算法 {
    public int repeatedStringMatch(String a, String b) {
        int aLength = a.length(),bLength = b.length();
        int index = strStr(a,b);
        if (index == -1){
            return -1;
        }
        if (aLength - index >= bLength){
            return 1;
        }
        return (bLength + index - aLength -1)/aLength +2;
    }

    /**
     *
     * @param hayStack
     * @param needle
     * @return
     */
    private int strStr(String hayStack, String needle) {
        int hayStackLength=hayStack.length(),needleLength = needle.length();
        if (needleLength == 0){
            return 0;
        }
        int [] pi =new int[needleLength];
        for (int i=1,j=0;i<needleLength;i++){
            while (j>0 && needle.charAt(i) != needle.charAt(j)){
                j = pi[j - 1];
            }
            if (needle.charAt(i) ==  needle.charAt(j)){
                j++;
            }
            pi[i] = j;
        }
        for (int i=0,j=0;i-j < hayStackLength;i++){  // b 开始匹配的位置是否超过第一个叠加的 a
            while (j>0 && hayStack.charAt(i % hayStackLength) != needle.charAt(j)){
                j = pi[j-1];
            }
            if (hayStack.charAt(i % hayStackLength) == needle.charAt(j)){
                j++;
            }
            if (j== needleLength){
                return i-needleLength+1;
            }
        }
        return -1;
    }
}
