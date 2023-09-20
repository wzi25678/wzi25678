package LeetCode中等题;

import java.util.HashMap;
import java.util.Map;

public class __820单词的压缩编码__字典前缀树 {

    public int minimumLengthEncoding(String[] words) {
        DictTrieNode dictTrie = new DictTrieNode();
        Map<DictTrieNode,Integer> nodes = new HashMap<DictTrieNode,Integer>();
        for (int i=0;i< words.length;i++){
            String word = words[i];
            //一个words里面的元素，作为一个单独的字典去进行计算，然后如果单词寻找的过程中，
            //我发现如果有计算到重复元素的话，那么就可以给他单独再开一个位置去index出来。
            DictTrieNode cur = dictTrie;
            for (int j = word.length()-1;j>=0;j--){
                cur = cur.getChildren(word.charAt(j));
            }
            nodes.put(cur,i);
        }
        int res = 0;
        for (DictTrieNode node: nodes.keySet()){    // // 使用 keySet() 方法获取键的集合
            if (node.count == 0){
                res+=words[nodes.get(node)].length() + 1;
            }
        }
        return res;
    }

    class DictTrieNode{     //就像前面提到的，字母一共就只有26个，那么你可以尝试选择构造一个包含有26个单词的数组去进行二叉树的遍历尝试。
        DictTrieNode[] children;
        int count;

        DictTrieNode(){
            children = new DictTrieNode[26];
            count = 0;
        }

        public DictTrieNode getChildren(char c) {
            if (children[c - 'a'] == null){
                children[c - 'a'] = new DictTrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }

}
