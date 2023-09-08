package 西湖算法题解___中等题;

import java.util.Comparator;
import java.util.PriorityQueue;

public class __378有序矩阵中第K小的元素__归并排序 {
	public int kthSmallest(int[][] matrix, int k) {
		PriorityQueue<int []> priorityQueue = new PriorityQueue<int []>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		//--------------------------------------------------------------------------
		int n = matrix.length;
		for (int i = 0;i<n;i++){
			priorityQueue.offer(new int[]{matrix[i][0],i,0});
		}
		//--------------------------------------------------------------------------
		for (int i = 0;i<k-1;i++){
			int  now [] = priorityQueue.poll();
			if (now[2] != n -1){
				priorityQueue.offer(new int[]{matrix[now[1]][now[2] + 1],now[1],now[2]+1});
			}
		}
		return priorityQueue.poll()[0];
	}
}
