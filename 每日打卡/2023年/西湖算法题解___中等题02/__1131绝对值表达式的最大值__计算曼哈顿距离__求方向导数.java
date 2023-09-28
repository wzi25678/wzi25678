package 西湖算法题解___中等题02;

public class __1131绝对值表达式的最大值__计算曼哈顿距离__求方向导数 {
	int [][] dirs = {{1,1,1},{-1,1,1},{-1,-1,1},{1,-1,1},{1,1,-1},{-1,1,-1},{-1,-1,-1},{1,-1,-1}};  //定义出八种abs拆解情况
	/**
	 *
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int maxAbsValExpr(int[] arr1, int[] arr2) {
		int maxValue = 0;
		int n = arr1.length;
		for (int [] dir:dirs){  //选择其中的某一个方向
			//定义最大值，最小值出来，进行方向判断的赋值
			int maxPoint = Integer.MIN_VALUE,minPoint  = Integer.MAX_VALUE;
			for (int i=0;i<n;i++){  //八个方向全部去进行统计，然后得出在某点出会得到的最大值
				maxPoint = Math.max(maxPoint,arr1[i]*dir[0] + arr2[i]*dir[1] + i*dir[2]);
				minPoint = Math.min(minPoint,arr1[i]*dir[0] + arr2[i]*dir[1] + i*dir[2]);
			}
			maxValue = Math.max(maxValue,maxPoint-minPoint);
			//每个方向都去进行最大值的判断
		}
		return maxValue;
	}
}
