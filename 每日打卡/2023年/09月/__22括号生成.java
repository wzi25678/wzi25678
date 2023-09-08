package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.List;

public class __22括号生成 {
	public List<String> generateParenthesis(int n) {
		List<String> res = new ArrayList<>();
		//特判
		if (n == 0){
			return res;
		}

		//执行深度优先遍历
		dfs("",n,n,res);
		return res;
	}

	private void dfs(String curStr, int left,int right, List<String> res) {
		if (left ==0 && right ==0){
			res.add(curStr);
			return;
		}

		if (left >right){
			return;
		}

		if (left > 0){
			dfs(curStr+"(",left-1,right,res);
		}

		if (right > 0){
			dfs(curStr+")",left,right-1,res);
		}


	}
}
