package LeetCode中等题;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class __820单词的压缩编码__存储后缀 {
    /**
     题目注解：
        就是单词意思注解，
        即：words = ["time", "me", "bell"]
        想快速记忆，我们就可以用 s = "time#bell#" 和 indices = [0, 2, 5] 。
        #代表，当前单词的结束，indices代表我开始读取单词的起始索引位置。

     简单方法：
        从头到尾计算，然后的话，就是当计算第一个的时候，如果当前单词又为后续单词的开头，那么我又可以再开一个索引号。
        然后同时我还需要记住，构建的时候用#强制结尾，然后最后需要返回的只是我构建出来的模糊匹配的长度。

     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        //输入：words = ["time", "me", "bell"]

        //构造一个去重Set集合childTab，避免掉重复单词，然后按顺序构成一个链表List
        Set<String> childTab = new HashSet<String>(Arrays.asList(words));
        for (String word:words){
            for (int k=1;k< word.length();k++){
                //    移出掉0-k
                childTab.remove(word.substring(k));
            }
        }
        int res = 0;
        for (String word:childTab){
            res+=word.length()+1;
        }
        return res;
    }

}
