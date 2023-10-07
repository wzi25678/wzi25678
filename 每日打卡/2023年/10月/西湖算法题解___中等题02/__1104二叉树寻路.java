package 西湖算法题解___中等题02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class __1104二叉树寻路 {
	/**
	 //这道题就是求已知某一节点，然后求其遍历路径。           ？？？傻逼思路

	 * @param label
	 * @return
	 */
	public List<Integer> pathInZigZagTree(int label) {
		//数学方法，因为只是要你求出所有的父节点路径的储存值。
		int row = 1,rowStart = 1;
		while (rowStart * 2<= label){
			row++;
			rowStart *= 2;
		}
		if (row % 2 == 0){
			label = getReverse(label,row);
		}
		List<Integer> path = new ArrayList<Integer>();
		while (row > 0){
			if (row % 2 == 0){
				path.add(getReverse(label,row));
			}else {
				path.add(label);
			}
			row--;
			label >>= 1;
		}
		Collections.reverse(path);
		return path;
	}

	/**
	 *
	 * @param label
	 * @param row
	 * @return
	 */
	private int getReverse(int label, int row) {    //数值没变，还是那些数，但是顺序变了。
		return (1<<row-1)+(1<<row)-1-label;
	}
}
