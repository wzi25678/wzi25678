package 西湖算法题解___中等题;

import java.util.HashSet;
import java.util.Set;

public class __3无重复字符的最长子串 {
	public static void main(String[] args) {

	}
	public int lengthOfLongestSubstring(String s) {
		Set<Character> ifOccur = new HashSet<Character>();
		int n = s.length();
		int rk = -1,ans = 0;
		for (int i=0;i<n;i++){
			if (i != 0){
				ifOccur.remove(s.charAt(i-1));
			}
			while (rk+1 < n && !ifOccur.contains(s.charAt(rk+1))){
				ifOccur.add(s.charAt(rk+1));
				++rk;
			}
			ans = Math.max(ans,rk-i+1);
		}
	return ans;
	}
}
