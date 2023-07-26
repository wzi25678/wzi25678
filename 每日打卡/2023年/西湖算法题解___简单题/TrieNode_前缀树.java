package 西湖算法题解___简单题;

public class TrieNode_前缀树 {
	int count;  //表示以该处节点构成的串的个数
	int preCount;   //表示以该处节点构成的前缀的字串的个数
	TrieNode_前缀树 [] children;

//	public TrieNode_前缀树(int count, int preCount, TrieNode_前缀树[] children) {
//		this.count = count;
//		this.preCount = preCount;
//		this.children = children;
//	}

	 public TrieNode_前缀树(){
		children = new TrieNode_前缀树[26];
		count = 0;
		preCount = 0;
	}
}

class Trie{
	TrieNode_前缀树  root;

	public Trie(TrieNode_前缀树 root) {
		this.root = root;
	}

	public void insert(String word){
		TrieNode_前缀树 node = root;
		for (int i=0;i<word.length();i++){
			if (node.children[word.charAt(i) - 'a'] == null){
				node.children[word.charAt(i) - 'a'] = new TrieNode_前缀树();
			}

			node = node.children[word.charAt(i) - 'a'];
			node.preCount++;
		}

		node.count++;
	}//insert

	public boolean search(String word){
		TrieNode_前缀树 node = root;
		for (int i=0;i<word.length();i++){
			if (node.children[word.charAt(i) - 'a'] == null){
				return  false;
			}
			node = node.children[word.charAt(i) - 'a'];
		}
		return node.count > 0;
	}//search

	public boolean startsWith(String prefix){
		TrieNode_前缀树 node = root;

		for (int i=0;i<prefix.length();i++){
			if (node.children[prefix.charAt(i) - 'a'] ==null){
				return false;
			}
			node = node.children[prefix.charAt(i) - 'a'];
		}

		return node.preCount >0;
	}//startsWith

}



