package 代码随想录.字符串;

import java.util.Arrays;

public class __459重复的子字符串_KMP算法 {
    public boolean repeatedSubstringPattern(String s) {
        //确定一个固定的长度的字符串，去kmp配对另一个相同长度的字符串。
        return myKMP(s+s,s);    //这道题的原本是判别s是否是由某组字符重复构成
    }

    /**
     *
     * @param query
     * @param pattern
     * @return
     */
    private boolean myKMP(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();
        int  [] fail = new int[m];
        Arrays.fill(fail,-1);
        for (int i = 1;i<m;i++){
            int j = fail[i-1];
            while (j != -1 && pattern.charAt(j+1)!= pattern.charAt(i)){
                j = fail[j];
            }
            if (pattern.charAt(j+1) == pattern.charAt(i)){
                fail[i] = j +1;
            }
        }
        int match = -1;
        for (int i = 1;i<n-1;i++){
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)){
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)){
                match++;
                if (match == m-1){
                    return true;
                }
            }
        }
        return false;
    }
}
