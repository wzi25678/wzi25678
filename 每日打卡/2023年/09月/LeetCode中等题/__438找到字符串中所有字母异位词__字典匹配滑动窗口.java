package LeetCode中等题;

import java.util.ArrayList;
import java.util.List;

public class __438找到字符串中所有字母异位词__字典匹配滑动窗口 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(),pLen = p.length();
        if (sLen < pLen){
            return new ArrayList<Integer>();
        }

        List<Integer> res = new ArrayList<>();  //最终答案记录的是索引下标
        int countDict[] = new int[26];
        for (int i=0;i<pLen;i++){
            ++countDict[s.charAt(i) - 'a'];
            --countDict[p.charAt(i) - 'a'];
        }
        int differ = 0;
        for(int j=0;j<26;j++){
            if (countDict[j] != 0){
                ++differ;
            }
        }
        if (differ == 0){
            res.add(0);
        }
        for (int i=0;i<sLen - pLen;i++){
            if (countDict[s.charAt(i) - 'a'] == 1){
                --differ;
            } else if (countDict[s.charAt(i) - 'a'] == 0) {
                ++differ;
            }
            --countDict[s.charAt(i) - 'a'];
            if (countDict[s.charAt(i+pLen) - 'a'] == -1){
                --differ;
            } else if (countDict[s.charAt(i+pLen) - 'a'] == 0) {
                ++differ;
            }
            ++countDict[s.charAt(i+pLen)  - 'a'];
            if (differ == 0){
                res.add(i+1);
            }
        }
        return res;
    }

}
