package 西湖算法题解___中等题;

public class __785判断二分图__染色法     {
	/**
	 题目解释：
	    每个节点都有一个编号 0~~~n-1
	    然后一个graph[][] 二维数组，其中每个数组graph[u]，代表按编号顺序过去的，里面的内容即为与当前对应编号所连接的边有哪些。
	 */
	int color [];
	public boolean isBipartite(int[][] graph) {
		int nLength = graph.length;     //这是一个无向图
		color = new int[nLength];
		boolean flag = true;
		for (int i=0;i<nLength;i++){
			if (color[i] == 0){
				if (!dfs_isBipartite(i,1,graph)){
					flag = false;
				}
			}
		}
		return flag;
	}

	/**
	 *
	 * @param u
	 * @param c
	 * @param graph
	 * @return
	 */
	private boolean dfs_isBipartite(int u, int c, int[][] graph) {
		color[u]  = c;
		for (int i = 0;i<graph[u].length;i++){
			int node = graph[u][i];
			if (color[node] == 0) {
				if (!dfs_isBipartite(node, 3 - c, graph)) {
					return false;
				}
			} else {
					if (color[node] == c){
						return false;
					}
			}
		}
		return true;
	}
}
