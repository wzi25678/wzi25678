package 西湖算法题解___中等题;

public class __208实现Trie前缀树 {
	class Trie {

		private Trie[] children;
		private boolean isEnd;

		public Trie() {
			children = new Trie[26];
			isEnd = false;
		}

		public void insert(String word) {
			Trie node = this;
			for (int i=0;i<word.length();i++){
				char ch = word.charAt(i);
				int index = ch -'a';
				if (node.children[index] == null){
					node.children[index] = new Trie();
				}
				node = node.children[index];
			}
			node.isEnd = true;  //标识已经结束
		}

		public boolean search(String word) {
			Trie node = searchPrefix(word); //检查当前children[]是否已经存在
			return node != null && node.isEnd;
		}

		private Trie searchPrefix(String word) {
			Trie node = this;
			for (int i=0;i<word.length();i++){
				char ch = word.charAt(i);
				int index = ch -'a';
				if (node.children[index]  == null){
					return null;
				}
				node = node.children[index];
			}
			return node;
		}

		public boolean startsWith(String prefix) {
			return searchPrefix(prefix) != null;
		}
	}
}
