package LeetCode中等题;

import java.util.HashMap;
import java.util.Map;

public class __1297子串的最大出现次数__滑动窗口_哈希表 {
    /**


     *
     * @param s
     * @param maxLetters
     * @param minSize
     * @param maxSize
     * @return
     */
    public int maxFreq(String s,int maxLetters,int minSize,int maxSize){
        int n = s.length();
        //统计子串出现的个数
        Map<String,Integer> map = new HashMap<String,Integer>();
        char [] ch = s.toCharArray();
        int left = 0,right = 0;
        //统计窗口中不同字母的数目
        int temp  = 0;
        //记录窗口中字母的个数
        int [] count = new int[128];
        while (right < n){
            count[ch[right]] ++;
            //当下面条件成立时，则说明窗口中多了一个不同的字母
            if (count[ch[right]] == 1){
                temp++;
            }
            right++;
            int len = right - left;
            while (temp > maxLetters || len > minSize){
                count[ch[left]] --;
                //当窗口左移的过程中，一个字母减为0，则说明窗口中少了一个不同的字母
                if (count[ch[left]] == 0){
                    temp--;
                }
                left++;
                len--;
            }
            //当不同字母的数目小于等于maxLetters时
            if (temp <= maxLetters){
                if (len == minSize){
                    String str = s.substring(left,right);
                    map.put(str,map.getOrDefault(str,0) + 1);
                }
            }
        }
        //统计字串最大出现的次数
        int ans = 0;
        for (String key : map.keySet()){
            ans = Math.max(ans,map.get(key));
        }
        return ans;
    }
}
