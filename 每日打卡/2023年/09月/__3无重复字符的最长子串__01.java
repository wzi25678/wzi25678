package 西湖算法题解___中等题;

import java.util.HashSet;
import java.util.Set;

public class __3无重复字符的最长子串__01 {
	public static void main(String[] args) {

	}

	public int lengthOfLongestSubstring(String s) {
		Set<Character> Occur = new HashSet<Character>();
		int n = s.length();
		// 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
		int rk = -1,ans = 0;
		for (int i=0;i<n;i++){
			if (i !=0){
				//左指针向右移动一格，移出一个字符
				Occur.remove(s.charAt(i-1));
			}
			while (rk + 1 < n && !Occur.contains(s.charAt(rk+1))){
				//不断地移动右指针
				Occur.add(s.charAt(rk+1));
				rk++;
			}
			//第i到rk个字符是一个”极长“的无重复字符子串
			ans = Math.max(ans,rk-i+1);
		}
		return ans;
	}


}
