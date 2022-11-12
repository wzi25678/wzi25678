
package 第四章;*/
/*
@Author Wzi
@Create_Date 2019/10/4 15:09
*
*//*


import java.util.Arrays;

public class 子矩阵最大累加和 {
    public static void main(String[] args) {
        int matrix [][] = {{-1,-1,-1}, {-1,2,2}, {-1,-1,-1}};
        System.out.println(maxSum(matrix));

    }

    private static int maxSum(int[][] matrix) {
        int beginRow = 0;   //记录行数，初始为第0行
        int max = 0;    //初试最大的子矩阵和
        int M = matrix.length;  //矩阵的列数，即矩阵有多少行
        int N = matrix[0].length;   //矩阵一行的长度，即矩阵的列数
        int sums[] = new int[N];    //按列求和？？
        while (beginRow < M){
            for (int i = beginRow;i<M;i++){     //遍历所有行
                for (int j=0;j<N;j++){
                    sums[j] += matrix[i][j];
                }
                //累加完成
                //求出sums的最大累加和子数组
                int t = Case05_MaxSubArray.findByDp(sums);
                if (t>max) max = t;
            }
            Arrays.fill(sums,0);
            beginRow++;
        }
        return max;
    }

*/
/*    //找出最大的子矩阵
    public static int GetSubMatrixSum(int [][] matrix){
        if (matrix==null || matrix.length ==0 || matrix[0].length==0) return 0;
        int sum = Integer.MIN_VALUE;
        int cur = 0;
        int s [] ;
        for (int i=0;i<matrix.length;i++){
            s = new int[matrix[0].length];
        }
    }*//*

}

