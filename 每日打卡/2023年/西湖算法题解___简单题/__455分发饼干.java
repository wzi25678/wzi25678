package 西湖算法题解___简单题;

import java.util.Arrays;

public class __455分发饼干 {
	public static void main(String[] args) {

	}

	public int findContentChildren(int[] g, int[] s) {
		int count = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		int index = 0;
		for (int i=0;i<g.length;i++){
			for (int j=index;j<s.length;j++){
				if (g[i]<=s[j]){
					count++;
					index = j+1;
					break;
				}
			}
		}
		return count;

	}
}
