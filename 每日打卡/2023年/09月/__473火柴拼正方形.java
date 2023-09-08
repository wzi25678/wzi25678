package 西湖算法题解___中等题;

import java.util.Arrays;

public class __473火柴拼正方形 {
	//你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒
	public boolean makesquare(int[] matchsticks) {
		int sum = 0;
		int nLength = matchsticks.length;
		if (nLength<4){
			return false;
		}
		sum = Arrays.stream(matchsticks).sum(); //调用Arrays.stream去进行求和。
		for (int num:matchsticks){
			sum+=num;
		}
		if (sum%4 != 0){
			return false;
		}
		//接下来就是将数组顺序化，然后进行匹配，看是否每次都能找到满足边长要求的对应长度的【数组元素和】去累加获取。
		Arrays.sort(matchsticks);
		for (int i=0,j = matchsticks.length-1;i<j;i++,j--){
			if (matchsticks[j] > sum/4){    //如果最后的元素，甚至大于总数的四分之一，肯定组成不了正方形了。
				return false;
			}
			int temp = matchsticks[i];
			matchsticks[i] = matchsticks[j];
			matchsticks[j] = temp;
		}
		int edges [] = new  int[4];
		return dfs_makesquare(0,matchsticks,edges,sum/4);
	}

	/**
	 *
	 * @param index
	 * @param matchsticks
	 * @param edges
	 * @param meanLen
	 * @return
	 */
	private boolean dfs_makesquare(int index, int[] matchsticks, int[] edges, int meanLen) {
		if (index == matchsticks.length){
			return true;
		}
		for (int i=0;i<edges.length;i++){
			edges[i] += matchsticks[index];
			if (edges[i] <= meanLen && dfs_makesquare(index+1,matchsticks,edges,meanLen)){
				return true;
			}
			edges[i] -= matchsticks[index];
		}
		return false;
	}
}
