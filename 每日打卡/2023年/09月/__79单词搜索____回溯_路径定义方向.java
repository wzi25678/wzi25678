package 西湖算法题解___中等题;

public class __79单词搜索____回溯_路径定义方向 {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		int m_hang = board.length,n_lie = board[0].length;
		boolean[][] visited = new boolean[m_hang][n_lie];   //定义一个同样的数组大小，去检测每个元素位置是否被访问
		for (int i=0;i<m_hang;i++){
			for (int j=0;j<n_lie;j++){
				//顺序遍历每一个元素
				boolean flagSatisify = checkWordExploreOK(board,visited,i,j,word,0);
				//对每一个元素，进行探索，生成一个checkWordExploreOK，判断是否满足
				if  (flagSatisify){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 *
	 * @param board
	 * @param visited
	 * @param i
	 * @param j
	 * @param word_String
	 * @param k_index
	 * @return
	 */
	private boolean checkWordExploreOK(char[][] board, boolean[][] visited, int i, int j, String word_String, int k_index) {
		//word_length用于对应需要的单词，k_index用于对应需要其中的第几个单词
		if (board[i][j] != word_String.charAt(k_index)){
			return false;
		} else if (k_index == word_String.length()-1) {
			return true;
		}
		//-------------------------------------------------------------------------
		visited[i][j] = true;
		int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
		boolean result = false;
		for (int dir[] : directions){
			int new_i = i+dir[0],new_j = j+dir[1];
			//新走的一步，对这一步去先判断合理性，再去判断其是否满足条件
			if (new_i>=0 && new_i< board.length && new_j >= 0 && new_j < board[0].length){
				if (!visited[new_i][new_j]){    //同时还要求新的位置，是没有被访问过的
					boolean flag = checkWordExploreOK(board,visited,new_i,new_j,word_String,k_index+1);
					if (flag){
						return true;
					}
				}
			}
		}
		visited[i][j] = false;
		return false;
	}


}
