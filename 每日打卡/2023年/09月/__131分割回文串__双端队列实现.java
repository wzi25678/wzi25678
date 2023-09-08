package 西湖算法题解___中等题;

import java.util.*;

public class __131分割回文串__双端队列实现 {
	public List<List<String>> partition(String s) {
		int len = s.length();
		List<List<String>>  res = new ArrayList<>();
		if (len == 0){
			return res;
		}
		//用栈去获取实现
		Deque<String> stack = new ArrayDeque<>();
		char [] charArray = s.toCharArray();
		dfs(charArray,0,len,stack,res);
		return res;
	}

	/**
	 *
	 * @param charArray
	 * @param index
	 * @param len
	 * @param path_stack
	 * @param res
	 */
	private void dfs(char[] charArray, int index, int len, Deque<String> path_stack, List<List<String>> res) {
		if (index == len){
			//开局一个很常规的判断，如果长度到了len（s.length()）则返回当前获取的一条路劲path_stack
			res.add(new ArrayList<>(path_stack));
			return;
		}
		//------------------------------------
		for (int i=index;i<len;i++){    //每一次都从当前位置开始，想结尾遍历
			if (!checkPalindrome(charArray,index,i)){   //检查当前范围是否有回文串
				continue;
			}
			path_stack.addLast(new String(charArray,index,i+1-index));  // public String(char value[], int offset, int count)
			dfs(charArray, i + 1, len, path_stack, res);
			path_stack.removeLast();
		}
	}

	/**
	 *
	 * @param charArray
	 * @param left
	 * @param right
	 * @return
	 */
	private boolean checkPalindrome(char[] charArray, int left, int right) {
		while (left < right){
			//在当前范围内
			if (charArray[left] != charArray[right]){
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
}
