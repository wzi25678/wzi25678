package 西湖算法题解___中等题;

import java.util.Arrays;

public class __378有序矩阵中第K小的元素__直接排序 {
	public int kthSmallest(int[][] matrix, int k) {
		/*
		给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
		请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。


		 */
		int rows = matrix.length;   //行row
		int cols = matrix[0].length;    //列col
		int sorted [] = new int[rows * cols];   //组合成一排数组，进行排序
		int index = 0;
		for (int row [] : matrix){      //每次获取matrix里的int row [] 数据
			for (int num : row){    //同时再在每一行row[]获取到每一个数
				sorted[index++] = num;
			}
		}
		Arrays.sort(sorted);
		return sorted[k-1];
	}
}
