package 西湖算法题解___中等题;

import java.util.*;

public class __710黑名单中的随机数 {
	//随机数中挖掉黑名单中的数，然后进行返回

	class Solution {
		Map<Integer,Integer> b2w;
		Random random;
		int bound;

		public Solution(int n, int[] blacklist) {
			b2w = new HashMap<Integer,Integer>();
			random = new Random();
			int m = blacklist.length;
			bound = n-m;
			Set<Integer> black = new HashSet<Integer>();
			for (int b : blacklist){
				if (b >= bound){
					black.add(b);
				}
			}
			int w = bound;
			for (int b:blacklist){
				if (b<bound){
					while (black.contains(w)){
						w++;
					}
					b2w.put(b,w);
					w++;
				}
			}
		}

		public int pick() {
			int x = random.nextInt(bound);
			return b2w.getOrDefault(x,x);
		}
	}
}
