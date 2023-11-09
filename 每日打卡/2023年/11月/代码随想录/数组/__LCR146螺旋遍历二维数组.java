package 日常Java程序测试.代码随想录.数组;

import java.util.LinkedList;
import java.util.List;

public class __LCR146螺旋遍历二维数组 {
	/**
	 *
	 * @param array
	 * @return
	 */
	public int[] spiralArray(int[][] array) {
		//List<Integer> res = new LinkedList<Integer>();
		if (array.length == 0){
			return null;
		}
		if (array.length < 1 && array[0].length < 1){
			return new int[0];
		}
		int res [] =new int [array.length * array[0].length];
		int index = 0;
		int up = 0,down = array.length-1,left = 0,right = array[0].length-1;
		while (index <= array.length * array[0].length - 1){
			for (int i = left;i<=right;i++){
				//res.add(array[up][i] ) ;
				res[index] = array[up][i] ;
				index++;
			}
			up++;
			if(up > down){
				break;
			}
			for (int i = up;i<=down;i++){
				//res.add(array[i][right]) ;
				res[index] = array[i][right] ;
				index++;
			}
			right--;
			if(right < left){
				break;
			}
			for (int i = right;i>=left;i--){
				//res.add(array[down][i] ) ;
				res[index] = array[down][i] ;
				index++;
			}
			down--;
			if(down < up){
				break;
			}
			for (int i = down;i>=up;i--){
				//res.add(array[i][left] ) ;
				res[index] = array[i][left] ;
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
