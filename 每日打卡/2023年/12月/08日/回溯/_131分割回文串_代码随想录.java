package 代码随想录.回溯;

import java.util.ArrayList;
import java.util.List;

public class _131分割回文串_代码随想录 {
    List<List<String>> result = new ArrayList<List<String>>();
    List<String> subSets = new ArrayList<String>();
    /**
        假设我们当前搜索到字符串的第 iii 个字符，且 s[0..i−1] 位置的所有字符已经被分割成若干个回文串，
        并且分割结果被放入了答案数组 ans 中，那么我们就需要枚举下一个回文串的右边界 j，使得 s[i..j] 是一个回文串。

        并在未来的回溯时将 s[i..j]从ans 中移除。
     */

    /**
     * 请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
     * 即，一个串能到底拆分成多少个子串？
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        /*
        输入：s = "aab"
        输出：[["a","a","b"],["aa","b"]]
         */
        backTrack(s,0);
        return result;
    }

    /**
     *
     * @param s
     * @param startUsedIndex
     */
    private void backTrack(String s, int startUsedIndex) {
        //每次需要去从筛选出来的当前构成上一个是子集的位置，开始回溯
        //而且回溯是要往前继续走，跳过当前已经构成了回文子串的位置，探索更多的可能性

        //如果起始位置大于s的大小，已经遍历完了，返回当前这一轮寻找到的所有子集
        if (startUsedIndex >= s.length()){
            result.add(new ArrayList<>(subSets));
            return;
        }
        for (int i = startUsedIndex;i<s.length();i++){
            //判断当前选取位置的子串能否构成回文子串，如果是回文子串，则记录
            if (isPalindrome(s,startUsedIndex,i)){
                String str = s.substring(startUsedIndex,i+1);   //左开右闭，所以右边需要+1
                subSets.add(str);
            }else {
                continue;
            }
            //当前位置构造成回文子串后，还需要向后继续寻找，看看从当前位置能否构造出其他的回文子串。
            backTrack(s,i+1);
            //最后的回溯老规矩，删除结尾的节点
            subSets.remove(subSets.size()-1);
        }
    }

    /**
     * 这里就是判断一个当前位置是否是回文子串的算法，具体可以参考leetcode上的问这个的题，好像有四种方式
     * 这里我采用最暴力傻逼的方法，左右逼近判断
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindrome(String s, int left, int right) {
        for (int i = left,j = right;i<j;i++,j--){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}

