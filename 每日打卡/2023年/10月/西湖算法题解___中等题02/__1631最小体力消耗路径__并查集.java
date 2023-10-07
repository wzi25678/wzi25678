package 西湖算法题解___中等题02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class __1631最小体力消耗路径__并查集 {
	/**
	 *
	 * @param heights
	 * @return
	 */
	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		List<int []> edges = new ArrayList<int []>();
		for (int i=0;i<m;i++){
			for (int j=0;j<n;j++){
				int idSite = i * n + j;
				if (i > 0){
					edges.add(new int[]{idSite - n,idSite,Math.abs(heights[i][j] - heights[i - 1][j])});
				}
				if (j > 0){
					edges.add(new int[]{idSite - 1, idSite, Math.abs(heights[i][j] - heights[i][j - 1])});
				}
			}
		}
		Collections.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] edges1, int[] edges2) {
				return edges1[2] - edges2[2];
			}
		});
		UnionFind__并查集模版 unionFind__并查集模版 = new UnionFind__并查集模版(m*n);
		int res = 0;
		for (int [] edge : edges){
			int x = edge[0],y = edge[1],v = edge[2];
			unionFind__并查集模版.unite(x,y);
			if (unionFind__并查集模版.connected(0,m*n-1)){
				res = v;
				break;
			}
		}
		return res;
	}
}
