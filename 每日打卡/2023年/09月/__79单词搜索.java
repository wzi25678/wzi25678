package 西湖算法题解___中等题;

public class __79单词搜索 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		int row_h = board.length,col_w = board[0].length;
		boolean[][] visited = new boolean[row_h][col_w];
		for (int i=0;i<row_h;i++){
			for (int j=0;j<col_w;j++){
				//顺序遍历每个元素
				boolean flag = checkWordExplore(board,visited,i,j,word,0);
				if (flag){
					return true;
				}//对每一个元素去判断，看看是否满足能够实现all ac
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
	 * @param s_word
	 * @param k_index
	 * @return
	 */
	private boolean checkWordExplore(char[][] board, boolean[][] visited, int i, int j, String s_word, int k_index) {
		//s_word用于对应需要的单词，k_index用于对应需要其中的第几个单词
		if (board[i][j] != s_word.charAt(k_index)){       //上来先对比一下元素是否满足对应，对应则往下走，不对应，则跳出循环
			return false;
		} else if (k_index == s_word.length()) {    //如果坚持到了这里，那么说明全部都通过AC了
			return true;
		}
		//--------------------------------------------------------------------------------------------------------------
		//接下来才是回溯的重头戏
		visited[i][j] = true;
		int directions [][] = {{0,1},{0,-1},{1,0},{-1,0}};
		boolean result = false;
		for (int dir[] : directions){   //去尝试每一个方向
			int new_i = i+dir[0],new_j = j+dir[1];
			if (new_i >= 0 && new_i < board.length && new_j >= 0  && new_j < board[0].length){      //不能越界
				if (!visited[new_i][new_j]){    //这个元素要求没被访问过
					boolean flag = checkWordExplore(board,visited,new_i,new_j,s_word,k_index+1);  //一路向下
					if (flag){
						result = true;
						break;
					}
				}
			}
		}
		visited[i][j] = false;
		return result;

	}
}
