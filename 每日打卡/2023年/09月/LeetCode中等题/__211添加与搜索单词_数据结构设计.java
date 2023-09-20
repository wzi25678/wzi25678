package LeetCode中等题;

public class __211添加与搜索单词_数据结构设计 {


    class WordDictionary {
        private Trie root;

        public WordDictionary() {
            root  = new Trie();
        }

        public void addWord(String word) {
            root.insert(word);
        }

        public boolean search(String word) {
            return dfs(word,0,root);
        }

        /**
         *
         * @param word
         * @param index
         * @param curNode
         * @return
         */
        private boolean dfs(String word, int index, Trie curNode) {
            if (index == word.length()){
                return curNode.isEnd();       //curNode.isEnd是去调Trie里面的isEnd属性
            }
            char ch = word.charAt(index);
            if (Character.isLetter(ch)){        //如果已经包含当前字典序开头元素
                int childIndex = ch - 'a';
                /**
                 *
                 * 下面这行代码。他妈的是什么东西啊？？？？？？？？？？？？
                 *
                 */
                Trie child = curNode.getChildren()[childIndex];
                /**
                 *
                 *
                 *
                 *
                 *
                 *
                 */
                if (child != null && dfs(word,index+1,child)){
                    return true;
                }
            }else {
                for (int i=0;i<26;i++){
                    Trie child = curNode.getChildren()[i];
                    if (child != null  && dfs(word,index+1,child)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    //创建一个【字典树】类
    class Trie{
        private Trie[] children;
        private  boolean isEnd;

        public Trie(){
            children = new Trie[26];    //字典树链表位26个字母
            isEnd = false;  //每个都默认看看是不是尾部
        }

        /**
         *
         * @param word
         */
        public void insert(String word){
            Trie node = this;
            for (int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                int  index = ch -'a';       //用数字带指代26个字母索引
                if (node.children[index] == null){
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        /**
         *  生成对应的默认构造器
         */
        public Trie[] getChildren(){
            return children;
        }
        public boolean isEnd() {
            return isEnd;
        }
    }









}

