package 日常Java程序测试.代码随想录.数组;

import java.util.LinkedList;
import java.util.List;

public class __54螺旋矩阵 {
	/**
	 *
	 * @param matrix
	 * @return
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new LinkedList<Integer>();
		//int res [] =new int [matrix.length * matrix[0].length];
		int index = 0;
		int up = 0,down = matrix.length-1,left = 0,right = matrix[0].length-1;
		while (index <= matrix.length * matrix[0].length - 1){
			for (int i = left;i<=right;i++){
				res.add(matrix[up][i] ) ;
				index++;
			}
			up++;
			if(up > down){
				break;
			}
			for (int i = up;i<=down;i++){
				res.add(matrix[i][right]) ;
				//res[index] = matrix[i][right] ;
				index++;
			}
			right--;
			if(right < left){
				break;
			}
			for (int i = right;i>=left;i--){
				res.add(matrix[down][i] ) ;
				//res[index] = matrix[down][i] ;
				index++;
			}
			down--;
			if(down < up){
				break;
			}
			for (int i = down;i>=up;i--){
				res.add(matrix[i][left] ) ;
				//res[index] = matrix[i][left] ;
				index++;
			}
			left++;
			if(left > right){
				break;
			}
		}
		return res;
	}
}
