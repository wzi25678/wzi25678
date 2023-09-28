package 西湖算法题解___中等题02;

public class __1131绝对值表达式的最大值__计算曼哈顿距离__一次遍历两度统计 {
	/**
	 通过拆解绝对值，然后去计算每一个点的情况，
	    即处于该点时，arr1[i]、arr2[i]、i三者任意拼接构成的最小值，最大值的情况

	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public int maxAbsValExpr(int[] arr1, int[] arr2) {
		//一次遍历，用两个最大值max去进行统计。
		int aMin = Integer.MAX_VALUE,bMin = Integer.MAX_VALUE,cMin = Integer.MAX_VALUE,dMin = Integer.MAX_VALUE;
		int aMax = Integer.MIN_VALUE,bMax = Integer.MIN_VALUE,cMax = Integer.MIN_VALUE,dMax = Integer.MIN_VALUE;

		for (int i = 0;i< arr1.length;i++){ //同长度，一次遍历两度统计
			aMin = Math.min(aMin,arr1[i] + arr2[i]+i);
			aMax = Math.max(aMax,arr1[i] + arr2[i]+i);

			bMin = Math.min(bMin,arr1[i] + arr2[i]-i);
			bMax = Math.max(bMax,arr1[i] + arr2[i]-i);

			cMin = Math.min(cMin,arr1[i] - arr2[i]+i);
			cMax = Math.max(cMax,arr1[i] - arr2[i]+i);

			dMin = Math.min(dMin,arr1[i] - arr2[i]-i);
			dMax = Math.max(dMax,arr1[i] - arr2[i]-i);
		}
		return Math.max(Math.max((aMax - aMin),(bMax-bMin)),Math.max((cMax - cMin),(dMax-dMin)));
	}
}
