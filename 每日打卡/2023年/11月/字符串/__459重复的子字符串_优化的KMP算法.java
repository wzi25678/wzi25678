package 代码随想录.字符串;

import java.util.Arrays;

public class __459重复的子字符串_优化的KMP算法 {
    public boolean repeatedSubstringPattern(String s) {
        //确定一个固定的长度的字符串，去kmp配对另一个相同长度的字符串。
        return myKMP(s);    //这道题的原本是判别s是否是由某组字符重复构成
    }

    /**
     *
     * @param pattern
     * @return
     */
    private boolean myKMP(String pattern) {
       int n = pattern.length();
       int [] fail = new int[n];
       Arrays.fill(fail,-1);
       for (int i = 1;i<n;i++) {
           int j = fail[i-1];
           while (j!= -1 && pattern.charAt(j+1)!= pattern.charAt(i)){
               j = fail[j];
           }
           if (pattern.charAt(j+1) == pattern.charAt(i)){
               fail[i] = j +1;
           }
       }
       return fail[n-1] != -1 && n%(n- fail[n-1] - 1) == 0 ;
    }

}
