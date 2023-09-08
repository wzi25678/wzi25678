package 西湖算法题解___中等题;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class __131分割回文串__动态数组实现 {
	/**
	 *
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
		int len = s.length();
		List<List<String>>  res = new ArrayList<>();
		if (len == 0){
			return res;
		}
		char [] charArray = s.toCharArray();
		//dp[i][j]，表示s[i][j]是否是回文串
		boolean[][] dp = new boolean[len][len];
		//状态转移方程：  在s[i] == s[j]的时候，dp[i][j]参考dp[i+1][j-1]
		for (int right = 0;right < len;right++){
			for (int left=0;left <= right;left++){
				if (charArray[left] == charArray[right]  && (right-left <=2 || dp[left+1][right-1])){
					dp[left][right] = true;
				}
			}
		}

		Deque<String> stack = new ArrayDeque<String>();
		dfs(s,0,len,dp,stack,res);
		return res;
	}

	/**
	 *
	 * @param s
	 * @param index
	 * @param len
	 * @param dp
	 * @param path_stack
	 * @param res
	 */
	private void dfs(String s, int index, int len, boolean[][] dp, Deque<String> path_stack, List<List<String>> res) {
		if (index == len){
			res.add(new ArrayList<>(path_stack));
			return;
		}

		for (int i=index;i<len;i++){
			if (dp[index][i]){
				path_stack.addLast(s.substring(index,i+1));
				dfs(s,i+1,len,dp,path_stack,res);
				path_stack.removeLast();
			}
		}
	}
}
