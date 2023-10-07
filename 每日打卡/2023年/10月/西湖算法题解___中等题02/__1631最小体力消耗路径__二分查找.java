package 西湖算法题解___中等题02;

import java.util.LinkedList;
import java.util.Queue;

public class __1631最小体力消耗路径__二分查找 {
	public static void main(String[] args) {
		/**
		 1 <= rows, columns <= 100




		 */
	}

	private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	/**
	 *
	 * @param heights
	 * @return
	 */
	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		int left = 0,right = 999999,ans = 0;
		while (left <= right){
			int mid = (left + right) / 2;
			Queue<int []> queue = new LinkedList<int[]>();
			queue.offer(new int[]{0,0});
			boolean [] seen = new boolean[m * n];
			seen[0] = true;
			while (!queue.isEmpty()){
				int [] cell = queue.poll();
				int x = cell[0],y = cell[1];
				for (int i=0;i<4;i++){
					int nX = x+dirs[i][0];
					int nY = y+dirs[i][1];
					if (nX >= 0 && nX < m && nY >= 0 && nY <n && !seen[nX * n + nY] && Math.abs(heights[x][y] - heights[nX][nY]) <= mid){
						queue.offer(new int[]{nX,nY});
						seen[nX * n + nY] = true;
					}
				}
			}
			if (seen[m * n - 1]){
				ans = mid;
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return ans;
	}
}
