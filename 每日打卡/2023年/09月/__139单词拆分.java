package 西湖算法题解___中等题;

import java.util.List;

public class __139单词拆分 {
	//类似背包问题
	public boolean wordBreak(String s, List<String> wordDict) {
		int n = s.length();
		//area[i]，表示s中索引为[0,i-1]范围的字符串是否可以被wordDict拆分
		boolean[] area = new boolean[n+1];
		area[0] = true;
		for (int i=1;i<=n;i++){ //给dp数组赋值
			for (int j=0;j<i;j++){  //每个都找[0,i-1]范围的字符串
				//[0,i-1]的字符串可以被拆分，当且仅当任一子串[0,j-1]及[j,i-1]可以被拆分
				//因为area[0] = true;
				//不记录到底用谁去表示，只记录是否可以被表示
				if (area[j] && wordDict.contains(s.substring(j,i))){
					area[i] = true;
					break;
				}
			}
		}
		return area[n];
	}
}
